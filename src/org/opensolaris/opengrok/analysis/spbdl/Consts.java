package org.opensolaris.opengrok.analysis.spbdl;

import java.util.HashSet;
import java.util.Set;

/**
  * Holds static hash set containing the BDL keywords
  */
public class Consts {
    public static final Set<String> kwd = new HashSet<String>() ;
    static {
        kwd.add( "all" );
        kwd.add( "begin" );
        kwd.add( "benchmark" );
        kwd.add( "rndbin" );
        kwd.add( "chr" );
        kwd.add( "commit" );
        kwd.add( "database" );
        kwd.add( "dclrand" );
        kwd.add( "dcltrans" );
        kwd.add( "dcluser" );
        kwd.add( "dclsql" );
        kwd.add( "do" );
        kwd.add( "else" );
        kwd.add( "end" );
        kwd.add( "eos" );
        kwd.add( "exit" );
        kwd.add( "rndexpf" );
        kwd.add( "rndexpn" );
        kwd.add( "fetch" );
        kwd.add( "for" );
        kwd.add( "rndunin" );
        kwd.add( "rndstr" );
        kwd.add( "rndunii" );
        kwd.add( "rndunif" );
        kwd.add( "if" );
        kwd.add( "in" );
        kwd.add( "init" );
        kwd.add( "into" );
        kwd.add( "rndind" );
        kwd.add( "last" );
        kwd.add( "rndsno" );
        kwd.add( "loop" );
        kwd.add( "mod" );
        kwd.add( "next" );
        kwd.add( "not" );
        kwd.add( "ord" );
        kwd.add( "out" );
        kwd.add( "return" );
        kwd.add( "rollback" );
        kwd.add( "row" );
        kwd.add( "set" );
        kwd.add( "stored" );
        kwd.add( "then" );
        kwd.add( "transaction" );
        kwd.add( "transactions" );
        kwd.add( "unique" );
        kwd.add( "user" );
        kwd.add( "var" );
        kwd.add( "wait" );
        kwd.add( "while" );
        kwd.add( "result" );
        kwd.add( "to" );
        kwd.add( "or" );
        kwd.add( "and" );
        kwd.add( "of" );
        kwd.add( "array" );
        kwd.add( "write" );
        kwd.add( "writeln" );
        kwd.add( "rows" );
        kwd.add( "rc" );
        kwd.add( "const" );
        kwd.add( "dclfunc" );
        kwd.add( "function" );
        kwd.add( "rndpern" );
        kwd.add( "reset" );
        kwd.add( "rndfile" );
        kwd.add( "elseif" );
        kwd.add( "rndstream" );
        kwd.add( "select" );
        kwd.add( "insert" );
        kwd.add( "update" );
        kwd.add( "delete" );
        kwd.add( "current" );
        kwd.add( "proc" );
        kwd.add( "inout" );
        kwd.add( "dll" );
        kwd.add( "cursor" );
        kwd.add( "sql" );
        kwd.add( "ptr" );
        kwd.add( "use" );
        kwd.add( "halt" );
        kwd.add( "dclform" );
        kwd.add( "form" );
        kwd.add( "sizeof" );
        kwd.add( "optional" );
        kwd.add( "dclevent" );
        kwd.add( "handler" );
        kwd.add( "throw" );
        kwd.add( "dstring" );
        kwd.add( "dclparam" );
        kwd.add( "lenspec" );
        kwd.add( "sizespec" );
        kwd.add( "allownull" );
        kwd.add( "explicit" );
        kwd.add( "union" );
        kwd.add( "bin" );
        
        // data types
        kwd.add( "number" );
        kwd.add( "boolean" );
        kwd.add( "string" );
        kwd.add( "float" );
        kwd.add( "list" );
        kwd.add( "long" );
        kwd.add( "short" );
        kwd.add( "char" );
        kwd.add( "unsigned" );
        kwd.add( "void" );
        kwd.add( "double" );

        // function keywords
        kwd.add( "transaction" );
        kwd.add( "function" );
        
        // constants
        kwd.add( "true" );
        kwd.add( "false" );
    }
}
