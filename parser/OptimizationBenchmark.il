_constantFolding:
          loadi 8, r18
          loadi 9, r19
          mult r18, r19, r20
          loadi 4, r21
          div r20, r21, r22
          loadi 2, r23
          add r22, r23, r24
          loadi 5, r25
          loadi 8, r26
          mult r25, r26, r27
          sub r24, r27, r28
          loadi 9, r29
          add r28, r29, r30
          loadi 12, r31
          sub r30, r31, r32
          loadi 6, r33
          add r32, r33, r34
          loadi 9, r35
          sub r34, r35, r36
          loadi 18, r37
          sub r36, r37, r38
          loadi 23, r39
          loadi 3, r40
          mult r39, r40, r41
          loadi 23, r42
          div r41, r42, r43
          loadi 90, r44
          mult r43, r44, r45
          add r38, r45, r46
          mov r46, r17
          mov r17, r47
          storeret r47
          br L1
    L1:
_constantPropagation:
          loadi 4, r43
          mov r43, r17
          loadi 7, r44
          mov r44, r18
          loadi 8, r45
          mov r45, r19
          loadi 5, r46
          mov r46, r20
          loadi 11, r47
          mov r47, r21
          loadi 21, r48
          mov r48, r22
          mov r17, r49
          mov r18, r50
          add r49, r50, r51
          mov r51, r23
          mov r19, r52
          mov r20, r53
          add r52, r53, r54
          mov r54, r24
          mov r21, r55
          mov r22, r56
          add r55, r56, r57
          mov r57, r25
          mov r23, r58
          mov r24, r59
          add r58, r59, r60
          mov r60, r26
          mov r25, r61
          mov r26, r62
          mult r61, r62, r63
          mov r63, r27
          mov r21, r64
          mov r24, r65
          mov r25, r66
          mult r65, r66, r67
          add r64, r67, r68
          mov r27, r69
          sub r68, r69, r70
          mov r70, r28
          mov r24, r71
          mov r25, r72
          mov r26, r73
          mult r72, r73, r74
          sub r71, r74, r75
          mov r27, r76
          mov r28, r77
          div r76, r77, r78
          add r75, r78, r79
          mov r79, r29
          mov r21, r80
          mov r22, r81
          add r80, r81, r82
          mov r23, r83
          add r82, r83, r84
          mov r24, r85
          add r84, r85, r86
          mov r25, r87
          add r86, r87, r88
          mov r26, r89
          sub r88, r89, r90
          mov r90, r30
          mov r30, r91
          mov r29, r92
          sub r91, r92, r93
          mov r24, r94
          add r93, r94, r95
          mov r17, r96
          sub r95, r96, r97
          mov r18, r98
          sub r97, r98, r99
          mov r99, r31
          mov r27, r100
          mov r28, r101
          add r100, r101, r102
          mov r23, r103
          sub r102, r103, r104
          mov r24, r105
          sub r104, r105, r106
          mov r106, r32
          mov r18, r107
          mov r17, r108
          sub r107, r108, r109
          mov r20, r110
          mult r109, r110, r111
          mov r25, r112
          sub r111, r112, r113
          mov r113, r33
          mov r28, r114
          mov r19, r115
          mult r114, r115, r116
          mov r20, r117
          mult r116, r117, r118
          mov r31, r119
          add r118, r119, r120
          mov r120, r34
          mov r18, r121
          mov r17, r122
          mult r121, r122, r123
          mov r19, r124
          mult r123, r124, r125
          mov r21, r126
          div r125, r126, r127
          mov r31, r128
          sub r127, r128, r129
          mov r129, r35
          mov r25, r130
          mov r27, r131
          add r130, r131, r132
          mov r19, r133
          add r132, r133, r134
          mov r32, r135
          sub r134, r135, r136
          mov r136, r36
          mov r30, r137
          mov r31, r138
          add r137, r138, r139
          mov r22, r140
          mov r17, r141
          mult r140, r141, r142
          sub r139, r142, r143
          mov r143, r37
          mov r17, r144
          mov r18, r145
          mult r144, r145, r146
          mov r27, r147
          sub r146, r147, r148
          mov r28, r149
          sub r148, r149, r150
          mov r150, r38
          mov r38, r151
          mov r35, r152
          sub r151, r152, r153
          mov r34, r154
          mov r20, r155
          mult r154, r155, r156
          sub r153, r156, r157
          mov r157, r39
          mov r31, r158
          mov r39, r159
          sub r158, r159, r160
          mov r38, r161
          sub r160, r161, r162
          mov r30, r163
          sub r162, r163, r164
          mov r164, r40
          mov r32, r165
          mov r40, r166
          mult r165, r166, r167
          mov r36, r168
          mult r167, r168, r169
          mov r39, r170
          sub r169, r170, r171
          mov r171, r41
          mov r39, r172
          mov r40, r173
          mov r41, r174
          mult r173, r174, r175
          sub r172, r175, r176
          mov r27, r177
          add r176, r177, r178
          mov r178, r42
          mov r42, r179
          storeret r179
          br L2
    L2:
