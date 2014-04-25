	.section	__TEXT,__text,regular,pure_instructions
	.globl	_func
	.align	4, 0x90
_func:                                  ## @func
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp2:
	.cfi_def_cfa_offset 16
Ltmp3:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp4:
	.cfi_def_cfa_register %rbp
	leaq	2(%rdi,%rdi,2), %rax          ## Uses memory addres arithmetic to multiply by 3 and add 2 to argument 
	popq	%rbp
	ret
	.cfi_endproc


.subsections_via_symbols
