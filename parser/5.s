      .file   "5.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $216, %rsp
       movq $1000, %r11
       movq %r11, -16(%rbp)
       movq $2, %r12
       movq $0, %rbx
       movq -16(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L2:
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq -16(%rbp), %r10
       movq %r10, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq $2, %r11
       movq %r11, -24(%rbp)
       pushq %rdx
       pushq %rax
       movq -16(%rbp), %r10
       movq %r10, %rax
       movq $0, %rdx
       cqto
       movq -24(%rbp), %r10
       idivq %r10
       movq %rax, %r11
       movq %r11, -32(%rbp)
       popq %rax
       popq %rdx
       movq $0, %r11
       movq %r11, -40(%rbp)
       movq -32(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r11
       movq %r11, -40(%rbp)
       popq %r8
       movq -40(%rbp), %r11
       cmpq $1, %r11
       jne L3
       jmp L2
    L3:
       movq $0, %r11
       movq %r11, -48(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %rax
       jmp L1
    L1:
       addq $216, %rsp
       popq %rbp
       ret