_deadCodeElimination:
          loadi 4, r22
          mov r22, r17
          loadi 5, r23
          mov r23, r17
          loadi 7, r24
          mov r24, r17
          loadi 8, r25
          mov r25, r17
          loadi 6, r26
          mov r26, r18
          loadi 9, r27
          mov r27, r18
          loadi 12, r28
          mov r28, r18
          loadi 8, r29
          mov r29, r18
          loadi 10, r30
          mov r30, r19
          loadi 13, r31
          mov r31, r19
          loadi 9, r32
          mov r32, r19
          loadi 45, r33
          mov r33, r20
          loadi 12, r34
          mov r34, r20
          loadi 3, r35
          mov r35, r20
          loadi 23, r36
          mov r36, r21
          loadi 10, r37
          mov r37, r21
          loadi 11, r38
          computeglobaladdress global1, r39
          store r38, r39
          loadi 5, r40
          computeglobaladdress global1, r41
          store r40, r41
          loadi 9, r42
          computeglobaladdress global1, r43
          store r42, r43
          mov r17, r44
          mov r18, r45
          add r44, r45, r46
          mov r19, r47
          add r46, r47, r48
          mov r20, r49
          add r48, r49, r50
          mov r21, r51
          add r50, r51, r52
          storeret r52
          br L3
    L3:
  _sum:
          loadinargument number, 0, r17
          loadi 0, r19
          mov r19, r18
          mov r17, r20
          loadi 0, r21
          loadi 0, r22
          comp r21, r20, ccr
          movgt 1, r22
          compi 1, r22, ccr
          cbrne cc, L6, L5
    L5:
          mov r18, r23
          mov r17, r24
          add r23, r24, r25
          mov r25, r18
          mov r17, r26
          loadi 1, r27
          sub r26, r27, r28
          mov r28, r17
          mov r17, r29
          loadi 0, r30
          loadi 0, r31
          comp r30, r29, ccr
          movgt 1, r31
          compi 1, r31, ccr
          cbrne cc, L6, L5
    L6:
          mov r18, r32
          storeret r32
          br L4
    L4:
_doesntModifyGlobals:
          loadi 1, r19
          mov r19, r17
          loadi 2, r20
          mov r20, r18
          mov r17, r21
          mov r18, r22
          add r21, r22, r23
          storeret r23
          br L7
    L7:
_interProceduralOptimization:
          loadi 1, r18
          computeglobaladdress global1, r19
          store r18, r19
          loadi 0, r20
          computeglobaladdress global2, r21
          store r20, r21
          loadi 0, r22
          computeglobaladdress global3, r23
          store r22, r23
          loadi 100, r24
          storeoutargument r24, 0
          call _sum, 1
          loadret r25
          mov r25, r17
    L9:
          loadglobal @global1, r26
          loadi 1, r27
          loadi 0, r28
          comp r27, r26, ccr
          moveq 1, r28
          compi 1, r28, ccr
          cbrne cc, L11, L10
   L10:
          loadi 10000, r29
          storeoutargument r29, 0
          call _sum, 1
          loadret r30
          mov r30, r17
          br L20
   L20:
          mov r17, r41
          storeret r41
          br L8
    L8:
   L11:
   L12:
          loadglobal @global2, r31
          loadi 2, r32
          loadi 0, r33
          comp r32, r31, ccr
          moveq 1, r33
          compi 1, r33, ccr
          cbrne cc, L14, L13
   L13:
          loadi 20000, r34
          storeoutargument r34, 0
          call _sum, 1
          loadret r35
          mov r35, r17
          br L15
   L15:
   L16:
          loadglobal @global3, r36
          loadi 3, r37
          loadi 0, r38
          comp r37, r36, ccr
          moveq 1, r38
          compi 1, r38, ccr
          cbrne cc, L18, L17
   L17:
          loadi 30000, r39
          storeoutargument r39, 0
          call _sum, 1
          loadret r40
          mov r40, r17
          br L19
   L19:
          br L20
   L18:
          br L19
   L14:
          br L15
