         g:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
                movq %rsi, r1
                movq $3, r5
                movq r5, %rax
        L1:
                popq %rbp
                ret
       foo:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
        L2:
                movq $0, r2
                movq $0, r3
        L3:
                movq $1, r4
                movq r4, %rax
        L5:
        L6:
                popq %rbp
                ret
        L4:
                movq $1, r7
                movq r10, %rax
         f:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
                movq %rsi, r1
                movq $7, r5
                movq r14, %rax
        L7:
                popq %rbp
                ret
       bar:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
                movq %rsi, r1
        L8:
                popq %rbp
                ret
      main:
                pushq %rbp
                movq %rsp, %rbp
        L9:
                movq $2, r6
       L10:
                movq $1, r8
                movq $0, r9
                movq $0, r11
       L11:
                movq $1, r12
       L13:
       L14:
                movq $1, r14
                movq $0, r15
                movq $0, r17
       L15:
                movq $1, r18
       L17:
                movq $1, r20
       L18:
                movq $7, r21
                movq $1, r22
       L19:
                movq $1, r23
                movq $1, r28
                movq $1, r30
                movq $2, r34
                movq $1, r35
                movq $0, r41
                movq r41, %rax
       L20:
                popq %rbp
                ret
       L16:
                movq $3, r19
