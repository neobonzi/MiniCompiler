_function:
          loadinargument n, 0, r17
    L2:
          mov r17, r20
          loadi 0, r21
          loadi 0, r22
          comp r21, r20, ccr
          movle 1, r22
          compi 1, r22, ccr
          cbrne cc, L4, L3
    L3:
          loadi 0, r23
          storeret r23
          br L1
          br L5
    L5:
          loadi 0, r24
          mov r24, r18
          mov r18, r25
          mov r17, r26
          mov r17, r27
          mult r26, r27, r28
          loadi 0, r29
          comp r28, r25, ccr
          movlt 1, r29
          compi 1, r29, ccr
          cbrne cc, L7, L6
    L6:
          mov r18, r30
          mov r17, r31
          add r30, r31, r32
          mov r32, r19
          mov r19, r33
          print r33
          mov r18, r34
          loadi 1, r35
          add r34, r35, r36
          mov r36, r18
          mov r18, r37
          mov r17, r38
          mov r17, r39
          mult r38, r39, r40
          loadi 0, r41
          comp r40, r37, ccr
          movlt 1, r41
          compi 1, r41, ccr
          cbrne cc, L7, L6
    L7:
          mov r17, r42
          loadi 1, r43
          sub r42, r43, r44
          storeoutargument r44, 0
          call _function, 1
          loadret r45
          storeret r45
          br L1
    L1:
    L4:
          br L5
 _main:
          read r17
          mov r17, r18
          storeoutargument r18, 0
          call _function, 1
          loadret r19
          loadi 0, r20
          print r20
          loadi 0, r21
          storeret r21
          br L8
    L8:
