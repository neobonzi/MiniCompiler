_tailrecursive:
          loadinargument num, 0, r17
    L2:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          movle 1, r21
          compi 1, r21, ccr
          cbrne cc, L4, L3
    L3:
          br L1
          br L5
    L5:
          new foo, r22
          mov r22, r18
          mov r17, r23
          loadi 1, r24
          sub r23, r24, r25
          storeoutargument r25, 0
          call _tailrecursive, 1
          loadret r26
    L1:
    L4:
          br L5
  _add:
          loadinargument x, 0, r17
          loadinargument y, 1, r18
          mov r17, r19
          mov r18, r20
          add r19, r20, r21
          storeret r21
          br L6
    L6:
_domath:
          loadinargument num, 0, r17
          new foo, r21
          mov r21, r18
          new simple, r22
          storeai r22, r18,  @simp
          new foo, r23
          mov r23, r19
          new simple, r24
          storeai r24, r19,  @simp
          mov r17, r25
          storeai r25, r18,  @bar
          loadi 3, r26
          storeai r26, r19,  @bar
          mov r18, r27
          loadAI r27, @bar, r28
          loadAI r18, @simp, r29
          storeai r28, r29,  @one
          mov r19, r30
          loadAI r30, @bar, r31
          loadAI r19, @simp, r32
          storeai r31, r32,  @one
          mov r17, r33
          loadi 0, r34
          loadi 0, r35
          comp r34, r33, ccr
          movgt 1, r35
          compi 1, r35, ccr
          cbrne cc, L9, L8
    L8:
          mov r18, r36
          loadAI r36, @bar, r37
          mov r19, r38
          loadAI r38, @bar, r39
          mult r37, r39, r40
          mov r40, r20
          mov r20, r41
          mov r18, r42
          loadAI r42, @simp, r43
          loadAI r43, @one, r44
          mult r41, r44, r45
          mov r19, r46
          loadAI r46, @bar, r47
          div r45, r47, r48
          mov r48, r20
          mov r19, r49
          loadAI r49, @simp, r50
          loadAI r50, @one, r51
          mov r18, r52
          loadAI r52, @bar, r53
          storeoutargument r51, 0
          storeoutargument r53, 1
          call _add, 2
          loadret r54
          mov r54, r20
          mov r19, r55
          loadAI r55, @bar, r56
          mov r18, r57
          loadAI r57, @bar, r58
          sub r56, r58, r59
          mov r59, r20
          mov r17, r60
          loadi 1, r61
          sub r60, r61, r62
          mov r62, r17
          mov r17, r63
          loadi 0, r64
          loadi 0, r65
          comp r64, r63, ccr
          movgt 1, r65
          compi 1, r65, ccr
          cbrne cc, L9, L8
    L9:
          mov r18, r66
          del r66
          mov r19, r67
          del r67
    L7:
_objinstantiation:
          loadinargument num, 0, r17
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          movgt 1, r21
          compi 1, r21, ccr
          cbrne cc, L12, L11
   L11:
          new foo, r22
          mov r22, r18
          mov r18, r23
          del r23
          mov r17, r24
          loadi 1, r25
          sub r24, r25, r26
          mov r26, r17
          mov r17, r27
          loadi 0, r28
          loadi 0, r29
          comp r28, r27, ccr
          movgt 1, r29
          compi 1, r29, ccr
          cbrne cc, L12, L11
   L12:
   L10:
_ackermann:
          loadinargument m, 0, r17
          loadinargument n, 1, r18
   L14:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L16, L15
   L15:
          mov r18, r22
          loadi 1, r23
          add r22, r23, r24
          storeret r24
          br L13
          br L17
   L17:
   L18:
          mov r18, r25
          loadi 0, r26
          loadi 0, r27
          comp r26, r25, ccr
          moveq 1, r27
          compi 1, r27, ccr
          cbrne cc, L20, L19
   L19:
          mov r17, r28
          loadi 1, r29
          sub r28, r29, r30
          loadi 1, r31
          storeoutargument r30, 0
          storeoutargument r31, 1
          call _ackermann, 2
          loadret r32
          storeret r32
          br L13
          br L21
   L21:
   L13:
   L20:
          mov r17, r33
          loadi 1, r34
          sub r33, r34, r35
          mov r17, r36
          mov r18, r37
          loadi 1, r38
          sub r37, r38, r39
          storeoutargument r36, 0
          storeoutargument r39, 1
          call _ackermann, 2
          loadret r40
          storeoutargument r35, 0
          storeoutargument r40, 1
          call _ackermann, 2
          loadret r41
          storeret r41
          br L13
          br L21
   L16:
          br L17
 _main:
          read r22
          mov r22, r17
          read r23
          mov r23, r18
          read r24
          mov r24, r19
          read r25
          mov r25, r20
          read r26
          mov r26, r21
          mov r20, r27
          mov r21, r28
          storeoutargument r27, 0
          storeoutargument r28, 1
          call _ackermann, 2
          loadret r29
          print r29
          loadi 0, r30
          storeret r30
          br L22
   L22:
