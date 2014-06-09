      .file   "hailstone.c"
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
       subq $160, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rbx
       movq %rsi, %r14
       movq %rbx, %r13
       movq %rbx, %r12
       movq %r14, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq %r14, %rbx
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
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $160, %rsp
       popq %rbp
       ret
_hailstone:
       pushq %rbp
       movq %rsp, %rbp
       subq $888, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq $1, %rbx
       cmpq $1, %rbx
       jne L4
       jmp L3
    L3:
       movq -48(%rbp), %r10
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
    L5:
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $2, %rbx
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
       movq %r11, -56(%rbp)
       movq $1, %r12
       movq $0, %rbx
       movq -56(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq $3, %r12
       movq -48(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -48(%rbp)
       jmp L8
    L8:
    L9:
       movq -48(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $1, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L11
       jmp L10
   L10:
       movq -48(%rbp), %r10
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
       jmp L2
       jmp L12
   L12:
       movq $1, %rbx
       cmpq $1, %rbx
       jne L4
       jmp L3
   L11:
       jmp L12
    L7:
       movq -48(%rbp), %r10
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
       movq %rbx, %r11
       movq %r11, -48(%rbp)
       jmp L8
    L4:
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $888, %rsp
       popq %rbp
       ret
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
       call _hailstone
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
       jmp L13
   L13:
       addq $96, %rsp
       popq %rbp
       ret
