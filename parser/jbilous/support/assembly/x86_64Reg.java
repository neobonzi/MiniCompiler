package jbilous.support.assembly;

import jbilous.support.Register;

public enum x86_64Reg{
	RAX("%rax"), RBX("%rbx"), RCX("%rcx"), RDX("%rdx"),
	RSI("%rsi"), RDI("%rdi"),
	RBP("%rbp"), RSP("%rsp"),
	R8("%r8"), R9("%r9"), R10("%r10"), R11("%r11"), 
	R12("%r12"), R13("%r13"), R14("%r14"), R15("%r15"),
	RIP("%rip");

	private final String name;
	private x86_64Reg(String s) {
		name = s;
	}
	public String toString() {
		return name;
	}
}