_commonSubexpressionElimination:
          loadi 11, r43
          mov r43, r17
          loadi 22, r44
          mov r44, r18
          loadi 33, r45
          mov r45, r19
          loadi 44, r46
          mov r46, r20
          loadi 55, r47
          mov r47, r21
          loadi 66, r48
          mov r48, r22
          loadi 77, r49
          mov r49, r23
          mov r17, r50
          mov r18, r51
          mult r50, r51, r52
          mov r52, r24
          mov r19, r53
          mov r20, r54
          div r53, r54, r55
          mov r55, r25
          mov r21, r56
          mov r22, r57
          mult r56, r57, r58
          mov r58, r26
          mov r17, r59
          mov r18, r60
          mult r59, r60, r61
          mov r19, r62
          mov r20, r63
          div r62, r63, r64
          add r61, r64, r65
          mov r21, r66
          mov r22, r67
          mult r66, r67, r68
          sub r65, r68, r69
          mov r23, r70
          add r69, r70, r71
          mov r71, r27
          mov r17, r72
          mov r18, r73
          mult r72, r73, r74
          mov r19, r75
          mov r20, r76
          div r75, r76, r77
          add r74, r77, r78
          mov r21, r79
          mov r22, r80
          mult r79, r80, r81
          sub r78, r81, r82
          mov r23, r83
          add r82, r83, r84
          mov r84, r28
          mov r17, r85
          mov r18, r86
          mult r85, r86, r87
          mov r19, r88
          mov r20, r89
          div r88, r89, r90
          add r87, r90, r91
          mov r21, r92
          mov r22, r93
          mult r92, r93, r94
          sub r91, r94, r95
          mov r23, r96
          add r95, r96, r97
          mov r97, r29
          mov r17, r98
          mov r18, r99
          mult r98, r99, r100
          mov r19, r101
          mov r20, r102
          div r101, r102, r103
          add r100, r103, r104
          mov r21, r105
          mov r22, r106
          mult r105, r106, r107
          sub r104, r107, r108
          mov r23, r109
          add r108, r109, r110
          mov r110, r30
          mov r17, r111
          mov r18, r112
          mult r111, r112, r113
          mov r19, r114
          mov r20, r115
          div r114, r115, r116
          add r113, r116, r117
          mov r21, r118
          mov r22, r119
          mult r118, r119, r120
          sub r117, r120, r121
          mov r23, r122
          add r121, r122, r123
          mov r123, r31
          mov r17, r124
          mov r18, r125
          mult r124, r125, r126
          mov r19, r127
          mov r20, r128
          div r127, r128, r129
          add r126, r129, r130
          mov r21, r131
          mov r22, r132
          mult r131, r132, r133
          sub r130, r133, r134
          mov r23, r135
          add r134, r135, r136
          mov r136, r32
          mov r17, r137
          mov r18, r138
          mult r137, r138, r139
          mov r19, r140
          mov r20, r141
          div r140, r141, r142
          add r139, r142, r143
          mov r21, r144
          mov r22, r145
          mult r144, r145, r146
          sub r143, r146, r147
          mov r23, r148
          add r147, r148, r149
          mov r149, r33
          mov r17, r150
          mov r18, r151
          mult r150, r151, r152
          mov r19, r153
          mov r20, r154
          div r153, r154, r155
          add r152, r155, r156
          mov r21, r157
          mov r22, r158
          mult r157, r158, r159
          sub r156, r159, r160
          mov r23, r161
          add r160, r161, r162
          mov r162, r34
          mov r17, r163
          mov r18, r164
          mult r163, r164, r165
          mov r19, r166
          mov r20, r167
          div r166, r167, r168
          add r165, r168, r169
          mov r21, r170
          mov r22, r171
          mult r170, r171, r172
          sub r169, r172, r173
          mov r23, r174
          add r173, r174, r175
          mov r175, r35
          mov r17, r176
          mov r18, r177
          mult r176, r177, r178
          mov r19, r179
          mov r20, r180
          div r179, r180, r181
          add r178, r181, r182
          mov r21, r183
          mov r22, r184
          mult r183, r184, r185
          sub r182, r185, r186
          mov r23, r187
          add r186, r187, r188
          mov r188, r36
          mov r17, r189
          mov r18, r190
          mult r189, r190, r191
          mov r19, r192
          mov r20, r193
          div r192, r193, r194
          add r191, r194, r195
          mov r21, r196
          mov r22, r197
          mult r196, r197, r198
          sub r195, r198, r199
          mov r23, r200
          add r199, r200, r201
          mov r201, r37
          mov r18, r202
          mov r17, r203
          mult r202, r203, r204
          mov r19, r205
          mov r20, r206
          div r205, r206, r207
          add r204, r207, r208
          mov r21, r209
          mov r22, r210
          mult r209, r210, r211
          sub r208, r211, r212
          mov r23, r213
          add r212, r213, r214
          mov r214, r38
          mov r17, r215
          mov r18, r216
          mult r215, r216, r217
          mov r19, r218
          mov r20, r219
          div r218, r219, r220
          add r217, r220, r221
          mov r22, r222
          mov r21, r223
          mult r222, r223, r224
          sub r221, r224, r225
          mov r23, r226
          add r225, r226, r227
          mov r227, r39
          mov r23, r228
          mov r17, r229
          mov r18, r230
          mult r229, r230, r231
          add r228, r231, r232
          mov r19, r233
          mov r20, r234
          div r233, r234, r235
          add r232, r235, r236
          mov r21, r237
          mov r22, r238
          mult r237, r238, r239
          sub r236, r239, r240
          mov r240, r40
          mov r17, r241
          mov r18, r242
          mult r241, r242, r243
          mov r19, r244
          mov r20, r245
          div r244, r245, r246
          add r243, r246, r247
          mov r21, r248
          mov r22, r249
          mult r248, r249, r250
          sub r247, r250, r251
          mov r23, r252
          add r251, r252, r253
          mov r253, r41
          mov r19, r254
          mov r20, r255
          div r254, r255, r256
          mov r17, r257
          mov r18, r258
          mult r257, r258, r259
          add r256, r259, r260
          mov r21, r261
          mov r22, r262
          mult r261, r262, r263
          sub r260, r263, r264
          mov r23, r265
          add r264, r265, r266
          mov r266, r42
          mov r17, r267
          mov r18, r268
          add r267, r268, r269
          mov r19, r270
          add r269, r270, r271
          mov r20, r272
          add r271, r272, r273
          mov r21, r274
          add r273, r274, r275
          mov r22, r276
          add r275, r276, r277
          mov r23, r278
          add r277, r278, r279
          mov r24, r280
          add r279, r280, r281
          mov r25, r282
          add r281, r282, r283
          mov r26, r284
          add r283, r284, r285
          mov r27, r286
          add r285, r286, r287
          mov r28, r288
          add r287, r288, r289
          mov r29, r290
          add r289, r290, r291
          mov r30, r292
          add r291, r292, r293
          mov r31, r294
          add r293, r294, r295
          mov r32, r296
          add r295, r296, r297
          mov r33, r298
          add r297, r298, r299
          mov r34, r300
          add r299, r300, r301
          mov r35, r302
          add r301, r302, r303
          mov r36, r304
          add r303, r304, r305
          mov r37, r306
          add r305, r306, r307
          mov r38, r308
          add r307, r308, r309
          mov r39, r310
          add r309, r310, r311
          mov r40, r312
          add r311, r312, r313
          mov r41, r314
          add r313, r314, r315
          mov r42, r316
          add r315, r316, r317
          storeret r317
          br L21
   L21:
