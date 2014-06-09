      .file   "benchmarks/biggest/biggest.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_getIntList:
       pushq %rbp
       movq %rsp, %rbp
       subq $552, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
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
    L2:
       movq -64(%rbp), %r10
       movq %r10, %r13
       movq $1, %rbx
       movq $-1, %r12
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
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
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 0(%r11)
       movq $0, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 8(%r11)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L1
       jmp L5
    L5:
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $552, %rsp
       popq %rbp
       ret
    L4:
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 0(%r11)
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _getIntList
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 8(%r11)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L1
       jmp L5
_biggest:
       pushq %rbp
       movq %rsp, %rbp
       subq $344, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r15
       movq %rsi, %r14
    L7:
       movq %r15, %r13
       movq %r14, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L9
       jmp L8
    L8:
       movq %r15, %rbx
       movq %rbx, %rax
       jmp L6
       jmp L10
   L10:
    L6:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $344, %rsp
       popq %rbp
       ret
    L9:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L6
       jmp L10
_biggestInList:
       pushq %rbp
       movq %rsp, %rbp
       subq $360, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L12:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
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
       call _biggest
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
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -48(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L13:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L11
   L11:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $360, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $72, %rsp
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _getIntList
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
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _biggestInList
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
       jmp L14
   L14:
       addq $72, %rsp
       popq %rbp
       ret
