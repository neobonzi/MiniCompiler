 _move:
          loadinargument from, 0, r17
          loadinargument to, 1, r18
    L2:
          mov r17, r20
          loadi 1, r21
          loadi 0, r22
          comp r21, r20, ccr
          moveq 1, r22
          compi 1, r22, ccr
          cbrne cc, L4, L3
    L3:
          loadglobal @peg1, r23
          mov r23, r19
          loadglobal @peg1, r24
          loadAI r24, @plateUnder, r25
          computeglobaladdress peg1, r26
          store r25, r26
          br L9
    L9:
   L10:
          mov r18, r38
          loadi 1, r39
          loadi 0, r40
          comp r39, r38, ccr
          moveq 1, r40
          compi 1, r40, ccr
          cbrne cc, L12, L11
   L11:
          loadglobal @peg1, r41
          storeai r41, r19,  @plateUnder
          mov r19, r42
          computeglobaladdress peg1, r43
          store r42, r43
          br L17
   L17:
          loadglobal @numMoves, r53
          loadi 1, r54
          add r53, r54, r55
          computeglobaladdress numMoves, r56
          store r55, r56
    L1:
   L12:
   L13:
          mov r18, r44
          loadi 2, r45
          loadi 0, r46
          comp r45, r44, ccr
          moveq 1, r46
          compi 1, r46, ccr
          cbrne cc, L15, L14
   L14:
          loadglobal @peg2, r47
          storeai r47, r19,  @plateUnder
          mov r19, r48
          computeglobaladdress peg2, r49
          store r48, r49
          br L16
   L16:
          br L17
   L15:
          loadglobal @peg3, r50
          storeai r50, r19,  @plateUnder
          mov r19, r51
          computeglobaladdress peg3, r52
          store r51, r52
          br L16
    L4:
    L5:
          mov r17, r27
          loadi 2, r28
          loadi 0, r29
          comp r28, r27, ccr
          moveq 1, r29
          compi 1, r29, ccr
          cbrne cc, L7, L6
    L6:
          loadglobal @peg2, r30
          mov r30, r19
          loadglobal @peg2, r31
          loadAI r31, @plateUnder, r32
          computeglobaladdress peg2, r33
          store r32, r33
          br L8
    L8:
          br L9
    L7:
          loadglobal @peg3, r34
          mov r34, r19
          loadglobal @peg3, r35
          loadAI r35, @plateUnder, r36
          computeglobaladdress peg3, r37
          store r36, r37
          br L8
_hanoi:
          loadinargument n, 0, r17
          loadinargument from, 1, r18
          loadinargument to, 2, r19
          loadinargument other, 3, r20
   L19:
          mov r17, r21
          loadi 1, r22
          loadi 0, r23
          comp r22, r21, ccr
          moveq 1, r23
          compi 1, r23, ccr
          cbrne cc, L21, L20
   L20:
          mov r18, r24
          mov r19, r25
          storeoutargument r24, 0
          storeoutargument r25, 1
          call _move, 2
          loadret r26
          br L22
   L22:
   L18:
   L21:
          mov r17, r27
          loadi 1, r28
          sub r27, r28, r29
          mov r18, r30
          mov r20, r31
          mov r19, r32
          storeoutargument r29, 0
          storeoutargument r30, 1
          storeoutargument r31, 2
          storeoutargument r32, 3
          call _hanoi, 4
          loadret r33
          mov r18, r34
          mov r19, r35
          storeoutargument r34, 0
          storeoutargument r35, 1
          call _move, 2
          loadret r36
          mov r17, r37
          loadi 1, r38
          sub r37, r38, r39
          mov r20, r40
          mov r19, r41
          mov r18, r42
          storeoutargument r39, 0
          storeoutargument r40, 1
          storeoutargument r41, 2
          storeoutargument r42, 3
          call _hanoi, 4
          loadret r43
          br L22
