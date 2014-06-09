	.section	__TEXT,__text,regular,pure_instructions
	.globl	_doShit
	.align	4, 0x90
_doShit:                                ## @doShit
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
	subq	$64, %rsp
	leaq	L_.str(%rip), %rax
	movl	%edi, -4(%rbp)
	movl	%esi, -8(%rbp)
	movl	%edx, -12(%rbp)
	movl	%ecx, -16(%rbp)
	movl	%r8d, -20(%rbp)
	movl	%r9d, -24(%rbp)
	movl	$11, -28(%rbp)
	movl	$153, -32(%rbp)
	movl	$325353, -36(%rbp)      ## imm = 0x4F6E9
	movl	-4(%rbp), %ecx
	addl	-8(%rbp), %ecx
	subl	-28(%rbp), %ecx
	subl	-32(%rbp), %ecx
	movl	-36(%rbp), %edx
	movq	%rax, -48(%rbp)         ## 8-byte Spill
	movl	%edx, %eax
	cltd
	idivl	-12(%rbp)
	subl	%eax, %ecx
	addl	-16(%rbp), %ecx
	addl	-20(%rbp), %ecx
	subl	-24(%rbp), %ecx
	movq	-48(%rbp), %rdi         ## 8-byte Reload
	movl	%ecx, %esi
	movb	$0, %al
	callq	_printf
	movl	%eax, -52(%rbp)         ## 4-byte Spill
	addq	$64, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.globl	_main
	.align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## BB#0:
	pushq	%rbp
Ltmp7:
	.cfi_def_cfa_offset 16
Ltmp8:
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
Ltmp9:
	.cfi_def_cfa_register %rbp
	subq	$64, %rsp
	movl	$0, %eax
	leaq	L_.str(%rip), %rdi
	movl	$0, -4(%rbp)
	movl	$2, -8(%rbp)
	movl	$3, -12(%rbp)
	movl	$4, -16(%rbp)
	movl	-8(%rbp), %ecx
	addl	-12(%rbp), %ecx
	movl	%ecx, -20(%rbp)
	movl	-8(%rbp), %ecx
	subl	-12(%rbp), %ecx
	movl	%ecx, -24(%rbp)
	movl	-24(%rbp), %ecx
	addl	-20(%rbp), %ecx
	subl	-16(%rbp), %ecx
	movl	%ecx, -28(%rbp)
	movl	$9, -32(%rbp)
	movl	-24(%rbp), %ecx
	subl	-16(%rbp), %ecx
	subl	-20(%rbp), %ecx
	addl	-28(%rbp), %ecx
	subl	-32(%rbp), %ecx
	movl	%ecx, -36(%rbp)
	movl	$11, -40(%rbp)
	movl	$12, -44(%rbp)
	movl	-40(%rbp), %ecx
	addl	-44(%rbp), %ecx
	addl	-32(%rbp), %ecx
	addl	-24(%rbp), %ecx
	addl	-16(%rbp), %ecx
	movl	%ecx, %esi
	movl	%eax, -48(%rbp)         ## 4-byte Spill
	movb	$0, %al
	callq	_print
	movl	-48(%rbp), %ecx         ## 4-byte Reload
	movl	%eax, -52(%rbp)         ## 4-byte Spill
	movl	%ecx, %eax
	addq	$64, %rsp
	popq	%rbp
	ret
	.cfi_endproc

	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"%d"


.subsections_via_symbols
