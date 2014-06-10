_countTotal:
          loadinargument what, 0, r17
          loadi 0, r19
          mov r19, r18
          mov r17, r20
          loadAI r20, @one, r21
          mov r17, r22
          loadAI r22, @two, r23
          add r21, r23, r24
          mov r17, r25
          loadAI r25, @three, r26
          add r24, r26, r27
          mov r17, r28
          loadAI r28, @four, r29
          add r27, r29, r30
          mov r17, r31
          loadAI r31, @five, r32
          add r30, r32, r33
          mov r17, r34
          loadAI r34, @six, r35
          add r33, r35, r36
          mov r17, r37
          loadAI r37, @seven, r38
          add r36, r38, r39
          mov r17, r40
          loadAI r40, @eight, r41
          add r39, r41, r42
          mov r17, r43
          loadAI r43, @nine, r44
          add r42, r44, r45
          mov r45, r18
          mov r18, r46
          storeret r46
          br L1
    L1:
_printRecursive:
          loadinargument num, 0, r17
          loadinargument rec, 1, r18
    L3:
          mov r18, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L5, L4
    L4:
          mov r17, r22
          storeret r22
          br L2
          br L6
    L6:
    L2:
    L5:
          mov r17, r23
          print r23
          mov r18, r24
          loadi 1, r25
          sub r24, r25, r26
          mov r26, r18
          mov r17, r27
          mov r18, r28
          storeoutargument r27, 0
          storeoutargument r28, 1
          call _printRecursive, 2
          loadret r29
          storeret r29
          br L2
          br L6
