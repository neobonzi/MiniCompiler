         g:
                loadinargument i, 0, r0
                loadinargument j, 1, r1
                loadi 3, r5
                storeret r5
        L1:
                ret true
       foo:
                loadinargument n, 0, r0
        L2:
                mov r0, r1
                loadi 0, r2
                loadi 0, r3
                comp r1, r2, ccr
                movle 1, r3
                compi r3, 1, ccr
                cbrne cc, L4, L3
        L3:
                loadi 1, r4
                storeret r4
        L5:
        L6:
                ret true
        L4:
                mov r0, r5
                mov r0, r6
                loadi 1, r7
                sub r6, r7, r8
                storeoutargument r8, 0
                call foo, 1
                loadret r9
                mult r5, r9, r10
                storeret r10
         f:
                loadinargument i, 0, r0
                loadinargument j, 1, r1
                loadi 7, r5
                loadglobal @b, r6
                loadAI r6, @a, r7
                loadAI r7, @a, r8
                loadAI r8, @a, r9
                storeai r5, r9,  @i
                computeglobaladdress b, r10
                loadAI r10, @a, r11
                loadAI r11, @a, r12
                loadAI r12, @a, r13
                loadAI r13, @a, r14
                storeret r14
        L7:
                ret true
       bar:
                loadinargument j, 0, r0
                loadinargument i, 1, r1
        L8:
                ret true
      main:
        L9:
                loadi 2, r6
                mov r6, r1
       L10:
                mov r1, r7
                loadi 1, r8
                loadi 0, r9
                storeoutargument r8, 0
                storeoutargument r9, 1
                call g, 2
                loadret r10
                loadi 0, r11
                comp r7, r10, ccr
                movlt 1, r11
                cbrne cc, L12, L11
       L11:
                loadi 1, r12
                print r12
       L13:
       L14:
                mov r1, r13
                loadi 1, r14
                loadi 0, r15
                storeoutargument r14, 0
                storeoutargument r15, 1
                call g, 2
                loadret r16
                loadi 0, r17
                comp r13, r16, ccr
                movgt 1, r17
                compi r17, 1, ccr
                cbrne cc, L16, L15
       L15:
                loadi 1, r18
                print r18
       L17:
                loadi 1, r20
                compi r20, 1, ccr
                cbrne cc, L19, L18
       L18:
                loadi 7, r21
                print r21
                loadi 1, r22
                compi r22, 1, ccr
                cbrne cc, L19, L18
       L19:
                loadi 1, r23
                new B, r24
                storeoutargument r23, 0
                storeoutargument r24, 1
                call g, 2
                loadret r25
                new B, r26
                storeoutargument r25, 0
                storeoutargument r26, 1
                call f, 2
                loadret r27
                loadi 1, r28
                print r28
                new B, r29
                loadi 1, r30
                new B, r31
                storeoutargument r30, 0
                storeoutargument r31, 1
                call g, 2
                loadret r32
                storeoutargument r29, 0
                storeoutargument r32, 1
                call bar, 2
                loadret r33
                loadi 2, r34
                print r34
                loadi 1, r35
                new B, r36
                storeoutargument r35, 0
                storeoutargument r36, 1
                call g, 2
                loadret r37
                new B, r38
                storeoutargument r37, 0
                storeoutargument r38, 1
                call f, 2
                loadret r39
                loadAI r39, @i, r40
                print r40
                loadi 0, r41
                storeret r41
       L20:
                ret true
       L16:
                loadi 3, r19
                print r19