_hoisting:
          loadi 1, r26
          mov r26, r17
          loadi 2, r27
          mov r27, r18
          loadi 3, r28
          mov r28, r19
          loadi 4, r29
          mov r29, r20
          loadi 0, r30
          mov r30, r25
          mov r25, r31
          loadi 1000000, r32
          loadi 0, r33
          comp r32, r31, ccr
          movlt 1, r33
          compi 1, r33, ccr
          cbrne cc, L24, L23
   L23:
          loadi 5, r34
          mov r34, r21
          mov r17, r35
          mov r18, r36
          add r35, r36, r37
          mov r19, r38
          add r37, r38, r39
          mov r39, r23
          mov r19, r40
          mov r20, r41
          add r40, r41, r42
          mov r23, r43
          add r42, r43, r44
          mov r44, r24
          mov r25, r45
          loadi 1, r46
          add r45, r46, r47
          mov r47, r25
          mov r25, r48
          loadi 1000000, r49
          loadi 0, r50
          comp r49, r48, ccr
          movlt 1, r50
          compi 1, r50, ccr
          cbrne cc, L24, L23
   L24:
          mov r18, r51
          storeret r51
          br L22
   L22:
_doubleIf:
          loadi 1, r21
          mov r21, r17
          loadi 2, r22
          mov r22, r18
          loadi 3, r23
          mov r23, r19
   L26:
          mov r17, r24
          loadi 1, r25
          loadi 0, r26
          comp r25, r24, ccr
          moveq 1, r26
          compi 1, r26, ccr
          cbrne cc, L28, L27
   L27:
          loadi 20, r27
          mov r27, r18
   L29:
          mov r17, r28
          loadi 1, r29
          loadi 0, r30
          comp r29, r28, ccr
          moveq 1, r30
          compi 1, r30, ccr
          cbrne cc, L31, L30
   L30:
          loadi 200, r31
          mov r31, r18
          loadi 300, r32
          mov r32, r19
          br L32
   L32:
          loadi 50, r36
          mov r36, r20
          br L33
   L33:
          mov r20, r37
          storeret r37
          br L25
   L25:
   L31:
          loadi 1, r33
          mov r33, r17
          loadi 2, r34
          mov r34, r18
          loadi 3, r35
          mov r35, r19
          br L32
   L28:
          br L33
