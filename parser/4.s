           .file   "4.c"
          .comm   bb,8,8
          .comm   b,8,8
          .comm   bar,8,8
          .comm   bbb,8,8
          .comm   bob,8,8
          .comm   f,8,8
          .comm   g,8,8
          .comm   foo,8,8
          .comm   i,8,8
          .comm   j,8,8
          .comm   main,8,8
          .comm   k,8,8
          extern printf
          .LLC0
          .string   "%d\n"
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
                .size   g, .-g
       foo:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
        L2:
                movq r0, r1
                movq $0, r2
                movq $0, r3
                cmp r1, r2
                cmovle $1, r3
                cmp $1, r3
                jne L4
                jmp L3
        L3:
                movq $1, r4
                movq r4, %rax
                jmp L5
        L5:
        L6:
                popq %rbp
                ret
                .size   foo, .-foo
        L4:
                movq r0, r5
                movq r0, r6
                movq $1, r7
                movq r6, r8
                subq r7, r8
                movq r8, %rdi
                call foo
                movq %rax, r9
                movq r5, r10
                imulq r9, r10
                movq r10, %rax
                jmp L5
         f:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
                movq %rsi, r1
                movq $7, r5
                movq b(%rip), r6
                movq 8(r6), r7
                movq 32(r7), r8
                movq 32(r8), r9
                movq r5, 0(r9)
                leaq b(%rip), r10
                movq 8(r10), r11
                movq 32(r11), r12
                movq 32(r12), r13
                movq 32(r13), r14
                movq r14, %rax
        L7:
                popq %rbp
                ret
                .size   f, .-f
       bar:
                pushq %rbp
                movq %rsp, %rbp
                movq %rdi, r0
                movq %rsi, r1
        L8:
                popq %rbp
                ret
                .size   bar, .-bar
      main:
                pushq %rbp
                movq %rsp, %rbp
        L9:
                movq $2, r6
                movq r6, r1
       L10:
                movq r1, r7
                movq $1, r8
                movq $0, r9
                movq r8, %rdi
                movq r9, %rsi
                call g
                movq %rax, r10
                movq $0, r11
                cmp r7, r10
                cmovlt $1, r11
                jne L12
                jmp L11
       L11:
                movq $1, r12
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r12, %rsi
                call printf
                jmp L13
       L13:
       L14:
                movq r1, r13
                movq $1, r14
                movq $0, r15
                movq r14, %rdi
                movq r15, %rsi
                call g
                movq %rax, r16
                movq $0, r17
                cmp r13, r16
                cmp $1, r17
                jne L16
                jmp L15
       L15:
                movq $1, r18
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r18, %rsi
                call printf
                jmp L17
       L17:
                movq $1, r20
                cmp $1, r20
                jne L19
                jmp L18
       L18:
                movq $7, r21
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r21, %rsi
                call printf
                movq $1, r22
                cmp $1, r22
                jne L19
                jmp L18
       L19:
                movq $1, r23
                movq $8, %rdi
                call malloc
                movq %rax, r24
                movq r23, %rdi
                movq r24, %rsi
                call g
                movq %rax, r25
                movq $8, %rdi
                call malloc
                movq %rax, r26
                movq r25, %rdi
                movq r26, %rsi
                call f
                movq %rax, r27
                movq $1, r28
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r28, %rsi
                call printf
                movq $8, %rdi
                call malloc
                movq %rax, r29
                movq $1, r30
                movq $8, %rdi
                call malloc
                movq %rax, r31
                movq r30, %rdi
                movq r31, %rsi
                call g
                movq %rax, r32
                movq r29, %rdi
                movq r32, %rsi
                call bar
                movq %rax, r33
                movq $2, r34
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r34, %rsi
                call printf
                movq $1, r35
                movq $8, %rdi
                call malloc
                movq %rax, r36
                movq r35, %rdi
                movq r36, %rsi
                call g
                movq %rax, r37
                movq $8, %rdi
                call malloc
                movq %rax, r38
                movq r37, %rdi
                movq r38, %rsi
                call f
                movq %rax, r39
                movq 8(r39), r40
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r40, %rsi
                call printf
                movq $0, r41
                movq r41, %rax
       L20:
                popq %rbp
                ret
                .size   main, .-main
       L16:
                movq $3, r19
                movq $.LLC0, %rdi
                movq $0, %rax
                movq r19, %rsi
                call printf
                jmp L17
