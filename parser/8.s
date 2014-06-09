      .file   "8.c"
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
       subq $344, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       pushq %r11
       movq %rbx, %r11
       movq %r11, -48(%rbp)
       popq %r11
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       pushq %r11
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       popq %r11
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       pushq %r11
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       popq %r11
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
       movq -48(%rbp), %r10
       movq -8(%r10), %rbx
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
       movq -56(%rbp), %r10
       movq -8(%r10), %rbx
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
       movq -64(%rbp), %r10
       movq -8(%r10), %rbx
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
       movq -8(%r14), %rbx
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
       movq -8(%r13), %rbx
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
       movq -8(%r12), %rbx
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
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r11
       movq -48(%rbp), %r11
       movq %r11, -48(%rbp)
       popq %r11
       movq %rbx, 8(%r11)
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r11
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
       popq %r11
       movq %rbx, 8(%r11)
       movq %r14, %rbx
       pushq %r11
       movq -64(%rbp), %r11
       movq %r11, -64(%rbp)
       popq %r11
       movq %rbx, 8(%r11)
       movq %r13, %rbx
       movq %rbx, 8(%r14)
       movq %r12, %rbx
       movq %rbx, 8(%r13)
       movq $0, %rbx
       movq %rbx, 8(%r12)
       movq -48(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $344, %rsp
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
       movq $0, %rbx
       movq %rbx, %rax
       jmp L2
    L2:
       addq $72, %rsp
       popq %rbp
       ret
