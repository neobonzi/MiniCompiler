      .file   "benchmarks/binaryConverter/binaryConverter.c"
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
       subq $240, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rcx
       movq %rcx, %rdx
       movq $0, %rbx
       movq $0, %r13
       cmpq %rbx, %rdx
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r13
       popq %r8
       cmpq $1, %r13
       jne L2
       jmp L1
    L1:
       movq %rcx, %rdi
       movq $1, %r12
       movq %rdi, %rsi
       subq %r12, %rsi
       movq %rsi, %rcx
       movq %rcx, %r9
       movq $0, %rcx
       movq $0, %r14
       cmpq %rcx, %r9
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r14
       popq %r8
       cmpq $1, %r14
       jne L2
       jmp L1
    L2:
       movq $0, %r9
       movq %r9, %rax
    L3:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $240, %rsp
       popq %rbp
       ret
_power:
       pushq %rbp
       movq %rsp, %rbp
       subq $432, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rdx
       movq %rsi, %rdi
       movq $1, %rsi
       movq %rsi, %r11
       movq %r11, -48(%rbp)
       movq %rdi, %rcx
       movq $0, %rbx
       movq $0, %r11
       movq %r11, -56(%rbp)
       cmpq %rbx, %rcx
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r11
       movq %r11, -56(%rbp)
       popq %r8
       movq -56(%rbp), %r11
       cmpq $1, %r11
       jne L5
       jmp L4
    L4:
       movq -48(%rbp), %r10
       movq %r10, %r15
       movq %rdx, %r12
       pushq %r8
       movq %r12, %r8
       imulq %r15, %r8
       movq %r8, %r14
       popq %r8
       movq %r14, %r11
       movq %r11, -48(%rbp)
       movq %rdi, %r9
       movq $1, %r11
       movq %r11, -80(%rbp)
       movq %r9, %rdi
       movq -80(%rbp), %r10
       subq %r10, %rdi
       movq %rdi, %rdi
       movq %rdi, %r13
       movq $0, %rdx
       movq $0, %r11
       movq %r11, -88(%rbp)
       cmpq %rdx, %r13
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r11
       movq %r11, -88(%rbp)
       popq %r8
       movq -88(%rbp), %r11
       cmpq $1, %r11
       jne L5
       jmp L4
    L5:
       movq -48(%rbp), %r10
       movq %r10, %r14
       movq %r14, %rax
    L6:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $432, %rsp
       popq %rbp
       ret