_printPeg:
          loadinargument peg, 0, r17
          mov r17, r19
          mov r19, r18
          mov r18, r20
          loadi 0, r21
          loadi 0, r22
          comp r21, r20, ccr
          movne 1, r22
          compi 1, r22, ccr
          cbrne cc, L25, L24
   L24:
          mov r18, r23
          loadAI r23, @size, r24
          print r24
          mov r18, r25
          loadAI r25, @plateUnder, r26
          mov r26, r18
          mov r18, r27
          loadi 0, r28
          loadi 0, r29
          comp r28, r27, ccr
          movne 1, r29
          compi 1, r29, ccr
          cbrne cc, L25, L24
   L25:
   L23:
 _main:
          loadi 0, r20
          computeglobaladdress peg1, r21
          store r20, r21
          loadi 0, r22
          computeglobaladdress peg2, r23
          store r22, r23
          loadi 0, r24
          computeglobaladdress peg3, r25
          store r24, r25
          loadi 0, r26
          computeglobaladdress numMoves, r27
          store r26, r27
          read r28
          mov r28, r18
   L27:
          mov r18, r29
          loadi 1, r30
          loadi 0, r31
          comp r30, r29, ccr
          movge 1, r31
          compi 1, r31, ccr
          cbrne cc, L29, L28
   L28:
          mov r18, r32
          mov r32, r17
          mov r17, r33
          loadi 0, r34
          loadi 0, r35
          comp r34, r33, ccr
          movne 1, r35
          compi 1, r35, ccr
          cbrne cc, L31, L30
   L30:
          new plate, r36
          mov r36, r19
          mov r17, r37
          storeai r37, r19,  @size
          loadglobal @peg1, r38
          storeai r38, r19,  @plateUnder
          mov r19, r39
          computeglobaladdress peg1, r40
          store r39, r40
          mov r17, r41
          loadi 1, r42
          sub r41, r42, r43
          mov r43, r17
          mov r17, r44
          loadi 0, r45
          loadi 0, r46
          comp r45, r44, ccr
          movne 1, r46
          compi 1, r46, ccr
          cbrne cc, L31, L30
   L31:
          loadi 1, r47
          print r47
          loadglobal @peg1, r48
          storeoutargument r48, 0
          call _printPeg, 1
          loadret r49
          loadi 2, r50
          print r50
          loadglobal @peg2, r51
          storeoutargument r51, 0
          call _printPeg, 1
          loadret r52
          loadi 3, r53
          print r53
          loadglobal @peg3, r54
          storeoutargument r54, 0
          call _printPeg, 1
          loadret r55
          mov r18, r56
          loadi 1, r57
          loadi 3, r58
          loadi 2, r59
          storeoutargument r56, 0
          storeoutargument r57, 1
          storeoutargument r58, 2
          storeoutargument r59, 3
          call _hanoi, 4
          loadret r60
          loadi 1, r61
          print r61
          loadglobal @peg1, r62
          storeoutargument r62, 0
          call _printPeg, 1
          loadret r63
          loadi 2, r64
          print r64
          loadglobal @peg2, r65
          storeoutargument r65, 0
          call _printPeg, 1
          loadret r66
          loadi 3, r67
          print r67
          loadglobal @peg3, r68
          storeoutargument r68, 0
          call _printPeg, 1
          loadret r69
          loadglobal @numMoves, r70
          print r70
          loadglobal @peg3, r71
          loadi 0, r72
          loadi 0, r73
          comp r72, r71, ccr
          movne 1, r73
          compi 1, r73, ccr
          cbrne cc, L33, L32
   L32:
          loadglobal @peg3, r74
          mov r74, r19
          loadglobal @peg3, r75
          loadAI r75, @plateUnder, r76
          computeglobaladdress peg3, r77
          store r76, r77
          mov r19, r78
          del r78
          loadglobal @peg3, r79
          loadi 0, r80
          loadi 0, r81
          comp r80, r79, ccr
          movne 1, r81
          compi 1, r81, ccr
          cbrne cc, L33, L32
   L33:
          br L34
   L34:
          loadi 0, r82
          storeret r82
          br L26
   L26:
   L29:
          br L34
