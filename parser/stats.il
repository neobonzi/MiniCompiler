_getRands:
          loadinargument seed, 0, r17
          loadinargument num, 1, r18
          mov r17, r23
          mov r17, r24
          mult r23, r24, r25
          mov r25, r19
          new linkedNums, r26
          mov r26, r22
          mov r19, r27
          storeai r27, r22,  @num
          loadi 0, r28
          storeai r28, r22,  @next
          mov r18, r29
          loadi 1, r30
          sub r29, r30, r31
          mov r31, r18
          mov r19, r32
          mov r32, r20
          mov r18, r33
          loadi 0, r34
          loadi 0, r35
          comp r34, r33, ccr
          movgt 1, r35
          compi 1, r35, ccr
          cbrne cc, L3, L2
    L2:
          mov r20, r36
          mov r20, r37
          mult r36, r37, r38
          mov r17, r39
          div r38, r39, r40
          mov r17, r41
          loadi 2, r42
          div r41, r42, r43
          mult r40, r43, r44
          loadi 1, r45
          add r44, r45, r46
          mov r46, r19
          new linkedNums, r47
          mov r47, r21
          mov r19, r48
          storeai r48, r21,  @num
          mov r22, r49
          storeai r49, r21,  @next
          mov r21, r50
          mov r50, r22
          mov r18, r51
          loadi 1, r52
          sub r51, r52, r53
          mov r53, r18
          mov r19, r54
          mov r54, r20
          mov r18, r55
          loadi 0, r56
          loadi 0, r57
          comp r56, r55, ccr
          movgt 1, r57
          compi 1, r57, ccr
          cbrne cc, L3, L2
    L3:
          mov r22, r58
          storeret r58
          br L1
    L1:
_calcMean:
          loadinargument nums, 0, r17
          loadi 0, r21
          mov r21, r18
          loadi 0, r22
          mov r22, r19
          loadi 0, r23
          mov r23, r20
          mov r17, r24
          loadi 0, r25
          loadi 0, r26
          comp r25, r24, ccr
          movne 1, r26
          compi 1, r26, ccr
          cbrne cc, L6, L5
    L5:
          mov r19, r27
          loadi 1, r28
          add r27, r28, r29
          mov r29, r19
          mov r18, r30
          mov r17, r31
          loadAI r31, @num, r32
          add r30, r32, r33
          mov r33, r18
          mov r17, r34
          loadAI r34, @next, r35
          mov r35, r17
          mov r17, r36
          loadi 0, r37
          loadi 0, r38
          comp r37, r36, ccr
          movne 1, r38
          compi 1, r38, ccr
          cbrne cc, L6, L5
    L6:
    L7:
          mov r19, r39
          loadi 0, r40
          loadi 0, r41
          comp r40, r39, ccr
          movne 1, r41
          compi 1, r41, ccr
          cbrne cc, L9, L8
    L8:
          mov r18, r42
          mov r19, r43
          div r42, r43, r44
          mov r44, r20
          br L10
   L10:
          mov r20, r45
          storeret r45
          br L4
    L4:
    L9:
          br L10
_approxSqrt:
          loadinargument num, 0, r17
          loadi 1, r21
          mov r21, r18
          mov r18, r22
          mov r22, r20
          loadi 0, r23
          mov r23, r19
          mov r19, r24
          mov r17, r25
          loadi 0, r26
          comp r25, r24, ccr
          movlt 1, r26
          compi 1, r26, ccr
          cbrne cc, L13, L12
   L12:
          mov r18, r27
          mov r18, r28
          mult r27, r28, r29
          mov r29, r19
          mov r18, r30
          mov r30, r20
          mov r18, r31
          loadi 1, r32
          add r31, r32, r33
          mov r33, r18
          mov r19, r34
          mov r17, r35
          loadi 0, r36
          comp r35, r34, ccr
          movlt 1, r36
          compi 1, r36, ccr
          cbrne cc, L13, L12
   L13:
          mov r20, r37
          storeret r37
          br L11
   L11:
_approxSqrtAll:
          loadinargument nums, 0, r17
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movne 1, r20
          compi 1, r20, ccr
          cbrne cc, L16, L15
   L15:
          mov r17, r21
          loadAI r21, @num, r22
          storeoutargument r22, 0
          call _approxSqrt, 1
          loadret r23
          print r23
          mov r17, r24
          loadAI r24, @next, r25
          mov r25, r17
          mov r17, r26
          loadi 0, r27
          loadi 0, r28
          comp r27, r26, ccr
          movne 1, r28
          compi 1, r28, ccr
          cbrne cc, L16, L15
   L16:
   L14:
_range:
          loadinargument nums, 0, r17
          loadi 0, r21
          mov r21, r18
          loadi 0, r22
          mov r22, r19
          loadi 1, r23
          mov r23, r20
          mov r17, r24
          loadi 0, r25
          loadi 0, r26
          comp r25, r24, ccr
          movne 1, r26
          compi 1, r26, ccr
          cbrne cc, L19, L18
   L18:
   L20:
          mov r20, r27
          compi 1, r27, ccr
          cbrne cc, L22, L21
   L21:
          mov r17, r28
          loadAI r28, @num, r29
          mov r29, r18
          mov r17, r30
          loadAI r30, @num, r31
          mov r31, r19
          loadi 0, r32
          mov r32, r20
          br L31
   L31:
          mov r17, r45
          loadAI r45, @next, r46
          mov r46, r17
          mov r17, r47
          loadi 0, r48
          loadi 0, r49
          comp r48, r47, ccr
          movne 1, r49
          compi 1, r49, ccr
          cbrne cc, L19, L18
   L22:
   L23:
          mov r17, r33
          loadAI r33, @num, r34
          mov r18, r35
          loadi 0, r36
          comp r35, r34, ccr
          movlt 1, r36
          compi 1, r36, ccr
          cbrne cc, L25, L24
   L24:
          mov r17, r37
          loadAI r37, @num, r38
          mov r38, r18
          br L30
   L30:
          br L31
   L25:
   L26:
          mov r17, r39
          loadAI r39, @num, r40
          mov r19, r41
          loadi 0, r42
          comp r41, r40, ccr
          movgt 1, r42
          compi 1, r42, ccr
          cbrne cc, L28, L27
   L27:
          mov r17, r43
          loadAI r43, @num, r44
          mov r44, r19
          br L29
   L29:
          br L30
   L28:
          br L29
   L19:
          mov r18, r50
          print r50
          mov r19, r51
          print r51
   L17:
 _main:
          read r21
          mov r21, r17
          read r22
          mov r22, r18
          mov r17, r23
          mov r18, r24
          storeoutargument r23, 0
          storeoutargument r24, 1
          call _getRands, 2
          loadret r25
          mov r25, r20
          loadi 0, r26
          storeret r26
          br L32
   L32:
