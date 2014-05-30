      .file   "5.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%d\n\0"
      .text
      .globl _main
 _main:
       pushq %rbp
       movq %rsp, %rbp
       movq $1000, %rcx
       movq $2, %rdx
       cmp %rdx, %rcx
       jg L1
       jmp L2
    L1:
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
       movq %rcx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq $2, %rbx
       cmp %rdx, %rdx
       jg L1
       jmp L2
    L2:
       movq $0, %rcx
       movq %rcx, %rax
    L3:
       popq %rbp
       ret
