      .file   "OptimizationBenchmark.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
      .comm   global3,8,8
      .comm   global2,8,8
      .comm   global1,8,8
_constantFolding:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $8, %r12
       movq $9, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq $4, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq $2, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq $5, %r12
       movq $8, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq $9, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq $12, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq $6, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq $9, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq $18, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq $23, %r12
       movq $3, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq $23, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq $90, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %rbx
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
_constantPropagation:
       pushq %rbp
       movq %rsp, %rbp
       subq $296, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $4, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $7, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $8, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $5, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq $11, %rbx
       movq %rbx, %r11
       movq %r11, -88(%rbp)
       movq $21, %rbx
       movq %rbx, %r11
       movq %r11, -96(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -104(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -112(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -120(%rbp)
       movq -104(%rbp), %r10
       movq %r10, %r12
       movq -112(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -128(%rbp)
       movq -120(%rbp), %r10
       movq %r10, %r12
       movq -128(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -136(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %r13
       movq -112(%rbp), %r10
       movq %r10, %r12
       movq -120(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -136(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -144(%rbp)
       movq -112(%rbp), %r10
       movq %r10, %r13
       movq -120(%rbp), %r10
       movq %r10, %r12
       movq -128(%rbp), %r10
       movq %r10, %rbx
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
       movq -136(%rbp), %r10
       movq %r10, %r12
       movq -144(%rbp), %r10
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
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -152(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -112(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -120(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -128(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -160(%rbp)
       movq -160(%rbp), %r10
       movq %r10, %r12
       movq -152(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -112(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -168(%rbp)
       movq -136(%rbp), %r10
       movq %r10, %r12
       movq -144(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -112(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -176(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -120(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq -144(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -168(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -184(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r12
       popq %rax
       popq %rdx
       movq -168(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -192(%rbp)
       movq -120(%rbp), %r10
       movq %r10, %r12
       movq -136(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -176(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -200(%rbp)
       movq -160(%rbp), %r10
       movq %r10, %r12
       movq -168(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -96(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
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
       movq %rbx, %rbx
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -136(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -144(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -208(%rbp)
       movq -208(%rbp), %r10
       movq %r10, %r12
       movq -192(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -184(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
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
       movq %rbx, %r11
       movq %r11, -216(%rbp)
       movq -168(%rbp), %r10
       movq %r10, %r12
       movq -216(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -208(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -160(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq -176(%rbp), %r10
       movq %r10, %r12
       movq %r15, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -200(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r12
       popq %r8
       movq -216(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq -216(%rbp), %r10
       movq %r10, %r13
       movq %r15, %r12
       movq %r14, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -136(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %rbx
       movq %rbx, %rax
       jmp L2
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $296, %rsp
       popq %rbp
       ret
_deadCodeElimination:
       pushq %rbp
       movq %rsp, %rbp
       subq $144, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $4, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $5, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $7, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $8, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $6, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $9, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $12, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $8, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $10, %rbx
       movq %rbx, %r15
       movq $13, %rbx
       movq %rbx, %r15
       movq $9, %rbx
       movq %rbx, %r15
       movq $45, %rbx
       movq %rbx, %r14
       movq $12, %rbx
       movq %rbx, %r14
       movq $3, %rbx
       movq %rbx, %r14
       movq $23, %rbx
       movq %rbx, %r13
       movq $10, %rbx
       movq %rbx, %r13
       movq $11, %r12
       leaq global1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $5, %r12
       leaq global1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $9, %r12
       leaq global1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r15, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r14, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L3
    L3:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $144, %rsp
       popq %rbp
       ret
  _sum:
       pushq %rbp
       movq %rsp, %rbp
       subq $208, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq $0, %r11
       movq %r11, -64(%rbp)
       movq -64(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq -56(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $0, %r11
       movq %r11, -88(%rbp)
       movq $0, %r11
       movq %r11, -96(%rbp)
       movq -80(%rbp), %r11
       movq -88(%rbp), %r10
       cmpq %r10, %r11
       pushq %r8
       movq $1, %r8
       cmovg %r8, %r11
       movq %r11, -96(%rbp)
       popq %r8
       movq -96(%rbp), %r11
       cmpq $1, %r11
       jne L6
       jmp L5
    L5:
       movq -72(%rbp), %r10
       movq %r10, -104(%rbp)
       movq %r10, %r10
       movq -56(%rbp), %r10
       movq %r10, -112(%rbp)
       movq %r10, %r10
       pushq %r8
       movq -104(%rbp), %r10
       movq %r10, %r8
       movq -112(%rbp), %r10
       addq %r10, %r8
       movq %r8, %r11
       movq %r11, -120(%rbp)
       popq %r8
       movq -120(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq -56(%rbp), %r10
       movq %r10, -128(%rbp)
       movq %r10, %r10
       movq $1, %r15
       pushq %r8
       movq -128(%rbp), %r10
       movq %r10, %r8
       subq %r15, %r8
       movq %r8, %r14
       popq %r8
       movq %r14, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r13
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
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L4
    L4:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $208, %rsp
       popq %rbp
       ret
_doesntModifyGlobals:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $1, %rbx
       movq %rbx, %r12
       movq $2, %rbx
       movq %rbx, %r13
       movq %r12, %r12
       movq %r13, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L7
    L7:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_interProceduralOptimization:
       pushq %rbp
       movq %rsp, %rbp
       subq $160, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $1, %r12
       leaq global1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $0, %r12
       leaq global2(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $0, %r12
       leaq global3(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $100, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _sum
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
       movq %r11, -56(%rbp)
    L9:
       movq global1(%rip), %r11
       movq %r11, -64(%rbp)
       movq $1, %r12
       movq $0, %rbx
       movq -64(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L11
       jmp L10
   L10:
       movq $10000, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _sum
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
       movq %r11, -56(%rbp)
       jmp L20
   L20:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L8
    L8:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $160, %rsp
       popq %rbp
       ret
   L11:
   L12:
       movq global2(%rip), %r11
       movq %r11, -72(%rbp)
       movq $2, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L14
       jmp L13
   L13:
       movq $20000, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _sum
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
       movq %r11, -56(%rbp)
       jmp L15
   L15:
   L16:
       movq global3(%rip), %r11
       movq %r11, -80(%rbp)
       movq $3, %r12
       movq $0, %rbx
       movq -80(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L18
       jmp L17
   L17:
       movq $30000, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _sum
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
       movq %r11, -56(%rbp)
       jmp L19
   L19:
       jmp L20
   L18:
       jmp L19
   L14:
       jmp L15
_commonSubexpressionElimination:
       pushq %rbp
       movq %rsp, %rbp
       subq $320, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $11, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $22, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $33, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $44, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq $55, %rbx
       movq %rbx, %r11
       movq %r11, -88(%rbp)
       movq $66, %rbx
       movq %rbx, %r11
       movq %r11, -96(%rbp)
       movq $77, %rbx
       movq %rbx, %r11
       movq %r11, -104(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -112(%rbp)
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %rbx, %r11
       movq %r11, -120(%rbp)
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -128(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -136(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -144(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -152(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -160(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -168(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -176(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -184(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -192(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -200(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -208(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -216(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -224(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -96(%rbp), %r10
       movq %r10, %r12
       movq -88(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -232(%rbp)
       movq -104(%rbp), %r10
       movq %r10, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
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
       movq %rbx, %r11
       movq %r11, -240(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %r13
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
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
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %r13
       popq %rax
       popq %rdx
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       addq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %r12
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       pushq %r8
       movq %r13, %r8
       subq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -88(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -96(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -104(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -112(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -120(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -128(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -136(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -144(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -152(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -160(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -168(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -176(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -184(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -192(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -200(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -208(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -216(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -224(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -232(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -240(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r15, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r14, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rax
       jmp L21
   L21:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $320, %rsp
       popq %rbp
       ret
_hoisting:
       pushq %rbp
       movq %rsp, %rbp
       subq $160, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq $2, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $3, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $4, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq $0, %rbx
       movq %rbx, %r14
       movq %r14, %r13
       movq $1000000, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L24
       jmp L23
   L23:
       movq $5, %rbx
       movq %rbx, %r12
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r15, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %r14, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r14, %r13
       movq $1000000, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L24
       jmp L23
   L24:
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L22
   L22:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $160, %rsp
       popq %rbp
       ret
_doubleIf:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $1, %rbx
       movq %rbx, %r15
       movq $2, %rbx
       movq %rbx, %r12
       movq $3, %rbx
       movq %rbx, %rbx
   L26:
       movq %r15, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L28
       jmp L27
   L27:
       movq $20, %rbx
       movq %rbx, %r12
   L29:
       movq %r15, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L31
       jmp L30
   L30:
       movq $200, %rbx
       movq %rbx, %r12
       movq $300, %rbx
       movq %rbx, %rbx
       jmp L32
   L32:
       movq $50, %rbx
       movq %rbx, %r14
       jmp L33
   L33:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L25
   L25:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
   L31:
       movq $1, %rbx
       movq %rbx, %r15
       movq $2, %rbx
       movq %rbx, %r12
       movq $3, %rbx
       movq %rbx, %rbx
       jmp L32
   L28:
       jmp L33
_integerDivide:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $3000, %rbx
       movq %rbx, %rbx
       movq %rbx, %r12
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
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $4, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $8, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $16, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $32, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $64, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $128, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %r12
       movq $4, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rbx
       movq %rbx, %rbx
       movq %rbx, %rax
       jmp L34
   L34:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_association:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $10, %rbx
       movq %rbx, %r13
       movq %r13, %r12
       movq $2, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
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
       movq %rbx, %r13
       movq $3, %r12
       movq %r13, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
       movq $3, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r13
       movq %r13, %r12
       movq $4, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
       movq $4, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r13
       movq %r13, %r12
       movq $4, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
       movq $4, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
       movq $50, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r13
       movq %r13, %r12
       movq $50, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r13
       movq %r13, %rbx
       movq %rbx, %rax
       jmp L35
   L35:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_tailRecursionHelper:
       pushq %rbp
       movq %rsp, %rbp
       subq $144, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq %rsi, %r11
       movq %r11, -64(%rbp)
   L37:
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L39
       jmp L38
   L38:
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L36
       jmp L40
   L40:
   L36:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $144, %rsp
       popq %rbp
       ret
   L39:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r13
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -56(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %r13, %rdi
       movq %rbx, %rsi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _tailRecursionHelper
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
       jmp L36
       jmp L40
_tailRecursion:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rbx
       movq %rbx, %r12
       movq $0, %rbx
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
       call _tailRecursionHelper
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
       jmp L41
   L41:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_unswitching:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq $1, %rbx
       movq %rbx, %r15
       movq $2, %rbx
       movq %rbx, %r14
       movq %r15, %r13
       movq $1000000, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L44
       jmp L43
   L43:
   L45:
       movq %r14, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L47
       jmp L46
   L46:
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       jmp L48
   L48:
       movq %r15, %r13
       movq $1000000, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L44
       jmp L43
   L47:
       movq %r15, %r12
       movq $2, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       jmp L48
   L44:
       movq %r15, %rbx
       movq %rbx, %rax
       jmp L42
   L42:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_randomCalculation:
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
       movq $0, %rbx
       movq %rbx, %r15
       movq $0, %rbx
       movq %rbx, %r14
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L51
       jmp L50
   L50:
       movq $4, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $7, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $8, %rbx
       movq %rbx, %r11
       movq %r11, -80(%rbp)
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %r12
       movq -80(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -88(%rbp)
       movq %r14, %r12
       movq -88(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq %r15, %r12
       movq $2, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r12
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
       movq %rbx, %r15
       movq $3, %r12
       movq %r15, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r12
       movq $3, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r15
       movq %r15, %r12
       movq $4, %rbx
       pushq %r8
       movq %rbx, %r8
       imulq %r12, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r12
       movq $4, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %r15
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L51
       jmp L50
   L51:
       movq %r14, %rbx
       movq %rbx, %rax
       jmp L49
   L49:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $168, %rsp
       popq %rbp
       ret
_iterativeFibonacci:
       pushq %rbp
       movq %rsp, %rbp
       subq $152, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq $1, %r12
       movq $-1, %rbx
       pushq %r8
       movq %r12, %r8
       imulq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq $0, %rbx
       movq %rbx, %r15
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L54
       jmp L53
   L53:
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r14
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq %r14, %rbx
       movq %rbx, %r11
       movq %r11, -72(%rbp)
       movq %r15, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r15
       movq %r15, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L54
       jmp L53
   L54:
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L52
   L52:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $152, %rsp
       popq %rbp
       ret
_recursiveFibonacci:
       pushq %rbp
       movq %rsp, %rbp
       subq $144, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
   L56:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq $0, %r11
       movq %r11, -64(%rbp)
       cmpq %rbx, %r12
       pushq %r8
       movq $1, %r8
       cmovle %r8, %r11
       movq %r11, -64(%rbp)
       popq %r8
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       movq -64(%rbp), %r10
       orq %r10, %rbx
       movq %rbx, %rbx
       cmpq $1, %rbx
       jne L58
       jmp L57
   L57:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L55
       jmp L59
   L59:
   L55:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $144, %rsp
       popq %rbp
       ret
   L58:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _recursiveFibonacci
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r13
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $2, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _recursiveFibonacci
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
       movq %rbx, %rax
       jmp L55
       jmp L59
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
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
       movq $1, %rbx
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -40(%rbp)
       movq %r10, %r10
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -40(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L62
       jmp L61
   L61:
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _constantFolding
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _constantPropagation
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _deadCodeElimination
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _interProceduralOptimization
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _commonSubexpressionElimination
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _hoisting
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _doubleIf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _integerDivide
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _association
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq %r10, %r12
       movq $1000, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _tailRecursion
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _unswitching
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _randomCalculation
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq %r10, %r12
       movq $5, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _iterativeFibonacci
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq %r10, %r12
       movq $1000, %rbx
       pushq %rdx
       pushq %rax
       movq %r12, %rax
       movq $0, %rdx
       cqto
       idivq %rbx
       movq %rax, %rbx
       popq %rax
       popq %rdx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _recursiveFibonacci
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rbx
       movq %rbx, %rbx
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
       movq -32(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq -24(%rbp), %r10
       movq %r10, %r12
       movq $0, %rbx
       movq -48(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovl %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L62
       jmp L61
   L62:
       movq $9999, %rbx
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
       jmp L60
   L60:
       addq $128, %rsp
       popq %rbp
       ret
