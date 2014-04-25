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
                load @rb, r6
                loadAI r6, @a, r7
                loadAI r7, @a, r8
                loadAI r8, @a, r9
                loadAI r9, @i, r10
                store r5, r10
                computeglobaladdress b, r11
                loadAI r11, @a, r12
                loadAI r12, @a, r13
                loadAI r13, @a, r14
                loadAI r14, @a, r15
                storeret r15
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
                mov r1, r7
                store r6, r7
       L10:
                mov r1, r8
                loadi 1, r9
                loadi 0, r10
                storeoutargument r9, 0
                storeoutargument r10, 1
                call g, 2
                loadret r11
                loadi 0, r12
                comp r8, r11, ccr
                movlt 1, r12
                cbrne cc, L12, L11
       L11:
                loadi 1, r13
                print r13
       L13:
       L14:
                mov r1, r14
                loadi 1, r15
                loadi 0, r16
                storeoutargument r15, 0
                storeoutargument r16, 1
                call g, 2
                loadret r17
                loadi 0, r18
                comp r14, r17, ccr
                movgt 1, r18
                compi r18, 1, ccr
                cbrne cc, L16, L15
       L15:
                loadi 1, r19
                print r19
       L17:
                loadi 1, r21
                compi r21, 1, ccr
                cbrne cc, L19, L18
       L18:
                loadi 7, r22
                print r22
                loadi 1, r23
                compi r23, 1, ccr
                cbrne cc, L19, L18
       L19:
                loadi 1, r24
                new B, r25
                storeoutargument r24, 0
                storeoutargument r25, 1
                call g, 2
                loadret r26
                new B, r27
                storeoutargument r26, 0
                storeoutargument r27, 1
                call f, 2
                loadret r28
                loadi 1, r29
                print r29
                new B, r30
                loadi 1, r31
                new B, r32
                storeoutargument r31, 0
                storeoutargument r32, 1
                call g, 2
                loadret r33
                storeoutargument r30, 0
                storeoutargument r33, 1
                call bar, 2
                loadret r34
                loadi 2, r35
                print r35
                loadi 1, r36
                new B, r37
                storeoutargument r36, 0
                storeoutargument r37, 1
                call g, 2
                loadret r38
                new B, r39
                storeoutargument r38, 0
                storeoutargument r39, 1
                call f, 2
                loadret r40
                loadAI r40, @i, r41
                print r41
                loadi 0, r42
                storeret r42
       L20:
                ret true
       L16:
                loadi 3, r20
                print r20
