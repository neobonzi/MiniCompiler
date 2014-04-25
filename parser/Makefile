SUPPORTPATH = jbilous/support
FILES=$(SUPPORTPATH)/*.java
OBJECTS=$(FILES:%.java=%.class)

Mini.class : antlr.generated Mini.java $(OBJECTS)
	javac *.java

$(SUPPORTPATH)/%.class : $(SUPPORTPATH)/%.java
	javac $<

antlr.generated: antlr.generated.mini antlr.generated.type antlr.generated.cfg
	touch antlr.generated

antlr.generated.mini : Mini.g
	java org.antlr.Tool Mini.g
	touch antlr.generated.mini

antlr.generated.type : TypeCheck.g
	java org.antlr.Tool TypeCheck.g
	touch antlr.generated.type

antlr.generated.cfg : ControlFlowGraph.g
	java org.antlr.Tool ControlFlowGraph.g
	touch antlr.generated.cfg

clean:
	\rm *generated* MiniParser.java MiniLexer.java TypeCheck.java ControlFlowGraph.java ControlFlowGraph.tokens Mini.tokens TypeCheck.tokens *.class
