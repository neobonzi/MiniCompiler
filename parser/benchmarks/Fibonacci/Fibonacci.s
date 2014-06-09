      .file   "benchmarks/Fibonacci/Fibonacci.c"
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
       subq $1072, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
    L2:
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq $0, %r11
       movq %r11, -56(%rbp)
       movq $0, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       cmpq %r10, %rbx
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %r11
       movq %r11, -64(%rbp)
       popq %r8
       movq -64(%rbp), %r11
       cmpq $1, %r11
       jne L4
       jmp L3
    L3:
       movq -48(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
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
       movq -80(%rbp), %r10
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
       movq $0, %r11
       movq %r11, -88(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %rax
       jmp L1
       jmp L9
    L9:
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $1072, %rsp
       popq %rbp
       ret
    L4:
    L5:
       movq -48(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $2, %r11
       movq %r11, -88(%rbp)
       movq $0, %r11
       movq %r11, -96(%rbp)
       movq -80(%rbp), %r11
       movq -88(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %r11
       movq %r11, -96(%rbp)
       popq %r8
       movq -96(%rbp), %r11
       cmpq $1, %r11
       jne L7
       jmp L6
    L6:
       movq $1, %r11
       movq %r11, -112(%rbp)
       movq -112(%rbp), %r10
       movq %r10, %rax
       jmp L1
       jmp L8
    L8:
       jmp L9
    L7:
       movq -48(%rbp), %r10
       movq %r10, -112(%rbp)
       movq %r10, %r10
       movq $1, %r12
       pushq %r8
       movq -112(%rbp), %r10
       movq %r10, %r8
       subq %r12, %r8
       movq %r8, %r11
       movq %r11, -120(%rbp)
       popq %r8
       movq -120(%rbp), %r10
       movq %r10, %rdi
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
       movq %rax, %r11
       movq %r11, -128(%rbp)
       movq -48(%rbp), %r10
       movq %r10, -136(%rbp)
       movq %r10, %r10
       movq $2, %rbx
       pushq %r8
       movq -136(%rbp), %r10
       movq %r10, %r8
       subq %rbx, %r8
       movq %r8, %r11
       movq %r11, -144(%rbp)
       popq %r8
       movq -144(%rbp), %r10
       movq %r10, %rdi
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
       movq %rax, %r11
       movq %r11, -152(%rbp)
       pushq %r8
       movq -128(%rbp), %r10
       movq %r10, %r8
       movq -152(%rbp), %r10
       addq %r10, %r8
       movq %r8, %r11
       movq %r11, -160(%rbp)
       popq %r8
       movq -160(%rbp), %r10
       movq %r10, %rax
       jmp L1
       jmp L8
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
       movq -8(%rbp), %rcx
       movq %rcx, %rbx
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
       addq $80, %rsp
       popq %rbp
       ret
