package org.opensolaris.opengrok.analysis.spbdl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

import jdk.nashorn.internal.objects.annotations.Setter;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Before;
import org.junit.Test;
import org.opensolaris.opengrok.analysis.FileAnalyzer;
import org.opensolaris.opengrok.analysis.JFlexTokenizer;

public class SpBdlSymbolTokenizerTest {

	private FileAnalyzer analyzer;

    private String[] getTermsFor(String s) {
        return getTermsFor(new StringReader(s));
    }

    private String[] getTermsFor(Reader r) {
        List<String> l = new LinkedList<String>();
        JFlexTokenizer ts = (JFlexTokenizer) this.analyzer.createComponents("refs", r).getTokenStream();
        ts.yyreset(r);
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        try {
            while (ts.yylex()) {
                l.add(term.toString());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return l.toArray(new String[l.size()]);
    }

	@Before
	public void setUp() throws Exception {
		SpBdlAnalyzerFactory factory = new SpBdlAnalyzerFactory();
		analyzer = factory.getAnalyzer();
	}
	
	@Test
	public void basicTest() {
        String s = "benchmark WebBenchmarkName\nvar gnCount : number;";
        String[] termsFor = getTermsFor(s);
        assertArrayEquals(
                new String[]{"WebBenchmarkName", "gnCount"},
                termsFor);
	}

	@Test
	public void basicTestUpperCase() {
        String s = "BENCHMARK WebBenchmarkName\nVAR gnCount : NUMBER;";
        String[] termsFor = getTermsFor(s);
        assertArrayEquals(
                new String[]{"WebBenchmarkName", "gnCount"},
                termsFor);
	}

    @Test
    public void sampleTest() throws UnsupportedEncodingException {
        InputStream res = getClass().getClassLoader().getResourceAsStream(
                "org/opensolaris/opengrok/analysis/spbdl/sample.bdf");
        InputStreamReader r = new InputStreamReader(res, "ASCII");
        String[] termsFor = getTermsFor(r);
        assertArrayEquals(
                new String[]{
                		"WebBenchmarkName", // line 1
                		"gnCount", // line 17
                		"rnUniN", // line 21
                		"rsName", // line 22
                		"WebUser", // line 27
                		"TInit", // line 29
                		"TWeb", // line 30
                		"TInit", // line 35
                		"TInit", // line 39
                		"TWeb", // line 41
                		"TWeb", // line 44
                		"SAMPLE_FORM", // line 48
                		"rsName", // line 50
                },
                termsFor);
    }
}
