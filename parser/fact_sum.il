  _sum:
          loadinargument a, 0, r17
          loadinargument b, 1, r18
          mov r17, r19
          mov r18, r20
          add r19, r20, r21
          storeret r21
          br L1
    L1:
 _fact:
          loadinargument n, 0, r17
    L3:
          mov r17, r19
          loadi 1, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          mov r17, r22
          loadi 0, r23
          loadi 0, r24
          comp r23, r22, ccr
          moveq 1, r24
          or r21, r24, r25
          compi 1, r25, ccr
          cbrne cc, L5, L4
    L4:
          loadi 1, r26
          storeret r26
          br L2
          br L6
    L6:
    L7:
          mov r17, r27
          loadi 1, r28
          loadi 0, r29
          comp r28, r27, ccr
          movle 1, r29
          compi 1, r29, ccr
          cbrne cc, L9, L8
    L8:
          loadi 1, r30
          loadi -1, r31
          mult r31, r30, r31
          mov r17, r32
          mult r31, r32, r33
          storeoutargument r33, 0
          call _fact, 1
          loadret r34
          storeret r34
          br L2
          br L10
   L10:
          mov r17, r35
          mov r17, r36
          loadi 1, r37
          sub r36, r37, r38
          storeoutargument r38, 0
          call _fact, 1
          loadret r39
          mult r35, r39, r40
          mov r40, r18
          mov r18, r41
          storeret r41
          br L2
    L2:
    L9:
          br L10
    L5:
          br L6
 _main:
          loadi 0, r20
          mov r20, r19
          mov r19, r21
          loadi 1, r22
          loadi -1, r23
          mult r23, r22, r23
          loadi 0, r24
          comp r23, r21, ccr
          movne 1, r24
          compi 1, r24, ccr
          cbrne cc, L13, L12
   L12:
          read r25
          mov r25, r17
          read r26
          mov r26, r18
          mov r17, r27
          storeoutargument r27, 0
          call _fact, 1
          loadret r28
          mov r28, r17
          mov r18, r29
          storeoutargument r29, 0
          call _fact, 1
          loadret r30
          mov r30, r18
          mov r17, r31
          mov r18, r32
          storeoutargument r31, 0
          storeoutargument r32, 1
          call _sum, 2
          loadret r33
          print r33
          read r34
          mov r34, r19
          mov r19, r35
          loadi 1, r36
          loadi -1, r37
          mult r37, r36, r37
          loadi 0, r38
          comp r37, r35, ccr
          movne 1, r38
          compi 1, r38, ccr
          cbrne cc, L13, L12
   L13:
          loadi 0, r39
          storeret r39
          br L11
   L11:
