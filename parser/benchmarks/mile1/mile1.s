      .file   "benchmarks/mile1/mile1.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_calcPower:
       pushq %rbp
       movq %rsp, %rbp
       subq $280, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq %rsi, %r15
       movq $1, %rbx
       movq %rbx, %r14
       movq %r15, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L2:
       movq %r14, %r12
       movq -48(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L3:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $280, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $728, %rsp
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -8(%rbp)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -16(%rbp), %rsi
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
       movq -16(%rbp), %r11
       movq %r11, -24(%rbp)
       movq -24(%rbp), %r10
       movq %r10, %rbx
       movq -8(%rbp), %r11
       movq %r11, -8(%rbp)
       movq %rbx, 0(%r11)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -40(%rbp), %rsi
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
       movq -40(%rbp), %r11
       movq %r11, -24(%rbp)
    L5:
       movq -24(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -56(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq $1, %r12
       movq $-1, %rbx
       pushq %r8
       movq %r12, %r8
       imulq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L4
       jmp L8
    L8:
       movq -24(%rbp), %r10
       movq %r10, %rbx
       movq -8(%rbp), %r11
       movq %r11, -8(%rbp)
       movq %rbx, 8(%r11)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -72(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $1000000, %r12
       movq $0, %rbx
       movq -80(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L10
       jmp L9
    L9:
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -8(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %r12
       movq -8(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %r12, %rdi
       movq %rbx, %rsi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _calcPower
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -96(%rbp)
       movq -72(%rbp), %r10
       movq %r10, -104(%rbp)
       movq %r10, %r10
       movq $1000000, %r12
       movq $0, %rbx
       movq -104(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L10
       jmp L9
   L10:
       movq -96(%rbp), %r10
       movq %r10, %rbx
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
       movq $1, %rbx
       movq %rbx, %rax
       jmp L4
    L4:
       addq $728, %rsp
       popq %rbp
       ret
    L7:
       jmp L8