_integerDivide:
          loadi 3000, r18
          mov r18, r17
          mov r17, r19
          loadi 2, r20
          div r19, r20, r21
          mov r21, r17
          mov r17, r22
          loadi 4, r23
          mult r22, r23, r24
          mov r24, r17
          mov r17, r25
          loadi 8, r26
          div r25, r26, r27
          mov r27, r17
          mov r17, r28
          loadi 16, r29
          div r28, r29, r30
          mov r30, r17
          mov r17, r31
          loadi 32, r32
          mult r31, r32, r33
          mov r33, r17
          mov r17, r34
          loadi 64, r35
          div r34, r35, r36
          mov r36, r17
          mov r17, r37
          loadi 128, r38
          mult r37, r38, r39
          mov r39, r17
          mov r17, r40
          loadi 4, r41
          div r40, r41, r42
          mov r42, r17
          mov r17, r43
          storeret r43
          br L34
   L34:
_association:
          loadi 10, r18
          mov r18, r17
          mov r17, r19
          loadi 2, r20
          mult r19, r20, r21
          mov r21, r17
          mov r17, r22
          loadi 2, r23
          div r22, r23, r24
          mov r24, r17
          loadi 3, r25
          mov r17, r26
          mult r25, r26, r27
          mov r27, r17
          mov r17, r28
          loadi 3, r29
          div r28, r29, r30
          mov r30, r17
          mov r17, r31
          loadi 4, r32
          mult r31, r32, r33
          mov r33, r17
          mov r17, r34
          loadi 4, r35
          div r34, r35, r36
          mov r36, r17
          mov r17, r37
          loadi 4, r38
          add r37, r38, r39
          mov r39, r17
          mov r17, r40
          loadi 4, r41
          sub r40, r41, r42
          mov r42, r17
          mov r17, r43
          loadi 50, r44
          mult r43, r44, r45
          mov r45, r17
          mov r17, r46
          loadi 50, r47
          div r46, r47, r48
          mov r48, r17
          mov r17, r49
          storeret r49
          br L35
   L35:
