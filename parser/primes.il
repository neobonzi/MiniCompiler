_isqrt:
          loadinargument a, 0, r17
          loadi 1, r20
          mov r20, r18
          loadi 3, r21
          mov r21, r19
          mov r18, r22
          mov r17, r23
          loadi 0, r24
          comp r23, r22, ccr
          movle 1, r24
          compi 1, r24, ccr
          cbrne cc, L3, L2
    L2:
          mov r18, r25
          mov r19, r26
          add r25, r26, r27
          mov r27, r18
          mov r19, r28
          loadi 2, r29
          add r28, r29, r30
          mov r30, r19
          mov r18, r31
          mov r17, r32
          loadi 0, r33
          comp r32, r31, ccr
          movle 1, r33
          compi 1, r33, ccr
          cbrne cc, L3, L2
    L3:
          mov r19, r34
          loadi 2, r35
          div r34, r35, r36
          loadi 1, r37
          sub r36, r37, r38
          storeret r38
          br L1
    L1:
_prime:
          loadinargument a, 0, r17
    L5:
          mov r17, r21
          loadi 2, r22
          loadi 0, r23
          comp r22, r21, ccr
          movlt 1, r23
          compi 1, r23, ccr
          cbrne cc, L7, L6
    L6:
          loadi 0, r24
          storeret r24
          br L4
          br L14
   L14:
    L4:
    L7:
          mov r17, r25
          storeoutargument r25, 0
          call _isqrt, 1
          loadret r26
          mov r26, r18
          loadi 2, r27
          mov r27, r19
          mov r19, r28
          mov r18, r29
          loadi 0, r30
          comp r29, r28, ccr
          movle 1, r30
          compi 1, r30, ccr
          cbrne cc, L9, L8
    L8:
          mov r17, r31
          mov r17, r32
          mov r19, r33
          div r32, r33, r34
          mov r19, r35
          mult r34, r35, r36
          sub r31, r36, r37
          mov r37, r20
   L10:
          mov r20, r38
          loadi 0, r39
          loadi 0, r40
          comp r39, r38, ccr
          moveq 1, r40
          compi 1, r40, ccr
          cbrne cc, L12, L11
   L11:
          loadi 0, r41
          storeret r41
          br L4
          br L13
   L13:
          mov r19, r42
          loadi 1, r43
          add r42, r43, r44
          mov r44, r19
          mov r19, r45
          mov r18, r46
          loadi 0, r47
          comp r46, r45, ccr
          movle 1, r47
          compi 1, r47, ccr
          cbrne cc, L9, L8
   L12:
          br L13
    L9:
          loadi 1, r48
          storeret r48
          br L4
          br L14
 _main:
          read r19
          mov r19, r17
          loadi 0, r20
          mov r20, r18
          mov r18, r21
          mov r17, r22
          loadi 0, r23
          comp r22, r21, ccr
          movle 1, r23
          compi 1, r23, ccr
          cbrne cc, L17, L16
   L16:
   L18:
          mov r18, r24
          storeoutargument r24, 0
          call _prime, 1
          loadret r25
          compi 1, r25, ccr
          cbrne cc, L20, L19
   L19:
          mov r18, r26
          print r26
          br L21
   L21:
          mov r18, r27
          loadi 1, r28
          add r27, r28, r29
          mov r29, r18
          mov r18, r30
          mov r17, r31
          loadi 0, r32
          comp r31, r30, ccr
          movle 1, r32
          compi 1, r32, ccr
          cbrne cc, L17, L16
   L20:
          br L21
   L17:
          loadi 0, r33
          storeret r33
          br L15
   L15:
