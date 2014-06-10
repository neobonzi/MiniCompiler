      .file   "killerBubbles.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
      .comm   swapped,8,8
_compare:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rbx
       movq %rsi, %r13
       movq %rbx, %rbx
       movq 0(%rbx), %r12
       movq %r13, %rbx
       movq 0(%rbx), %rbx
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
       addq $128, %rsp
       popq %rbp
       ret
_deathSort:
       pushq %rbp
       movq %rsp, %rbp
       subq $160, %rsp
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
       movq %r10, %r13
       movq $1, %r12
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
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
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
    L7:
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
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
       call _compare
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r13
       movq $0, %r12
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
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
       movq 0(%rbx), %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
       movq %rbx, 0(%r11)
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq 16(%r10), %rbx
       movq %r12, 0(%rbx)
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       jmp L10
   L10:
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L6
       jmp L5
    L9:
       jmp L10
    L6:
       movq -64(%rbp), %r10
       movq %r10, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L4
       jmp L3
    L4:
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $160, %rsp
       popq %rbp
       ret
_printEVILList:
       pushq %rbp
       movq %rsp, %rbp
       subq $168, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
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
       movq -64(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L12:
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
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
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -80(%rbp), %r10
       movq %r10, %rbx
       movq -64(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L13:
   L11:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $168, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $160, %rsp
       movq $666, %r12
       leaq swapped(%rip), %rbx
       movq %r12, 0(%rbx)
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
       movq %rbx, %r11
       movq %r11, -24(%rbp)
   L15:
       movq -24(%rbp), %r10
       movq %r10, -32(%rbp)
       movq %r10, %r10
       movq $0, %r12
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
       movq $1, %r12
       movq $-1, %rbx
       pushq %r8
       movq %r12, %r8
       imulq %rbx, %r8
       movq %r8, %rbx
       popq %r8
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
       movq $1, %r12
       movq $-1, %rbx
       pushq %r8
       movq %r12, %r8
       imulq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L14
       jmp L18
   L18:
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq $1000, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       movq -24(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -40(%rbp)
       movq $24, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -48(%rbp)
       movq -40(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 0(%r11)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 8(%r11)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       movq %rbx, 16(%r11)
       movq -40(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -40(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -40(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -64(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L20
       jmp L19
   L19:
       movq $24, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -40(%rbp), %r10
       movq %r10, %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
       movq %rbx, 0(%r11)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
       movq %rbx, 8(%r11)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
       movq %rbx, 16(%r11)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
       movq %rbx, 16(%r11)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -40(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -40(%rbp)
       movq -40(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -80(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L20
       jmp L19
   L20:
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
       call _deathSort
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
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
       call _printEVILList
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
       jmp L14
   L14:
       addq $160, %rsp
       popq %rbp
       ret
   L17:
       jmp L18
