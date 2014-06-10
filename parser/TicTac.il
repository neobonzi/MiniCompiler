_cleanBoard:
          loadinargument board, 0, r17
          loadi 0, r18
          storeai r18, r17,  @a
          loadi 0, r19
          storeai r19, r17,  @b
          loadi 0, r20
          storeai r20, r17,  @c
          loadi 0, r21
          storeai r21, r17,  @d
          loadi 0, r22
          storeai r22, r17,  @e
          loadi 0, r23
          storeai r23, r17,  @f
          loadi 0, r24
          storeai r24, r17,  @g
          loadi 0, r25
          storeai r25, r17,  @h
          loadi 0, r26
          storeai r26, r17,  @i
    L1:
_printBoard:
          loadinargument board, 0, r17
          mov r17, r18
          loadAI r18, @a, r19
          print r19
          mov r17, r20
          loadAI r20, @b, r21
          print r21
          mov r17, r22
          loadAI r22, @c, r23
          print r23
          mov r17, r24
          loadAI r24, @d, r25
          print r25
          mov r17, r26
          loadAI r26, @e, r27
          print r27
          mov r17, r28
          loadAI r28, @f, r29
          print r29
          mov r17, r30
          loadAI r30, @g, r31
          print r31
          mov r17, r32
          loadAI r32, @h, r33
          print r33
          mov r17, r34
          loadAI r34, @i, r35
          print r35
    L2:
_printMoveBoard:
          loadi 123, r17
          print r17
          loadi 456, r18
          print r18
          loadi 789, r19
          print r19
    L3:
_placePiece:
          loadinargument board, 0, r17
          loadinargument turn, 1, r18
          loadinargument placement, 2, r19
    L5:
          mov r19, r20
          loadi 1, r21
          loadi 0, r22
          comp r21, r20, ccr
          moveq 1, r22
          compi 1, r22, ccr
          cbrne cc, L7, L6
    L6:
          mov r18, r23
          storeai r23, r17,  @a
          br L40
   L40:
    L4:
    L7:
    L8:
          mov r19, r24
          loadi 2, r25
          loadi 0, r26
          comp r25, r24, ccr
          moveq 1, r26
          compi 1, r26, ccr
          cbrne cc, L10, L9
    L9:
          mov r18, r27
          storeai r27, r17,  @b
          br L39
   L39:
          br L40
   L10:
   L11:
          mov r19, r28
          loadi 3, r29
          loadi 0, r30
          comp r29, r28, ccr
          moveq 1, r30
          compi 1, r30, ccr
          cbrne cc, L13, L12
   L12:
          mov r18, r31
          storeai r31, r17,  @c
          br L38
   L38:
          br L39
   L13:
   L14:
          mov r19, r32
          loadi 4, r33
          loadi 0, r34
          comp r33, r32, ccr
          moveq 1, r34
          compi 1, r34, ccr
          cbrne cc, L16, L15
   L15:
          mov r18, r35
          storeai r35, r17,  @d
          br L37
   L37:
          br L38
   L16:
   L17:
          mov r19, r36
          loadi 5, r37
          loadi 0, r38
          comp r37, r36, ccr
          moveq 1, r38
          compi 1, r38, ccr
          cbrne cc, L19, L18
   L18:
          mov r18, r39
          storeai r39, r17,  @e
          br L36
   L36:
          br L37
   L19:
   L20:
          mov r19, r40
          loadi 6, r41
          loadi 0, r42
          comp r41, r40, ccr
          moveq 1, r42
          compi 1, r42, ccr
          cbrne cc, L22, L21
   L21:
          mov r18, r43
          storeai r43, r17,  @f
          br L35
   L35:
          br L36
   L22:
   L23:
          mov r19, r44
          loadi 7, r45
          loadi 0, r46
          comp r45, r44, ccr
          moveq 1, r46
          compi 1, r46, ccr
          cbrne cc, L25, L24
   L24:
          mov r18, r47
          storeai r47, r17,  @g
          br L34
   L34:
          br L35
   L25:
   L26:
          mov r19, r48
          loadi 8, r49
          loadi 0, r50
          comp r49, r48, ccr
          moveq 1, r50
          compi 1, r50, ccr
          cbrne cc, L28, L27
   L27:
          mov r18, r51
          storeai r51, r17,  @h
          br L33
   L33:
          br L34
   L28:
   L29:
          mov r19, r52
          loadi 9, r53
          loadi 0, r54
          comp r53, r52, ccr
          moveq 1, r54
          compi 1, r54, ccr
          cbrne cc, L31, L30
   L30:
          mov r18, r55
          storeai r55, r17,  @i
          br L32
   L32:
          br L33
   L31:
          br L32