_tailRecursionHelper:
          loadinargument value, 0, r17
          loadinargument sum, 1, r18
   L37:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L39, L38
   L38:
          mov r18, r22
          storeret r22
          br L36
          br L40
   L40:
   L36:
   L39:
          mov r17, r23
          loadi 1, r24
          sub r23, r24, r25
          mov r18, r26
          mov r17, r27
          add r26, r27, r28
          storeoutargument r25, 0
          storeoutargument r28, 1
          call _tailRecursionHelper, 2
          loadret r29
          storeret r29
          br L36
          br L40
_tailRecursion:
          loadinargument value, 0, r17
          mov r17, r18
          loadi 0, r19
          storeoutargument r18, 0
          storeoutargument r19, 1
          call _tailRecursionHelper, 2
          loadret r20
          storeret r20
          br L41
   L41:
_unswitching:
          loadi 1, r19
          mov r19, r17
          loadi 2, r20
          mov r20, r18
          mov r17, r21
          loadi 1000000, r22
          loadi 0, r23
          comp r22, r21, ccr
          movlt 1, r23
          compi 1, r23, ccr
          cbrne cc, L44, L43
   L43:
   L45:
          mov r18, r24
          loadi 2, r25
          loadi 0, r26
          comp r25, r24, ccr
          moveq 1, r26
          compi 1, r26, ccr
          cbrne cc, L47, L46
   L46:
          mov r17, r27
          loadi 1, r28
          add r27, r28, r29
          mov r29, r17
          br L48
   L48:
          mov r17, r33
          loadi 1000000, r34
          loadi 0, r35
          comp r34, r33, ccr
          movlt 1, r35
          compi 1, r35, ccr
          cbrne cc, L44, L43
   L47:
          mov r17, r30
          loadi 2, r31
          add r30, r31, r32
          mov r32, r17
          br L48
   L44:
          mov r17, r36
          storeret r36
          br L42
   L42:
_randomCalculation:
          loadinargument number, 0, r17
          loadi 0, r25
          mov r25, r23
          loadi 0, r26
          mov r26, r24
          mov r23, r27
          mov r17, r28
          loadi 0, r29
          comp r28, r27, ccr
          movlt 1, r29
          compi 1, r29, ccr
          cbrne cc, L51, L50
   L50:
          loadi 4, r30
          mov r30, r18
          loadi 7, r31
          mov r31, r19
          loadi 8, r32
          mov r32, r20
          mov r18, r33
          mov r19, r34
          add r33, r34, r35
          mov r35, r21
          mov r21, r36
          mov r20, r37
          add r36, r37, r38
          mov r38, r22
          mov r24, r39
          mov r22, r40
          add r39, r40, r41
          mov r41, r24
          mov r23, r42
          loadi 2, r43
          mult r42, r43, r44
          mov r44, r23
          mov r23, r45
          loadi 2, r46
          div r45, r46, r47
          mov r47, r23
          loadi 3, r48
          mov r23, r49
          mult r48, r49, r50
          mov r50, r23
          mov r23, r51
          loadi 3, r52
          div r51, r52, r53
          mov r53, r23
          mov r23, r54
          loadi 4, r55
          mult r54, r55, r56
          mov r56, r23
          mov r23, r57
          loadi 4, r58
          div r57, r58, r59
          mov r59, r23
          mov r23, r60
          loadi 1, r61
          add r60, r61, r62
          mov r62, r23
          mov r23, r63
          mov r17, r64
          loadi 0, r65
          comp r64, r63, ccr
          movlt 1, r65
          compi 1, r65, ccr
          cbrne cc, L51, L50
   L51:
          mov r24, r66
          storeret r66
          br L49
   L49:
