package org.opensolaris.opengrok.analysis.spbdl;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
                "<a class=\"l\" name=\"1\" href=\"#1\">1</a><b>benchmark</b> <a href=\"/source/s?defs=WebBenchmarkName\">WebBenchmarkName</a>"
                        + "\n"
                        + "<a class=\"l\" name=\"2\" href=\"#2\">2</a><b>var</b> <a href=\"/source/s?defs=gnCount\">gnCount</a> : <b>number</b>;",
                w.toString());
    }

    public static void writeSpBdlXref(InputStream is, PrintStream os)
            throws IOException {
        os.println("<!DOCTYPE html><html><head><meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\" /><link rel=\"stylesheet\" type=\"text/css\" "
                + "href=\"http://localhost:8080/source/default/style.css\" /><title>BDL Xref Test</title></head>");
        os.println("<body><div id=\"src\"><pre>");
        Writer w = new StringWriter();
        SpBdlAnalyzer.writeXref(new InputStreamReader(is, "UTF-8"), w, null,
                null, null);
        os.print(w.toString());
        os.println("</pre></div></body></html>");
    }

    public static void main(String args[]) throws IOException {
        InputStream is = null;
        if (args.length == 0) {
            is = SpBdlXrefTest.class.getClassLoader().getResourceAsStream(
                    "org/opensolaris/opengrok/analysis/spbdl/sample.bdf");
        } else {
            is = new FileInputStream(new File(args[0]));
        }

        writeSpBdlXref(is, System.out);
    }

    @Test
    public void sampleTest() throws IOException {
        InputStream res = getClass().getClassLoader().getResourceAsStream(
                "org/opensolaris/opengrok/analysis/spbdl/sample.bdf");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ByteArrayOutputStream baosExp = new ByteArrayOutputStream();

        try {
            writeSpBdlXref(res, new PrintStream(baos));
        } finally {
            res.close();
        }

        InputStream exp = getClass().getClassLoader().getResourceAsStream(
                "org/opensolaris/opengrok/analysis/spbdl/sample.bdf.Xref.html");

        try {
            byte buffer[] = new byte[8192];
            int read;
            do {
                read = exp.read(buffer, 0, buffer.length);
                if (read > 0) {
                    baosExp.write(buffer, 0, read);
                }
            } while (read >= 0);
        } finally {
            baosExp.close();
        }

        String gotten[] = new String(baos.toByteArray(), "UTF-8").split("\n");
        String expected[] = new String(baosExp.toByteArray(), "UTF-8")
                .split("\n");

        assertEquals(expected.length, gotten.length);

        for (int i = 0; i < gotten.length; i++) {
            assertEquals(gotten[i].trim(), expected[i].trim());
        }
    }

}