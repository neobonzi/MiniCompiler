      .file   "benchmarks/fact_sum/fact_sum.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
  _sum:
       pushq %rbp
       movq %rsp, %rbp
       subq $144, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rcx
       movq %rsi, %rdx
       movq %rcx, %rbx
       movq %rdx, %rdx
       movq %rbx, %rbx
       addq %rdx, %rbx
       movq %rbx, %rax
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $144, %rsp
       popq %rbp
       ret
 _fact:
       pushq %rbp
       movq %rsp, %rbp
       subq $1520, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
    L2:
       movq -48(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -64(%rbp)
       movq $0, %r11
       movq %r11, -72(%rbp)
       movq -56(%rbp), %r11
       movq -64(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %r11
       movq %r11, -72(%rbp)
       popq %r8
       movq -48(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq $0, %r11
       movq %r11, -96(%rbp)
       movq $0, %r12
       movq -88(%rbp), %r11
       movq -96(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %r12
       popq %r8
       movq -72(%rbp), %r10
       andq %r10, %r12
       movq %r12, %r11
       movq %r11, -104(%rbp)
       movq -104(%rbp), %r11
       cmpq $1, %r11
       jne L4
       jmp L3
    L3:
       movq $1, %r11
       movq %r11, -112(%rbp)
       movq -112(%rbp), %r10
       movq %r10, %rax
       jmp L5
    L5:
    L6:
       movq -48(%rbp), %r10
       movq %r10, -120(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -128(%rbp)
       movq $0, %r13
       movq -120(%rbp), %r11
       movq -128(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %r13
       popq %r8
       cmpq $1, %r13
       jne L8
       jmp L7
    L7:
       movq $1, %r11
       movq %r11, -136(%rbp)
       movq $-1, %r11
       movq %r11, -144(%rbp)
       pushq %r8
       movq -136(%rbp), %r10
       movq %r10, %r8
       movq -144(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -144(%rbp)
       popq %r8
       movq -48(%rbp), %r10
       movq %r10, -160(%rbp)
       movq %r10, %r10
       pushq %r8
       movq -160(%rbp), %r10
       movq %r10, %r8
       movq -144(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -168(%rbp)
       popq %r8
       movq -168(%rbp), %r10
       movq %r10, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _fact
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r11
       movq %r11, -176(%rbp)
       movq -176(%rbp), %r10
       movq %r10, %rax
       jmp L9
    L9:
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r10
       movq %r10, -184(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -192(%rbp)
       movq -184(%rbp), %r10
       movq %r10, -200(%rbp)
       movq %r10, %r10
       movq -192(%rbp), %r10
       movq %r10, -200(%rbp)
       subq %r10, %r10
       movq -200(%rbp), %r10
       movq %r10, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _fact
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r11
       movq %r11, -216(%rbp)
       pushq %r8
       movq -216(%rbp), %r10
       movq %r10, %r8
       imulq %rbx, %r8
       movq %r8, %r11
       movq %r11, -224(%rbp)
       popq %r8
       movq -224(%rbp), %r10
       movq %r10, -232(%rbp)
       movq %r10, %r10
       movq -232(%rbp), %r10
       movq %r10, -240(%rbp)
       movq %r10, %r10
       movq -240(%rbp), %r10
       movq %r10, %rax
   L10:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $1520, %rsp
       popq %rbp
       ret
    L8:
       jmp L9
    L4:
       jmp L5
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $656, %rsp
       movq $0, %r12
       movq %r12, %r11
       movq %r11, -8(%rbp)
       movq -8(%rbp), %r10
       movq %r10, -16(%rbp)
       movq %r10, %r10
       movq $1, %rbx
       movq $-1, %r11
       movq %r11, -24(%rbp)
       pushq %r8
       movq %rbx, %r8
       movq -24(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -24(%rbp)
       popq %r8
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq -24(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L12
       jmp L11
   L11:
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
       movq %r11, -48(%rbp)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -56(%rbp), %rsi
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
       movq -56(%rbp), %r11
       movq %r11, -64(%rbp)
       movq -48(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq -72(%rbp), %r10
       movq %r10, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _fact
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r11
       movq %r11, -80(%rbp)
       movq -80(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq -64(%rbp), %r10
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq -96(%rbp), %r10
       movq %r10, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _fact
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r11
       movq %r11, -104(%rbp)
       movq -104(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, -120(%rbp)
       movq %r10, %r10
       movq %r12, %rdi
       movq -120(%rbp), %r10
       movq %r10, %rsi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _sum
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r11
       movq %r11, -128(%rbp)
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
       movq -128(%rbp), %r10
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
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -136(%rbp), %rsi
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
       movq -136(%rbp), %r11
       movq %r11, -8(%rbp)
       movq -8(%rbp), %r10
       movq %r10, -152(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -160(%rbp)
       movq $-1, %r11
       movq %r11, -168(%rbp)
       pushq %r8
       movq -160(%rbp), %r10
       movq %r10, %r8
       movq -168(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -168(%rbp)
       popq %r8
       movq $0, %rbx
       movq -152(%rbp), %r11
       movq -168(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L12
       jmp L11
   L12:
       movq $0, %r11
       movq %r11, -184(%rbp)
       movq -184(%rbp), %r10
       movq %r10, %rax
   L13:
       addq $656, %rsp
       popq %rbp
       ret
