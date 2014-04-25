import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        MiniLexer lex = new MiniLexer(new ANTLRFileStream("/Users/jbilous/Development/CSC431/parser/4.mini", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        MiniParser g = new MiniParser(tokens, 49100, null);
        try {
            g.program();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}