      .file   "stats.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_getRands:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq %rsi, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r14
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, 0(%r14)
       movq $0, %rbx
       movq %rbx, 8(%r14)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r13
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
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r13
       popq %rax
       popq %rdx
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $2, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       pushq %r8
       movq %rbx, %r8
       imulq %r13, %r8
       movq %r8, %r12
       popq %r8
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r15
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, 0(%r15)
       movq %r14, %rbx
       movq %rbx, 8(%r15)
       movq %r15, %rbx
       movq %rbx, %r14
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r13
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
       movq %r15, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_calcMean:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $0, %rbx
       movq %rbx, %r15
       movq $0, %rbx
       movq %rbx, %r14
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L6
       jmp L5
    L5:
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L6
       jmp L5
    L6:
    L7:
       movq %r15, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L9
       jmp L8
    L8:
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq %r15, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r14
       jmp L10
   L10:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L4
    L4:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
    L9:
       jmp L10
_approxSqrt:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r14
       movq $0, %rbx
       movq %rbx, %r15
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L12:
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r14
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L13:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L11
   L11:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_approxSqrtAll:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -64(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L16
       jmp L15
   L15:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _approxSqrt
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
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L16
       jmp L15
   L16:
   L14:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_range:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L19
       jmp L18
   L18:
   L20:
       movq -80(%rbp), %r10
       movq %r10, %rbx
       cmpq $1, %rbx
       jne L22
       jmp L21
   L21:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       jmp L31
   L31:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L19
       jmp L18
   L22:
   L23:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %r11
       movq %r11, -104(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -104(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L25
       jmp L24
   L24:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       jmp L30
   L30:
       jmp L31
   L25:
   L26:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %r11
       movq %r11, -112(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -112(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L28
       jmp L27
   L27:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       jmp L29
   L29:
       jmp L30
   L28:
       jmp L29
   L19:
       movq -64(%rbp), %r10
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
       movq -72(%rbp), %r10
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
   L17:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
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
       movq %rbx, %r12
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
       movq -16(%rbp), %rbx
       movq %rbx, %r14
       movq %r12, %r12
       movq %r14, %rbx
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
       call _getRands
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %r13
       movq %r13, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _calcMean
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq %r13, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _range
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %r13, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _approxSqrtAll
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $0, %rbx
       movq %rbx, %rax
       jmp L32
   L32:
       addq $128, %rsp
       popq %rbp
       ret
