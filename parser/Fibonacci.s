      .file   "Fibonacci.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_computeFib:
       pushq %rbp
       movq %rsp, %rbp
       subq $624, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
    L2:
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L4
       jmp L3
    L3:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L1
       jmp L9
    L9:
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $624, %rsp
       popq %rbp
       ret
    L4:
    L5:
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq $1, %rbx
       movq %rbx, %rax
       jmp L1
       jmp L8
    L8:
       jmp L9
    L7:
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _computeFib
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r13
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $2, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _computeFib
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L1
       jmp L8
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $96, %rsp
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -8(%rbp), %rsi
       movq $0, %rax
       call _scanf
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       popq %rax
       movq -8(%rbp), %rbx
       movq %rbx, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _computeFib
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
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
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq $0, %rbx
       movq %rbx, %rax
       jmp L10
   L10:
       addq $96, %rsp
       popq %rbp
       ret