_recursiveDecimalSum:
       pushq %rbp
       movq %rsp, %rbp
       subq $2312, %rsp
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
    L7:
       movq -48(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $0, %r11
       movq %r11, -80(%rbp)
       movq $0, %r12
       movq -72(%rbp), %r11
       movq -80(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r12
       popq %r8
       cmpq $1, %r12
       jne L9
       jmp L8
    L8:
       movq $2, %r11
       movq %r11, -88(%rbp)
       movq -88(%rbp), %r10
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq -48(%rbp), %r10
       movq %r10, -104(%rbp)
       movq %r10, %r10
       movq $10, %r11
       movq %r11, -112(%rbp)
       pushq %rdx
       pushq %rax
       movq -104(%rbp), %r10
       movq %r10, %rax
       movq $0, %rdx
       cqto
       movq -112(%rbp), %r10
       idivq %r10
       movq %rax, %r11
       movq %r11, -120(%rbp)
       popq %rax
       popq %rdx
       movq -120(%rbp), %r10
       movq %r10, -128(%rbp)
       movq %r10, %r10
       movq -128(%rbp), %r10
       movq %r10, -136(%rbp)
       movq %r10, %r10
       movq $10, %r11
       movq %r11, -144(%rbp)
       pushq %r8
       movq -144(%rbp), %r10
       movq %r10, %r8
       movq -136(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -152(%rbp)
       popq %r8
       movq -152(%rbp), %r10
       movq %r10, -128(%rbp)
       movq %r10, %r10
       movq -48(%rbp), %r10
       movq %r10, %r13
       movq -128(%rbp), %r10
       movq %r10, -168(%rbp)
       movq %r10, %r10
       movq %r13, %r11
       movq %r11, -176(%rbp)
       movq -168(%rbp), %r10
       movq %r10, -176(%rbp)
       subq %r10, %r10
       movq -176(%rbp), %r10
       movq %r10, -128(%rbp)
       movq %r10, %r10
   L10:
       movq -128(%rbp), %r10
       movq %r10, -200(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -208(%rbp)
       movq $0, %r11
       movq %r11, -216(%rbp)
       movq -200(%rbp), %r11
       movq -208(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %r11
       movq %r11, -216(%rbp)
       popq %r8
       movq -216(%rbp), %r11
       cmpq $1, %r11
       jne L12
       jmp L11
   L11:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq -96(%rbp), %r10
       movq %r10, -232(%rbp)
       movq %r10, %r10
       movq -64(%rbp), %r10
       movq %r10, -240(%rbp)
       movq %r10, %r10
       movq -232(%rbp), %r10
       movq %r10, %rdi
       movq -240(%rbp), %r10
       movq %r10, %rsi
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
       movq %rax, %r11
       movq %r11, -248(%rbp)
       movq %rbx, %r11
       movq %r11, -256(%rbp)
       movq -248(%rbp), %r10
       movq %r10, -256(%rbp)
       addq %r10, %r10
       movq -256(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       jmp L13
   L13:
       movq -48(%rbp), %r10
       movq %r10, -280(%rbp)
       movq %r10, %r10
       movq $10, %r11
       movq %r11, -288(%rbp)
       pushq %rdx
       pushq %rax
       movq -280(%rbp), %r10
       movq %r10, %rax
       movq $0, %rdx
       cqto
       movq -288(%rbp), %r10
       idivq %r10
       movq %rax, %r11
       movq %r11, -296(%rbp)
       popq %rax
       popq %rdx
       movq -56(%rbp), %r10
       movq %r10, -304(%rbp)
       movq %r10, %r10
       movq -64(%rbp), %r10
       movq %r10, -312(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -320(%rbp)
       movq -312(%rbp), %r10
       movq %r10, -328(%rbp)
       movq %r10, %r10
       movq -320(%rbp), %r10
       movq %r10, -328(%rbp)
       addq %r10, %r10
       movq -296(%rbp), %r10
       movq %r10, %rdi
       movq -304(%rbp), %r10
       movq %r10, %rsi
       movq -328(%rbp), %r10
       movq %r10, %rdx
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
       movq %rax, %r11
       movq %r11, -344(%rbp)
       movq -344(%rbp), %r10
       movq %r10, %rax
       jmp L14
   L14:
       movq -56(%rbp), %r10
       movq %r10, -352(%rbp)
       movq %r10, %r10
       movq -352(%rbp), %r10
       movq %r10, %rax
   L15:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $2312, %rsp
       popq %rbp
       ret
   L12:
       jmp L13
    L9:
       jmp L14
_convertToDecimal:
       pushq %rbp
       movq %rsp, %rbp
       subq $240, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -48(%rbp)
       movq $0, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq $0, %r13
       movq %r13, %r12
       movq -48(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq %r12, %rbx
       movq -64(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq -72(%rbp), %r10
       movq %r10, %rdi
       movq %rbx, %rsi
       movq -80(%rbp), %r10
       movq %r10, %rdx
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
       movq %rax, %r11
       movq %r11, -88(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %rax
   L16:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $240, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $672, %rsp
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
       movq %r10, -24(%rbp)
       movq %r10, %r10
       movq -24(%rbp), %r10
       movq %r10, %rdi
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
       movq %rax, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -16(%rbp)
       movq %r10, %r10
       movq -16(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq -16(%rbp), %r10
       movq %r10, -56(%rbp)
       movq %r10, %r10
       pushq %r8
       movq -56(%rbp), %r10
       movq %r10, %r8
       movq -48(%rbp), %r10
       imulq %r10, %r8
       movq %r8, %r11
       movq %r11, -64(%rbp)
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $0, %r11
       movq %r11, -80(%rbp)
       movq $0, %r11
       movq %r11, -88(%rbp)
       movq -72(%rbp), %r11
       movq -80(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r11
       movq %r11, -88(%rbp)
       popq %r8
       movq -88(%rbp), %r11
       cmpq $1, %r11
       jne L18
       jmp L17
   L17:
       movq %rbx, %r11
       movq %r11, -104(%rbp)
       movq -104(%rbp), %r10
       movq %r10, %rdi
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
       movq %rax, %r11
       movq %r11, -112(%rbp)
       movq %rbx, %r11
       movq %r11, -120(%rbp)
       movq $1, %r11
       movq %r11, -128(%rbp)
       movq -120(%rbp), %r10
       movq %r10, -136(%rbp)
       movq %r10, %r10
       movq -128(%rbp), %r10
       movq %r10, -136(%rbp)
       subq %r10, %r10
       movq -136(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -152(%rbp)
       movq $0, %r11
       movq %r11, -160(%rbp)
       movq $0, %r12
       movq -152(%rbp), %r11
       movq -160(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r12
       popq %r8
       cmpq $1, %r12
       jne L18
       jmp L17
   L18:
       movq -16(%rbp), %r10
       movq %r10, -168(%rbp)
       movq %r10, %r10
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
       movq -168(%rbp), %r10
       movq %r10, %rsi
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
   L19:
       addq $672, %rsp
       popq %rbp
       ret
