	.section	__TEXT,__text,regular,pure_instructions
	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
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
	subq	$16, %rsp
	movabsq	$4, %rdi
	movl	$0, -4(%rbp)
	callq	_malloc
	movl	$0, %ecx
	movq	%rax, -16(%rbp)
	movq	-16(%rbp), %rax
	movl	$5, (%rax)
	movl	%ecx, %eax
	addq	$16, %rsp
	popq	%rbp
	ret
	.cfi_endproc


.subsections_via_symbols
