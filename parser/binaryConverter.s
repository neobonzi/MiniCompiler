      .file   "binaryConverter.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
 _wait:
       pushq %rbp
       movq %rsp, %rbp
       subq $256, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r14
       movq %r14, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L2:
       movq %r14, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r14, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L3
       jmp L2
    L3:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $256, %rsp
       popq %rbp
       ret
_power:
       pushq %rbp
       movq %rsp, %rbp
       subq $288, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq %rsi, %r15
       movq $1, %rbx
       movq %rbx, %r14
       movq %r15, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L6
       jmp L5
    L5:
       movq %r14, %r12
       movq -48(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L6
       jmp L5
    L6:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L4
    L4:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $288, %rsp
       popq %rbp
       ret
_recursiveDecimalSum:
       pushq %rbp
       movq %rsp, %rbp
       subq $1064, %rsp
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
    L8:
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L10
       jmp L9
    L9:
       movq $2, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $10, %rbx
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
       movq %r11, -80(%rbp)
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq $10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -80(%rbp)
   L11:
       movq -80(%rbp), %r10
       movq %r10, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L12:
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
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
       call _power
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
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       jmp L14
   L14:
       movq -48(%rbp), %r10
       movq %r10, %r12
       movq $10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r11
       movq %r11, -112(%rbp)
       popq %rax
       popq %rdx
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -112(%rbp), %r10
       movq %r10, %rdi
       movq %r13, %rsi
       movq %rbx, %rdx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _recursiveDecimalSum
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
       jmp L7
       jmp L15
   L15:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L7
    L7:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $1064, %rsp
       popq %rbp
       ret
   L13:
       jmp L14
   L10:
       jmp L15
_convertToDecimal:
       pushq %rbp
       movq %rsp, %rbp
       subq $192, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq $0, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $0, %rbx
       movq %rbx, %r12
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq %r12, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %r13, %rdi
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
       call _recursiveDecimalSum
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
       jmp L16
   L16:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $192, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $304, %rsp
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
       movq -16(%rbp), %r10
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
       call _convertToDecimal
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
       movq %r11, -16(%rbp)
       movq -16(%rbp), %r10
       movq %r10, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -40(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -40(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L19
       jmp L18
   L18:
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
       call _wait
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq -32(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -56(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L19
       jmp L18
   L19:
       movq -16(%rbp), %r10
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
       jmp L17
   L17:
       addq $304, %rsp
       popq %rbp
       ret
