  _mod:
          loadinargument num, 0, r17
          loadinargument i, 1, r18
          mov r17, r22
          mov r18, r23
          div r22, r23, r24
          mov r24, r19
          mov r19, r25
          mov r18, r26
          mult r25, r26, r27
          mov r27, r20
          mov r17, r28
          mov r20, r29
          sub r28, r29, r30
          mov r30, r21
          mov r21, r31
          storeret r31
          br L1
    L1:
_factorize:
          loadinargument num, 0, r17
          loadi 2, r20
          mov r20, r18
          loadi 0, r21
          mov r21, r19
          mov r18, r22
          mov r17, r23
          loadi 0, r24
          comp r23, r22, ccr
          movle 1, r24
          mov r19, r25
          loadi 0, r26
          loadi 0, r27
          comp r26, r25, ccr
          moveq 1, r27
          and r24, r27, r28
          compi 1, r28, ccr
          cbrne cc, L4, L3
    L3:
    L5:
          mov r17, r29
          mov r18, r30
          storeoutargument r29, 0
          storeoutargument r30, 1
          call _mod, 2
          loadret r31
          loadi 0, r32
          loadi 0, r33
          comp r32, r31, ccr
          moveq 1, r33
          compi 1, r33, ccr
          cbrne cc, L7, L6
    L6:
          mov r18, r34
          print r34
          mov r17, r35
          mov r18, r36
          div r35, r36, r37
          storeoutargument r37, 0
          call _factorize, 1
          loadret r38
          loadi 1, r39
          mov r39, r19
          br L8
    L8:
          mov r18, r43
          mov r17, r44
          loadi 0, r45
          comp r44, r43, ccr
          movle 1, r45
          mov r19, r46
          loadi 0, r47
          loadi 0, r48
          comp r47, r46, ccr
          moveq 1, r48
          and r45, r48, r49
          compi 1, r49, ccr
          cbrne cc, L4, L3
    L7:
          mov r18, r40
          loadi 1, r41
          add r40, r41, r42
          mov r42, r18
          br L8
    L4:
    L2:
 _main:
          read r17
          mov r17, r18
          storeoutargument r18, 0
          call _factorize, 1
          loadret r19
          loadi 0, r20
          print r20
          loadi 1, r21
          storeret r21
          br L9
    L9:
