      .file   "programBreaker.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
      .comm   GLOBAL,8,8
      .comm   count,8,8
 _fun2:
       pushq %rbp
       movq %rsp, %rbp
       subq $448, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq %rsi, %r11
       movq %r11, -56(%rbp)
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
       movq -56(%rbp), %r10
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
       addq $448, %rsp
       popq %rbp
       ret
    L4:
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
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
       call _fun2
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rax
       jmp L1
       jmp L5
 _fun1:
       pushq %rbp
       movq %rsp, %rbp
       subq $928, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq %rsi, %r11
       movq %r11, -56(%rbp)
       movq %rdx, %r11
       movq %r11, -64(%rbp)
       movq $5, %r12
       movq $6, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $2, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq $4, %r12
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
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -72(%rbp)
    L7:
       movq -72(%rbp), %r10
       movq %r10, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
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
       movq %r10, %r12
       movq -48(%rbp), %r10
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
       call _fun2
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rax
       jmp L6
       jmp L14
   L14:
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L6
    L6:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $928, %rsp
       popq %rbp
       ret
    L9:
   L10:
       movq $5, %r12
       movq $6, %rbx
       movq $0, %r11
       movq %r11, -80(%rbp)
       cmpq %rbx, %r12
       pushq %r8
       movq $1, %r8
       cmovl %r8, %r11
       movq %r11, -80(%rbp)
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovle %r8, %rbx
       popq %r8
       movq -80(%rbp), %r10
       andq %r10, %rbx
       movq %rbx, %rbx
       cmpq $1, %rbx
       jne L12
       jmp L11
   L11:
       movq -72(%rbp), %r10
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
       call _fun2
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rax
       jmp L6
       jmp L13
   L13:
       jmp L14
   L12:
       jmp L13
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $296, %rsp
       movq $0, %rbx
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
       movq %r11, -8(%rbp)
       movq -8(%rbp), %r10
       movq %r10, -32(%rbp)
       movq %r10, %r10
       movq $10000, %r12
       movq $0, %rbx
       movq -32(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L17
       jmp L16
   L16:
       movq $3, %r11
       movq %r11, -40(%rbp)
       movq -8(%rbp), %r10
       movq %r10, %r12
       movq $5, %rbx
       movq -40(%rbp), %r10
       movq %r10, %rdi
       movq %r12, %rsi
       movq %rbx, %rdx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _fun1
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
       movq -8(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -8(%rbp)
       movq -8(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       movq $10000, %r12
       movq $0, %rbx
       movq -56(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L17
       jmp L16
   L17:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L15
   L15:
       addq $296, %rsp
       popq %rbp
       ret
