	.section	__TEXT,__text,regular,pure_instructions
	.globl	_func
	.align	4, 0x90
_func:                                  ## @func
	.cfi_startproc
## BB#0:
	pushq	%rbp                           ## push base pointer onto the stack
Ltmp2:
	.cfi_def_cfa_offset 16
Ltmp3:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp                     ## Copy the stack pointer to the base pointer
Ltmp4:
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)                 ## put x argument onto the stack
	movq	$2, -16(%rbp)                  ## move the number 2 onto our stack
	movq	$3, -24(%rbp)                  ## move the number 3 onto our stack
	movq	-24(%rbp), %rdi                ## move the number 3 into dest register
	imulq	-8(%rbp), %rdi                 ## x * 3, put in dest register
	addq	-16(%rbp), %rdi                ## dest register + 2
	movq	%rdi, %rax                     ## move dest register to return register
	popq	%rbp                           ## get the base pointer from stack
	ret                                  ## return
	.cfi_endproc


.subsections_via_symbols
