      .file   "creativeBenchMarkName.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_buildList:
       pushq %rbp
       movq %rsp, %rbp
       subq $200, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r14
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r13
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
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
       leaq -72(%rbp), %rsi
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
       movq -72(%rbp), %rbx
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
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
       leaq -80(%rbp), %rsi
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
       movq -80(%rbp), %rbx
       movq -64(%rbp), %r11
       movq %r11, -64(%rbp)
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
       leaq -88(%rbp), %rsi
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
       movq -88(%rbp), %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
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
       leaq -96(%rbp), %rsi
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
       movq -96(%rbp), %rbx
       movq %rbx, 0(%r14)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -104(%rbp), %rsi
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
       movq -104(%rbp), %rbx
       movq %rbx, 0(%r13)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -112(%rbp), %rsi
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
       movq -112(%rbp), %rbx
       movq %rbx, 0(%r12)
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
       movq %rbx, 8(%r11)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq -64(%rbp), %r11
       movq %r11, -64(%rbp)
       movq %rbx, 8(%r11)
       movq %r14, %rbx
       movq -72(%rbp), %r11
       movq %r11, -72(%rbp)
       movq %rbx, 8(%r11)
       movq %r13, %rbx
       movq %rbx, 8(%r14)
       movq %r12, %rbx
       movq %rbx, 8(%r13)
       movq $0, %rbx
       movq %rbx, 8(%r12)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $200, %rsp
       popq %rbp
       ret
_multiple:
       pushq %rbp
       movq %rsp, %rbp
       subq $176, %rsp
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
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -64(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq $5, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L4
       jmp L3
    L3:
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -80(%rbp), %r10
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
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq $5, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L4
       jmp L3
    L4:
       movq -80(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L2
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $176, %rsp
       popq %rbp
       ret
  _add:
       pushq %rbp
       movq %rsp, %rbp
       subq $176, %rsp
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
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -64(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq $5, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -80(%rbp), %r10
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
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq $5, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L7:
       movq -80(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L5
    L5:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $176, %rsp
       popq %rbp
       ret
_recurseList:
       pushq %rbp
       movq %rsp, %rbp
       subq $136, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
    L9:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L11
       jmp L10
   L10:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       movq %rbx, %rax
       jmp L8
       jmp L12
   L12:
    L8:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $136, %rsp
       popq %rbp
       ret
   L11:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _recurseList
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L8
       jmp L12
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $176, %rsp
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -16(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _buildList
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
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
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
       call _multiple
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
       movq %r11, -40(%rbp)
       movq -32(%rbp), %r10
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
       call _add
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
       movq %r11, -48(%rbp)
       movq -40(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
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
       pushq %r8
       movq -56(%rbp), %r10
       movq %r10, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -16(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $10, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L15
       jmp L14
   L14:
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq -32(%rbp), %r10
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
       call _recurseList
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       movq -16(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -16(%rbp)
       movq -16(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $10, %r12
       movq $0, %rbx
       movq -80(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L15
       jmp L14
   L15:
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
       movq -24(%rbp), %r10
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
       jne L17
       jmp L16
   L16:
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -24(%rbp)
       movq -24(%rbp), %r10
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
       jne L17
       jmp L16
   L17:
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
       movq $0, %rbx
       movq %rbx, %rax
       jmp L13
   L13:
       addq $176, %rsp
       popq %rbp
       ret
