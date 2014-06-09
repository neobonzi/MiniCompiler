_calcPower:
          loadinargument base, 0, r17
          loadinargument exp, 1, r18
          loadi 1, r20
          mov r20, r19
          mov r18, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          movgt 1, r23
          compi 1, r23, ccr
          cbrne cc, L3, L2
    L2:
          mov r19, r24
          mov r17, r25
          mult r24, r25, r26
          mov r26, r19
          mov r18, r27
          loadi 1, r28
          sub r27, r28, r29
          mov r29, r18
          mov r18, r30
          loadi 0, r31
          loadi 0, r32
          comp r31, r30, ccr
          movgt 1, r32
          compi 1, r32, ccr
          cbrne cc, L3, L2
    L3:
          mov r19, r33
          storeret r33
          br L1
    L1:
 _main:
          new Power, r22
          mov r22, r17
          read r18
          mov r18, r23
          storeai r23, r17,  @base
          read r18
    L5:
          mov r18, r24
          loadi 0, r25
          loadi 0, r26
          comp r25, r24, ccr
          movlt 1, r26
          compi 1, r26, ccr
          cbrne cc, L7, L6
    L6:
          loadi 1, r27
          loadi -1, r28
          mult r28, r27, r28
          storeret r28
          br L4
          br L8
    L8:
          mov r18, r29
          storeai r29, r17,  @exp
          loadi 0, r30
          mov r30, r21
          mov r21, r31
          loadi 1000000, r32
          loadi 0, r33
          comp r32, r31, ccr
          movlt 1, r33
          compi 1, r33, ccr
          cbrne cc, L10, L9
    L9:
          mov r21, r34
          loadi 1, r35
          add r34, r35, r36
          mov r36, r21
          mov r17, r37
          loadAI r37, @base, r38
          mov r17, r39
          loadAI r39, @exp, r40
          storeoutargument r38, 0
          storeoutargument r40, 1
          call _calcPower, 2
          loadret r41
          mov r41, r19
          mov r21, r42
          loadi 1000000, r43
          loadi 0, r44
          comp r43, r42, ccr
          movlt 1, r44
          compi 1, r44, ccr
          cbrne cc, L10, L9
   L10:
          mov r19, r45
          print r45
          loadi 1, r46
          storeret r46
          br L4
    L4:
    L7:
          br L8