_convertBinary:
          loadinargument number, 0, r17
    L8:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          compi 1, r20, ccr
          cbrne cc, L10, L9
    L9:
          loadi 0, r21
          storeret r21
          br L7
          br L43
   L43:
    L7:
   L10:
   L11:
          mov r17, r22
          loadi 1, r23
          loadi 0, r24
          comp r23, r22, ccr
          moveq 1, r24
          compi 1, r24, ccr
          cbrne cc, L13, L12
   L12:
          loadi 1, r25
          storeret r25
          br L7
          br L42
   L42:
          br L43
   L13:
   L14:
          mov r17, r26
          loadi 2, r27
          loadi 0, r28
          comp r27, r26, ccr
          moveq 1, r28
          compi 1, r28, ccr
          cbrne cc, L16, L15
   L15:
          loadi 10, r29
          storeret r29
          br L7
          br L41
   L41:
          br L42
   L16:
   L17:
          mov r17, r30
          loadi 3, r31
          loadi 0, r32
          comp r31, r30, ccr
          moveq 1, r32
          compi 1, r32, ccr
          cbrne cc, L19, L18
   L18:
          loadi 11, r33
          storeret r33
          br L7
          br L40
   L40:
          br L41
   L19:
   L20:
          mov r17, r34
          loadi 4, r35
          loadi 0, r36
          comp r35, r34, ccr
          moveq 1, r36
          compi 1, r36, ccr
          cbrne cc, L22, L21
   L21:
          loadi 100, r37
          storeret r37
          br L7
          br L39
   L39:
          br L40
   L22:
   L23:
          mov r17, r38
          loadi 5, r39
          loadi 0, r40
          comp r39, r38, ccr
          moveq 1, r40
          compi 1, r40, ccr
          cbrne cc, L25, L24
   L24:
          loadi 101, r41
          storeret r41
          br L7
          br L38
   L38:
          br L39
   L25:
   L26:
          mov r17, r42
          loadi 6, r43
          loadi 0, r44
          comp r43, r42, ccr
          moveq 1, r44
          compi 1, r44, ccr
          cbrne cc, L28, L27
   L27:
          loadi 110, r45
          storeret r45
          br L7
          br L37
   L37:
          br L38
   L28:
   L29:
          mov r17, r46
          loadi 7, r47
          loadi 0, r48
          comp r47, r46, ccr
          moveq 1, r48
          compi 1, r48, ccr
          cbrne cc, L31, L30
   L30:
          loadi 111, r49
          storeret r49
          br L7
          br L36
   L36:
          br L37
   L31:
   L32:
          mov r17, r50
          loadi 8, r51
          loadi 0, r52
          comp r51, r50, ccr
          moveq 1, r52
          compi 1, r52, ccr
          cbrne cc, L34, L33
   L33:
          loadi 1000, r53
          storeret r53
          br L7
          br L35
   L35:
          br L36
   L34:
          loadi 1001, r54
          storeret r54
          br L7
          br L35
 _main:
          new LameStruct, r21
          mov r21, r20
          loadi 0, r22
          mov r22, r18
          loadi 0, r23
          storeai r23, r20,  @one
          loadi 0, r24
          storeai r24, r20,  @two
          loadi 0, r25
          storeai r25, r20,  @three
          loadi 0, r26
          storeai r26, r20,  @four
          loadi 0, r27
          storeai r27, r20,  @five
          loadi 0, r28
          storeai r28, r20,  @six
          loadi 0, r29
          storeai r29, r20,  @seven
          loadi 0, r30
          storeai r30, r20,  @eight
          loadi 0, r31
          storeai r31, r20,  @nine
          read r32
          mov r32, r17
          mov r17, r33
          loadi 0, r34
          loadi 0, r35
          comp r34, r33, ccr
          movne 1, r35
          compi 1, r35, ccr
          cbrne cc, L46, L45
   L45:
   L47:
          mov r17, r36
          loadi 1, r37
          loadi 0, r38
          comp r37, r36, ccr
          moveq 1, r38
          compi 1, r38, ccr
          cbrne cc, L49, L48
   L48:
          mov r20, r39
          loadAI r39, @one, r40
          loadi 1, r41
          add r40, r41, r42
          storeai r42, r20,  @one
          br L78
   L78:
          read r96
          mov r96, r17
          mov r17, r97
          loadi 0, r98
          loadi 0, r99
          comp r98, r97, ccr
          movne 1, r99
          compi 1, r99, ccr
          cbrne cc, L46, L45
   L49:
   L50:
          mov r17, r43
          loadi 2, r44
          loadi 0, r45
          comp r44, r43, ccr
          moveq 1, r45
          compi 1, r45, ccr
          cbrne cc, L52, L51
   L51:
          mov r20, r46
          loadAI r46, @two, r47
          loadi 1, r48
          add r47, r48, r49
          storeai r49, r20,  @two
          br L77
   L77:
          br L78
   L52:
   L53:
          mov r17, r50
          loadi 3, r51
          loadi 0, r52
          comp r51, r50, ccr
          moveq 1, r52
          compi 1, r52, ccr
          cbrne cc, L55, L54
   L54:
          mov r20, r53
          loadAI r53, @three, r54
          loadi 1, r55
          add r54, r55, r56
          storeai r56, r20,  @three
          br L76
   L76:
          br L77
   L55:
   L56:
          mov r17, r57
          loadi 4, r58
          loadi 0, r59
          comp r58, r57, ccr
          moveq 1, r59
          compi 1, r59, ccr
          cbrne cc, L58, L57
   L57:
          mov r20, r60
          loadAI r60, @four, r61
          loadi 1, r62
          add r61, r62, r63
          storeai r63, r20,  @four
          br L75
   L75:
          br L76
   L58:
   L59:
          mov r17, r64
          loadi 5, r65
          loadi 0, r66
          comp r65, r64, ccr
          moveq 1, r66
          compi 1, r66, ccr
          cbrne cc, L61, L60
   L60:
          mov r20, r67
          loadAI r67, @five, r68
          loadi 1, r69
          add r68, r69, r70
          storeai r70, r20,  @five
          br L74
   L74:
          br L75
   L61:
   L62:
          mov r17, r71
          loadi 6, r72
          loadi 0, r73
          comp r72, r71, ccr
          moveq 1, r73
          compi 1, r73, ccr
          cbrne cc, L64, L63
   L63:
          mov r20, r74
          loadAI r74, @six, r75
          loadi 1, r76
          add r75, r76, r77
          storeai r77, r20,  @six
          br L73
   L73:
          br L74
   L64:
   L65:
          mov r17, r78
          loadi 7, r79
          loadi 0, r80
          comp r79, r78, ccr
          moveq 1, r80
          compi 1, r80, ccr
          cbrne cc, L67, L66
   L66:
          mov r20, r81
          loadAI r81, @seven, r82
          loadi 1, r83
          add r82, r83, r84
          storeai r84, r20,  @seven
          br L72
   L72:
          br L73
   L67:
   L68:
          mov r17, r85
          loadi 8, r86
          loadi 0, r87
          comp r86, r85, ccr
          moveq 1, r87
          compi 1, r87, ccr
          cbrne cc, L70, L69
   L69:
          mov r20, r88
          loadAI r88, @eight, r89
          loadi 1, r90
          add r89, r90, r91
          storeai r91, r20,  @eight
          br L71
   L71:
          br L72
   L70:
          mov r20, r92
          loadAI r92, @nine, r93
          loadi 1, r94
          add r93, r94, r95
          storeai r95, r20,  @nine
          br L71
   L46:
          mov r20, r100
          storeoutargument r100, 0
          call _countTotal, 1
          loadret r101
          print r101
          loadi 1, r102
          storeoutargument r102, 0
          call _convertBinary, 1
          loadret r103
          mov r20, r104
          loadAI r104, @one, r105
          storeoutargument r103, 0
          storeoutargument r105, 1
          call _printRecursive, 2
          loadret r106
          loadi 2, r107
          storeoutargument r107, 0
          call _convertBinary, 1
          loadret r108
          mov r20, r109
          loadAI r109, @two, r110
          storeoutargument r108, 0
          storeoutargument r110, 1
          call _printRecursive, 2
          loadret r111
          loadi 3, r112
          storeoutargument r112, 0
          call _convertBinary, 1
          loadret r113
          mov r20, r114
          loadAI r114, @three, r115
          storeoutargument r113, 0
          storeoutargument r115, 1
          call _printRecursive, 2
          loadret r116
          loadi 4, r117
          storeoutargument r117, 0
          call _convertBinary, 1
          loadret r118
          mov r20, r119
          loadAI r119, @four, r120
          storeoutargument r118, 0
          storeoutargument r120, 1
          call _printRecursive, 2
          loadret r121
          loadi 5, r122
          storeoutargument r122, 0
          call _convertBinary, 1
          loadret r123
          mov r20, r124
          loadAI r124, @five, r125
          storeoutargument r123, 0
          storeoutargument r125, 1
          call _printRecursive, 2
          loadret r126
          loadi 6, r127
          storeoutargument r127, 0
          call _convertBinary, 1
          loadret r128
          mov r20, r129
          loadAI r129, @six, r130
          storeoutargument r128, 0
          storeoutargument r130, 1
          call _printRecursive, 2
          loadret r131
          loadi 7, r132
          storeoutargument r132, 0
          call _convertBinary, 1
          loadret r133
          mov r20, r134
          loadAI r134, @seven, r135
          storeoutargument r133, 0
          storeoutargument r135, 1
          call _printRecursive, 2
          loadret r136
          loadi 8, r137
          storeoutargument r137, 0
          call _convertBinary, 1
          loadret r138
          mov r20, r139
          loadAI r139, @eight, r140
          storeoutargument r138, 0
          storeoutargument r140, 1
          call _printRecursive, 2
          loadret r141
          loadi 9, r142
          storeoutargument r142, 0
          call _convertBinary, 1
          loadret r143
          mov r20, r144
          loadAI r144, @nine, r145
          storeoutargument r143, 0
          storeoutargument r145, 1
          call _printRecursive, 2
          loadret r146
          loadi 0, r147
          storeret r147
          br L44
   L44:
