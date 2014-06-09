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
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $72, %rsp
       movq $16, %rdi
       call _malloc
       movq %rax, %rax
       movq %rax, %rax
       movq $0, %rax
       movq %rax, %rax
       jmp L1
    L1:
       addq $72, %rsp
       popq %rbp
       ret