_checkWinner:
          loadinargument board, 0, r17
   L42:
          mov r17, r18
          loadAI r18, @a, r19
          loadi 1, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L44, L43
   L43:
   L45:
          mov r17, r22
          loadAI r22, @b, r23
          loadi 1, r24
          loadi 0, r25
          comp r24, r23, ccr
          moveq 1, r25
          compi 1, r25, ccr
          cbrne cc, L47, L46
   L46:
   L48:
          mov r17, r26
          loadAI r26, @c, r27
          loadi 1, r28
          loadi 0, r29
          comp r28, r27, ccr
          moveq 1, r29
          compi 1, r29, ccr
          cbrne cc, L50, L49
   L49:
          loadi 0, r30
          storeret r30
          br L41
          br L51
   L51:
          br L52
   L52:
          br L53
   L53:
   L54:
          mov r17, r31
          loadAI r31, @a, r32
          loadi 2, r33
          loadi 0, r34
          comp r33, r32, ccr
          moveq 1, r34
          compi 1, r34, ccr
          cbrne cc, L56, L55
   L55:
   L57:
          mov r17, r35
          loadAI r35, @b, r36
          loadi 2, r37
          loadi 0, r38
          comp r37, r36, ccr
          moveq 1, r38
          compi 1, r38, ccr
          cbrne cc, L59, L58
   L58:
   L60:
          mov r17, r39
          loadAI r39, @c, r40
          loadi 2, r41
          loadi 0, r42
          comp r41, r40, ccr
          moveq 1, r42
          compi 1, r42, ccr
          cbrne cc, L62, L61
   L61:
          loadi 1, r43
          storeret r43
          br L41
          br L63
   L63:
          br L64
   L64:
          br L65
   L65:
   L66:
          mov r17, r44
          loadAI r44, @d, r45
          loadi 1, r46
          loadi 0, r47
          comp r46, r45, ccr
          moveq 1, r47
          compi 1, r47, ccr
          cbrne cc, L68, L67
   L67:
   L69:
          mov r17, r48
          loadAI r48, @e, r49
          loadi 1, r50
          loadi 0, r51
          comp r50, r49, ccr
          moveq 1, r51
          compi 1, r51, ccr
          cbrne cc, L71, L70
   L70:
   L72:
          mov r17, r52
          loadAI r52, @f, r53
          loadi 1, r54
          loadi 0, r55
          comp r54, r53, ccr
          moveq 1, r55
          compi 1, r55, ccr
          cbrne cc, L74, L73
   L73:
          loadi 0, r56
          storeret r56
          br L41
          br L75
   L75:
          br L76
   L76:
          br L77
   L77:
   L78:
          mov r17, r57
          loadAI r57, @d, r58
          loadi 2, r59
          loadi 0, r60
          comp r59, r58, ccr
          moveq 1, r60
          compi 1, r60, ccr
          cbrne cc, L80, L79
   L79:
   L81:
          mov r17, r61
          loadAI r61, @e, r62
          loadi 2, r63
          loadi 0, r64
          comp r63, r62, ccr
          moveq 1, r64
          compi 1, r64, ccr
          cbrne cc, L83, L82
   L82:
   L84:
          mov r17, r65
          loadAI r65, @f, r66
          loadi 2, r67
          loadi 0, r68
          comp r67, r66, ccr
          moveq 1, r68
          compi 1, r68, ccr
          cbrne cc, L86, L85
   L85:
          loadi 1, r69
          storeret r69
          br L41
          br L87
   L87:
          br L88
   L88:
          br L89
   L89:
   L90:
          mov r17, r70
          loadAI r70, @g, r71
          loadi 1, r72
          loadi 0, r73
          comp r72, r71, ccr
          moveq 1, r73
          compi 1, r73, ccr
          cbrne cc, L92, L91
   L91:
   L93:
          mov r17, r74
          loadAI r74, @h, r75
          loadi 1, r76
          loadi 0, r77
          comp r76, r75, ccr
          moveq 1, r77
          compi 1, r77, ccr
          cbrne cc, L95, L94
   L94:
   L96:
          mov r17, r78
          loadAI r78, @i, r79
          loadi 1, r80
          loadi 0, r81
          comp r80, r79, ccr
          moveq 1, r81
          compi 1, r81, ccr
          cbrne cc, L98, L97
   L97:
          loadi 0, r82
          storeret r82
          br L41
          br L99
   L99:
          br L100
  L100:
          br L101
  L101:
  L102:
          mov r17, r83
          loadAI r83, @g, r84
          loadi 2, r85
          loadi 0, r86
          comp r85, r84, ccr
          moveq 1, r86
          compi 1, r86, ccr
          cbrne cc, L104, L103
  L103:
  L105:
          mov r17, r87
          loadAI r87, @h, r88
          loadi 2, r89
          loadi 0, r90
          comp r89, r88, ccr
          moveq 1, r90
          compi 1, r90, ccr
          cbrne cc, L107, L106
  L106:
  L108:
          mov r17, r91
          loadAI r91, @i, r92
          loadi 2, r93
          loadi 0, r94
          comp r93, r92, ccr
          moveq 1, r94
          compi 1, r94, ccr
          cbrne cc, L110, L109
  L109:
          loadi 1, r95
          storeret r95
          br L41
          br L111
  L111:
          br L112
  L112:
          br L113
  L113:
  L114:
          mov r17, r96
          loadAI r96, @a, r97
          loadi 1, r98
          loadi 0, r99
          comp r98, r97, ccr
          moveq 1, r99
          compi 1, r99, ccr
          cbrne cc, L116, L115
  L115:
  L117:
          mov r17, r100
          loadAI r100, @d, r101
          loadi 1, r102
          loadi 0, r103
          comp r102, r101, ccr
          moveq 1, r103
          compi 1, r103, ccr
          cbrne cc, L119, L118
  L118:
  L120:
          mov r17, r104
          loadAI r104, @g, r105
          loadi 1, r106
          loadi 0, r107
          comp r106, r105, ccr
          moveq 1, r107
          compi 1, r107, ccr
          cbrne cc, L122, L121
  L121:
          loadi 0, r108
          storeret r108
          br L41
          br L123
  L123:
          br L124
  L124:
          br L125
  L125:
  L126:
          mov r17, r109
          loadAI r109, @a, r110
          loadi 2, r111
          loadi 0, r112
          comp r111, r110, ccr
          moveq 1, r112
          compi 1, r112, ccr
          cbrne cc, L128, L127
  L127:
  L129:
          mov r17, r113
          loadAI r113, @d, r114
          loadi 2, r115
          loadi 0, r116
          comp r115, r114, ccr
          moveq 1, r116
          compi 1, r116, ccr
          cbrne cc, L131, L130
  L130:
  L132:
          mov r17, r117
          loadAI r117, @g, r118
          loadi 2, r119
          loadi 0, r120
          comp r119, r118, ccr
          moveq 1, r120
          compi 1, r120, ccr
          cbrne cc, L134, L133
  L133:
          loadi 1, r121
          storeret r121
          br L41
          br L135
  L135:
          br L136
  L136:
          br L137
  L137:
  L138:
          mov r17, r122
          loadAI r122, @b, r123
          loadi 1, r124
          loadi 0, r125
          comp r124, r123, ccr
          moveq 1, r125
          compi 1, r125, ccr
          cbrne cc, L140, L139
  L139:
  L141:
          mov r17, r126
          loadAI r126, @e, r127
          loadi 1, r128
          loadi 0, r129
          comp r128, r127, ccr
          moveq 1, r129
          compi 1, r129, ccr
          cbrne cc, L143, L142
  L142:
  L144:
          mov r17, r130
          loadAI r130, @h, r131
          loadi 1, r132
          loadi 0, r133
          comp r132, r131, ccr
          moveq 1, r133
          compi 1, r133, ccr
          cbrne cc, L146, L145
  L145:
          loadi 0, r134
          storeret r134
          br L41
          br L147
  L147:
          br L148
  L148:
          br L149
  L149:
  L150:
          mov r17, r135
          loadAI r135, @b, r136
          loadi 2, r137
          loadi 0, r138
          comp r137, r136, ccr
          moveq 1, r138
          compi 1, r138, ccr
          cbrne cc, L152, L151
  L151:
  L153:
          mov r17, r139
          loadAI r139, @e, r140
          loadi 2, r141
          loadi 0, r142
          comp r141, r140, ccr
          moveq 1, r142
          compi 1, r142, ccr
          cbrne cc, L155, L154
  L154:
  L156:
          mov r17, r143
          loadAI r143, @h, r144
          loadi 2, r145
          loadi 0, r146
          comp r145, r144, ccr
          moveq 1, r146
          compi 1, r146, ccr
          cbrne cc, L158, L157
  L157:
          loadi 1, r147
          storeret r147
          br L41
          br L159
  L159:
          br L160
  L160:
          br L161
  L161:
  L162:
          mov r17, r148
          loadAI r148, @c, r149
          loadi 1, r150
          loadi 0, r151
          comp r150, r149, ccr
          moveq 1, r151
          compi 1, r151, ccr
          cbrne cc, L164, L163
  L163:
  L165:
          mov r17, r152
          loadAI r152, @f, r153
          loadi 1, r154
          loadi 0, r155
          comp r154, r153, ccr
          moveq 1, r155
          compi 1, r155, ccr
          cbrne cc, L167, L166
  L166:
  L168:
          mov r17, r156
          loadAI r156, @i, r157
          loadi 1, r158
          loadi 0, r159
          comp r158, r157, ccr
          moveq 1, r159
          compi 1, r159, ccr
          cbrne cc, L170, L169
  L169:
          loadi 0, r160
          storeret r160
          br L41
          br L171
  L171:
          br L172
  L172:
          br L173
  L173:
  L174:
          mov r17, r161
          loadAI r161, @c, r162
          loadi 2, r163
          loadi 0, r164
          comp r163, r162, ccr
          moveq 1, r164
          compi 1, r164, ccr
          cbrne cc, L176, L175
  L175:
  L177:
          mov r17, r165
          loadAI r165, @f, r166
          loadi 2, r167
          loadi 0, r168
          comp r167, r166, ccr
          moveq 1, r168
          compi 1, r168, ccr
          cbrne cc, L179, L178
  L178:
  L180:
          mov r17, r169
          loadAI r169, @i, r170
          loadi 2, r171
          loadi 0, r172
          comp r171, r170, ccr
          moveq 1, r172
          compi 1, r172, ccr
          cbrne cc, L182, L181
  L181:
          loadi 1, r173
          storeret r173
          br L41
          br L183
  L183:
          br L184
  L184:
          br L185
  L185:
          loadi 1, r174
          loadi -1, r175
          mult r175, r174, r175
          storeret r175
          br L41
   L41:
  L182:
          br L183
  L179:
          br L184
  L176:
          br L185
  L170:
          br L171
  L167:
          br L172
  L164:
          br L173
  L158:
          br L159
  L155:
          br L160
  L152:
          br L161
  L146:
          br L147
  L143:
          br L148
  L140:
          br L149
  L134:
          br L135
  L131:
          br L136
  L128:
          br L137
  L122:
          br L123
  L119:
          br L124
  L116:
          br L125
  L110:
          br L111
  L107:
          br L112
  L104:
          br L113
   L98:
          br L99
   L95:
          br L100
   L92:
          br L101
   L86:
          br L87
   L83:
          br L88
   L80:
          br L89
   L74:
          br L75
   L71:
          br L76
   L68:
          br L77
   L62:
          br L63
   L59:
          br L64
   L56:
          br L65
   L50:
          br L51
   L47:
          br L52
   L44:
          br L53
 _main:
          loadi 0, r23
          mov r23, r21
          loadi 0, r24
          mov r24, r17
          loadi 0, r25
          mov r25, r18
          loadi 0, r26
          mov r26, r19
          loadi 1, r27
          loadi -1, r28
          mult r28, r27, r28
          mov r28, r20
          new gameBoard, r29
          mov r29, r22
          mov r22, r30
          storeoutargument r30, 0
          call _cleanBoard, 1
          loadret r31
          mov r20, r32
          loadi 0, r33
          loadi 0, r34
          comp r33, r32, ccr
          movlt 1, r34
          mov r21, r35
          loadi 8, r36
          loadi 0, r37
          comp r36, r35, ccr
          movne 1, r37
          and r34, r37, r38
          compi 1, r38, ccr
          cbrne cc, L188, L187
  L187:
          mov r22, r39
          storeoutargument r39, 0
          call _printBoard, 1
          loadret r40
  L189:
          mov r17, r41
          loadi 0, r42
          loadi 0, r43
          comp r42, r41, ccr
          moveq 1, r43
          compi 1, r43, ccr
          cbrne cc, L191, L190
  L190:
          mov r17, r44
          loadi 1, r45
          add r44, r45, r46
          mov r46, r17
          read r47
          mov r47, r18
          mov r22, r48
          loadi 1, r49
          mov r18, r50
          storeoutargument r48, 0
          storeoutargument r49, 1
          storeoutargument r50, 2
          call _placePiece, 3
          loadret r51
          br L192
  L192:
          mov r22, r60
          storeoutargument r60, 0
          call _checkWinner, 1
          loadret r61
          mov r61, r20
          mov r21, r62
          loadi 1, r63
          add r62, r63, r64
          mov r64, r21
          mov r20, r65
          loadi 0, r66
          loadi 0, r67
          comp r66, r65, ccr
          movlt 1, r67
          mov r21, r68
          loadi 8, r69
          loadi 0, r70
          comp r69, r68, ccr
          movne 1, r70
          and r67, r70, r71
          compi 1, r71, ccr
          cbrne cc, L188, L187
  L191:
          mov r17, r52
          loadi 1, r53
          sub r52, r53, r54
          mov r54, r17
          read r55
          mov r55, r19
          mov r22, r56
          loadi 2, r57
          mov r19, r58
          storeoutargument r56, 0
          storeoutargument r57, 1
          storeoutargument r58, 2
          call _placePiece, 3
          loadret r59
          br L192
  L188:
          mov r20, r72
          loadi 1, r73
          add r72, r73, r74
          print r74
          loadi 0, r75
          storeret r75
          br L186
  L186:
