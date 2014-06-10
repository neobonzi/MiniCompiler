_multBy4xTimes:
          loadinargument num, 0, r17
          loadinargument timesLeft, 1, r18
    L2:
          mov r18, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          movle 1, r21
          compi 1, r21, ccr
          cbrne cc, L4, L3
    L3:
          mov r17, r22
          loadAI r22, @num, r23
          storeret r23
          br L1
          br L5
    L5:
          loadi 4, r24
          mov r17, r25
          loadAI r25, @num, r26
          mult r24, r26, r27
          storeai r27, r17,  @num
          mov r17, r28
          mov r18, r29
          loadi 1, r30
          sub r29, r30, r31
          storeoutargument r28, 0
          storeoutargument r31, 1
          call _multBy4xTimes, 2
          loadret r32
          mov r17, r33
          loadAI r33, @num, r34
          storeret r34
          br L1
    L1:
    L4:
          br L5
_divideBy8:
          loadinargument num, 0, r17
          mov r17, r18
          loadAI r18, @num, r19
          loadi 2, r20
          div r19, r20, r21
          storeai r21, r17,  @num
          mov r17, r22
          loadAI r22, @num, r23
          loadi 2, r24
          div r23, r24, r25
          storeai r25, r17,  @num
          mov r17, r26
          loadAI r26, @num, r27
          loadi 2, r28
          div r27, r28, r29
          storeai r29, r17,  @num
    L6:
 _main:
          new IntHolder, r26
          mov r26, r23
          loadi 1000000, r27
          computeglobaladdress end, r28
          store r27, r28
          read r29
          mov r29, r17
          read r30
          loadglobal @interval, r30
          mov r30, r31
          mov r17, r32
          print r32
          loadglobal @interval, r33
          print r33
          loadi 0, r34
          mov r34, r18
          mov r18, r35
          loadi 50, r36
          loadi 0, r37
          comp r36, r35, ccr
          movlt 1, r37
          compi 1, r37, ccr
          cbrne cc, L9, L8
    L8:
          loadi 0, r38
          mov r38, r19
          mov r19, r39
          loadglobal @end, r40
          loadi 0, r41
          comp r40, r39, ccr
          movle 1, r41
          compi 1, r41, ccr
          cbrne cc, L11, L10
   L10:
          loadi 1, r42
          loadi 2, r43
          mult r42, r43, r44
          loadi 3, r45
          mult r44, r45, r46
          loadi 4, r47
          mult r46, r47, r48
          loadi 5, r49
          mult r48, r49, r50
          loadi 6, r51
          mult r50, r51, r52
          loadi 7, r53
          mult r52, r53, r54
          loadi 8, r55
          mult r54, r55, r56
          loadi 9, r57
          mult r56, r57, r58
          loadi 10, r59
          mult r58, r59, r60
          loadi 11, r61
          mult r60, r61, r62
          mov r62, r20
          mov r19, r63
          loadi 1, r64
          add r63, r64, r65
          mov r65, r19
          mov r19, r66
          storeai r66, r23,  @num
          mov r23, r67
          loadAI r67, @num, r68
          mov r68, r21
          mov r23, r69
          loadi 2, r70
          storeoutargument r69, 0
          storeoutargument r70, 1
          call _multBy4xTimes, 2
          loadret r71
          mov r23, r72
          storeoutargument r72, 0
          call _divideBy8, 1
          loadret r73
          loadglobal @interval, r74
          loadi 1, r75
          sub r74, r75, r76
          mov r76, r22
          mov r22, r77
          loadi 0, r78
          loadi 0, r79
          comp r78, r77, ccr
          movle 1, r79
          mov r79, r24
   L12:
          mov r22, r80
          loadi 0, r81
          loadi 0, r82
          comp r81, r80, ccr
          movle 1, r82
          compi 1, r82, ccr
          cbrne cc, L14, L13
   L13:
          loadi 1, r83
          mov r83, r22
          br L15
   L15:
          mov r19, r84
          mov r22, r85
          add r84, r85, r86
          mov r86, r19
          mov r19, r87
          loadglobal @end, r88
          loadi 0, r89
          comp r88, r87, ccr
          movle 1, r89
          compi 1, r89, ccr
          cbrne cc, L11, L10
   L14:
          br L15
   L11:
          mov r18, r90
          loadi 1, r91
          add r90, r91, r92
          mov r92, r18
          mov r18, r93
          loadi 50, r94
          loadi 0, r95
          comp r94, r93, ccr
          movlt 1, r95
          compi 1, r95, ccr
          cbrne cc, L9, L8
    L9:
          mov r19, r96
          print r96
          mov r20, r97
          print r97
          loadi 0, r98
          storeret r98
          br L7
    L7:
