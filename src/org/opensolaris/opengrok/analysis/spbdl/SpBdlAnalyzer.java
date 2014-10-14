package org.opensolaris.opengrok.analysis.spbdl;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.opensolaris.opengrok.analysis.Definitions;
import org.opensolaris.opengrok.analysis.FileAnalyzerFactory;
import org.opensolaris.opengrok.analysis.JFlexTokenizer;
import org.opensolaris.opengrok.analysis.JFlexXref;
import org.opensolaris.opengrok.analysis.spbdl.SpBdlXref;
import org.opensolaris.opengrok.analysis.plain.AbstractSourceCodeAnalyzer;
import org.opensolaris.opengrok.configuration.Project;
import org.opensolaris.opengrok.history.Annotation;

public class SpBdlAnalyzer extends AbstractSourceCodeAnalyzer {

	protected SpBdlAnalyzer(FileAnalyzerFactory factory) {
        super(factory);
    }

    @Override
    protected JFlexTokenizer newSymbolTokenizer(Reader reader) {
        return new SpBdlSymbolTokenizer(reader);
    }

    @Override
    protected JFlexXref newXref(Reader reader) {
        return new SpBdlXref(reader);
    }

    static void writeXref(Reader in, Writer out, Definitions defs, Annotation annotation, Project project) throws IOException {
    	SpBdlXref xref = new SpBdlXref(in);
        AbstractSourceCodeAnalyzer.writeXref(xref, in, out, defs, annotation, project);
    }

}
