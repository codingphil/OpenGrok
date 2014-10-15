package org.opensolaris.opengrok.analysis.spbdl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

public class SpBdlXrefTest {

	@Test
	public void basicTest() throws IOException {
        String s = "benchmark WebBenchmarkName\nvar gnCount : number;";
        Writer w = new StringWriter();
        SpBdlAnalyzer.writeXref(new StringReader(s), w, null, null, null);
        assertEquals(
            "<a class=\"l\" name=\"1\" href=\"#1\">1</a><b>benchmark</b> <a href=\"/source/s?defs=WebBenchmarkName\">WebBenchmarkName</a>" + "\n" +
            "<a class=\"l\" name=\"2\" href=\"#2\">2</a><b>var</b> <a href=\"/source/s?defs=gnCount\">gnCount</a> : <b>number</b>;",
            w.toString());
	}

}
