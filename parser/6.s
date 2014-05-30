      .file   "6.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%d\n\0"
      .text
      .globl _main
 _main:
       pushq %rbp
       movq %rsp, %rbp
       movq $515, %rbx
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       movq %rbx, %rax
    L1:
       popq %rbp
       ret
