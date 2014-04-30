package jbilous.support.assembly;

public enum AssemblyRegister {
	RAX("%rax"), RBX("%rbx"), RCX("%rcx"), RDX("%rdx"),
	RSI("%rsi"), RDI("%rdi"),
	RBP("%rbp"), RSP("%rsp"),
	R8("%r8"), R9("%r9"), R10("%r10"), R11("%r11"), 
	R12("%r12"), R13("%r13"), R14("%r14"), R15("%r15");

	private final String name;
	private AssemblyRegister(String s) {
		name = s;
	}
	public String toString() {
		return name;
	}
}