_iterativeFibonacci:
          loadinargument number, 0, r17
          loadi 1, r23
          loadi -1, r24
          mult r24, r23, r24
          mov r24, r18
          loadi 1, r25
          mov r25, r19
          loadi 0, r26
          mov r26, r21
          mov r21, r27
          mov r17, r28
          loadi 0, r29
          comp r28, r27, ccr
          movlt 1, r29
          compi 1, r29, ccr
          cbrne cc, L54, L53
   L53:
          mov r19, r30
          mov r18, r31
          add r30, r31, r32
          mov r32, r22
          mov r19, r33
          mov r33, r18
          mov r22, r34
          mov r34, r19
          mov r21, r35
          loadi 1, r36
          add r35, r36, r37
          mov r37, r21
          mov r21, r38
          mov r17, r39
          loadi 0, r40
          comp r39, r38, ccr
          movlt 1, r40
          compi 1, r40, ccr
          cbrne cc, L54, L53
   L54:
          mov r19, r41
          storeret r41
          br L52
   L52:
_recursiveFibonacci:
          loadinargument number, 0, r17
   L56:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movle 1, r20
          mov r17, r21
          loadi 1, r22
          loadi 0, r23
          comp r22, r21, ccr
          moveq 1, r23
          or r20, r23, r24
          compi 1, r24, ccr
          cbrne cc, L58, L57
   L57:
          mov r17, r25
          storeret r25
          br L55
          br L59
   L59:
   L55:
   L58:
          mov r17, r26
          loadi 1, r27
          sub r26, r27, r28
          storeoutargument r28, 0
          call _recursiveFibonacci, 1
          loadret r29
          mov r17, r30
          loadi 2, r31
          sub r30, r31, r32
          storeoutargument r32, 0
          call _recursiveFibonacci, 1
          loadret r33
          add r29, r33, r34
          storeret r34
          br L55
          br L59
 _main:
          read r20
          mov r20, r17
          loadi 1, r21
          mov r21, r19
          mov r19, r22
          mov r17, r23
          loadi 0, r24
          comp r23, r22, ccr
          movlt 1, r24
          compi 1, r24, ccr
          cbrne cc, L62, L61
   L61:
          call _constantFolding, 0
          loadret r25
          mov r25, r18
          mov r18, r26
          print r26
          call _constantPropagation, 0
          loadret r27
          mov r27, r18
          mov r18, r28
          print r28
          call _deadCodeElimination, 0
          loadret r29
          mov r29, r18
          mov r18, r30
          print r30
          call _interProceduralOptimization, 0
          loadret r31
          mov r31, r18
          mov r18, r32
          print r32
          call _commonSubexpressionElimination, 0
          loadret r33
          mov r33, r18
          mov r18, r34
          print r34
          call _hoisting, 0
          loadret r35
          mov r35, r18
          mov r18, r36
          print r36
          call _doubleIf, 0
          loadret r37
          mov r37, r18
          mov r18, r38
          print r38
          call _integerDivide, 0
          loadret r39
          mov r39, r18
          mov r18, r40
          print r40
          call _association, 0
          loadret r41
          mov r41, r18
          mov r18, r42
          print r42
          mov r17, r43
          loadi 1000, r44
          div r43, r44, r45
          storeoutargument r45, 0
          call _tailRecursion, 1
          loadret r46
          mov r46, r18
          mov r18, r47
          print r47
          call _unswitching, 0
          loadret r48
          mov r48, r18
          mov r18, r49
          print r49
          mov r17, r50
          storeoutargument r50, 0
          call _randomCalculation, 1
          loadret r51
          mov r51, r18
          mov r18, r52
          print r52
          mov r17, r53
          loadi 5, r54
          div r53, r54, r55
          storeoutargument r55, 0
          call _iterativeFibonacci, 1
          loadret r56
          mov r56, r18
          mov r18, r57
          print r57
          mov r17, r58
          loadi 1000, r59
          div r58, r59, r60
          storeoutargument r60, 0
          call _recursiveFibonacci, 1
          loadret r61
          mov r61, r18
          mov r18, r62
          print r62
          mov r19, r63
          loadi 1, r64
          add r63, r64, r65
          mov r65, r19
          mov r19, r66
          mov r17, r67
          loadi 0, r68
          comp r67, r66, ccr
          movlt 1, r68
          compi 1, r68, ccr
          cbrne cc, L62, L61
   L62:
          loadi 9999, r69
          print r69
          loadi 0, r70
          storeret r70
          br L60
   L60:
