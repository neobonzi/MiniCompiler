      .file   "6.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%d\n\0"
      .text
      .globl _main
 _main:
       pushq %rbp
       movq %rsp, %rbp
       movq $1253, %r14
       movq %r14, %rbx
       movq $6993, %r13
       movq %r13, r18
       movq %r10, 0(%rbp)
       movq $515, %r12
       movq %r12, r19
       movq %r10, 0(%rbp)
       movq $1, %rbp
       movq %rbp, r20
       movq %r10, 0(%rbp)
       movq %rbx, %rbx
       movq 8(%rbp), %r10
       movq %r10, %rip
       movq %rbx, %rdx
       addq %rip, %rdx
       movq 8(%rbp), %r10
       movq %r10, %r15
       movq %rdx, %rcx
       addq %r15, %rcx
       movq 8(%rbp), %r10
       movq %r11, 0(%rbp)
       movq %r10, r31
       movq %r10, 0(%rbp)
       movq %rcx, %r9
       movq 8(%rbp), %r10
       addq %r10, %r9
       movq %r9, %r8
       movq 8(%rbp), %r10
       movq %r10, %rbx
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       movq 8(%rbp), %r10
       movq %r10, %r15
       movq %r15, %rax
    L1:
       popq %rbp
       ret
