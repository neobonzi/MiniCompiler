      .file   "benchmarks/primes/primes.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_isqrt:
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
       movq $1, %rbx
       movq %rbx, %r15
       movq $3, %rbx
       movq %rbx, %r14
       movq %r15, %r13
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L2:
       movq %r15, %r12
       movq %r14, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r14, %r12
       movq $2, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r15, %r13
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L3:
       movq %r14, %r12
       movq $2, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
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
_prime:
       pushq %rbp
       movq %rsp, %rbp
       subq $896, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
    L5:
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L4
       jmp L14
   L14:
    L4:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $896, %rsp
       popq %rbp
       ret
    L7:
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _isqrt
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
       movq %r11, -56(%rbp)
       movq $2, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L9
       jmp L8
    L8:
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -72(%rbp)
   L10:
       movq -72(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L12
       jmp L11
   L11:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L4
       jmp L13
   L13:
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
       movq -64(%rbp), %r10
       movq %r10, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L9
       jmp L8
   L12:
       jmp L13
    L9:
       movq $1, %rbx
       movq %rbx, %rax
       jmp L4
       jmp L14
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $392, %rsp
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
       movq -8(%rbp), %r11
       movq %r11, -16(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       movq -24(%rbp), %r10
       movq %r10, -32(%rbp)
       movq %r10, %r10
       movq -16(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -32(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L17
       jmp L16
   L16:
   L18:
       movq -24(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _prime
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       cmpq $1, %rbx
       jne L20
       jmp L19
   L19:
       movq -24(%rbp), %r10
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
       jmp L21
   L21:
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       movq -24(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq -16(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -48(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L17
       jmp L16
   L20:
       jmp L21
   L17:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L15
   L15:
       addq $392, %rsp
       popq %rbp
       ret
