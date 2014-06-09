      .file   "bench_factorize.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
  _mod:
       pushq %rbp
       movq %rsp, %rbp
       subq $144, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r9
       movq %rsi, %rdi
       movq %r9, %rcx
       movq %rdi, %rbx
       pushq %rdx
       pushq %rax
       movq %rcx, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rbx
       movq %rbx, %rcx
       movq %rdi, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %rcx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rsi
       movq %r9, %rcx
       movq %rsi, %rbx
       pushq %r8
       movq %rcx, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $144, %rsp
       popq %rbp
       ret
_factorize:
       pushq %rbp
       movq %rsp, %rbp
       subq $968, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq $2, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq $0, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r11
       cmpq %rbx, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %r11
       movq %r11, -80(%rbp)
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       movq -80(%rbp), %r10
       andq %r10, %rbx
       movq %rbx, %rbx
       cmpq $1, %rbx
       jne L4
       jmp L3
    L3:
    L5:
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
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
       call _mod
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
       movq $0, %r12
       movq $0, %rbx
       movq -104(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq -56(%rbp), %r10
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
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _factorize
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       jmp L8
    L8:
       movq -56(%rbp), %r10
       movq %r10, -120(%rbp)
       movq %r10, %r10
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq $0, %r11
       movq %r11, -128(%rbp)
       movq -120(%rbp), %r11
       cmpq %rbx, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %r11
       movq %r11, -128(%rbp)
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, -144(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -144(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       movq -128(%rbp), %r10
       andq %r10, %rbx
       movq %rbx, %rbx
       cmpq $1, %rbx
       jne L4
       jmp L3
    L7:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       jmp L8
    L4:
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $968, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $80, %rsp
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
       call _factorize
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
       jmp L9
    L9:
       addq $80, %rsp
       popq %rbp
       ret
