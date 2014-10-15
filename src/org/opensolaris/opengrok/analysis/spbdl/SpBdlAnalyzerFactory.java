package org.opensolaris.opengrok.analysis.spbdl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.opensolaris.opengrok.analysis.Definitions;
import org.opensolaris.opengrok.analysis.FileAnalyzer;
import org.opensolaris.opengrok.analysis.FileAnalyzerFactory;
import org.opensolaris.opengrok.analysis.FileAnalyzer.Genre;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.Annotation;


public class SpBdlAnalyzerFactory extends FileAnalyzerFactory {
    private static final String[] SUFFIXES = {
        "BDF", "BDH"
    };

    public SpBdlAnalyzerFactory() {
        super(null, null, SUFFIXES, null, null, "text/plain", Genre.PLAIN);
    }

    @Override
    protected FileAnalyzer newAnalyzer() {
        return new SpBdlAnalyzer(this);
    }

    @Override
    public void writeXref(Reader in, Writer out, Definitions defs, Annotation annotation, Project project)
        throws IOException {
    	SpBdlAnalyzer.writeXref(in, out, defs, annotation, project);
    }

}
