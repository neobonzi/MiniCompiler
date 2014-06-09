_buildList:
          new node, r25
          mov r25, r19
          new node, r26
          mov r26, r20
          new node, r27
          mov r27, r21
          new node, r28
          mov r28, r22
          new node, r29
          mov r29, r23
          new node, r30
          mov r30, r24
          loadAI r19, @value, r31
          read r31
          loadAI r20, @value, r32
          read r32
          loadAI r21, @value, r33
          read r33
          loadAI r22, @value, r34
          read r34
          loadAI r23, @value, r35
          read r35
          loadAI r24, @value, r36
          read r36
          mov r20, r37
          storeai r37, r19,  @next
          mov r21, r38
          storeai r38, r20,  @next
          mov r22, r39
          storeai r39, r21,  @next
          mov r23, r40
          storeai r40, r22,  @next
          mov r24, r41
          storeai r41, r23,  @next
          loadi 0, r42
          storeai r42, r24,  @next
          mov r19, r43
          storeret r43
          br L1
    L1:
_multiple:
          loadinargument list, 0, r17
          loadi 0, r21
          mov r21, r18
          mov r17, r22
          mov r22, r20
          mov r20, r23
          loadAI r23, @value, r24
          mov r24, r19
          mov r20, r25
          loadAI r25, @next, r26
          mov r26, r20
          mov r18, r27
          loadi 5, r28
          loadi 0, r29
          comp r28, r27, ccr
          movlt 1, r29
          compi 1, r29, ccr
          cbrne cc, L4, L3
    L3:
          mov r19, r30
          mov r20, r31
          loadAI r31, @value, r32
          mult r30, r32, r33
          mov r33, r19
          mov r20, r34
          loadAI r34, @next, r35
          mov r35, r20
          mov r19, r36
          print r36
          mov r18, r37
          loadi 1, r38
          add r37, r38, r39
          mov r39, r18
          mov r18, r40
          loadi 5, r41
          loadi 0, r42
          comp r41, r40, ccr
          movlt 1, r42
          compi 1, r42, ccr
          cbrne cc, L4, L3
    L4:
          mov r19, r43
          storeret r43
          br L2
    L2:
  _add:
          loadinargument list, 0, r17
          loadi 0, r21
          mov r21, r18
          mov r17, r22
          mov r22, r20
          mov r20, r23
          loadAI r23, @value, r24
          mov r24, r19
          mov r20, r25
          loadAI r25, @next, r26
          mov r26, r20
          mov r18, r27
          loadi 5, r28
          loadi 0, r29
          comp r28, r27, ccr
          movlt 1, r29
          compi 1, r29, ccr
          cbrne cc, L7, L6
    L6:
          mov r19, r30
          mov r20, r31
          loadAI r31, @value, r32
          add r30, r32, r33
          mov r33, r19
          mov r20, r34
          loadAI r34, @next, r35
          mov r35, r20
          mov r19, r36
          print r36
          mov r18, r37
          loadi 1, r38
          add r37, r38, r39
          mov r39, r18
          mov r18, r40
          loadi 5, r41
          loadi 0, r42
          comp r41, r40, ccr
          movlt 1, r42
          compi 1, r42, ccr
          cbrne cc, L7, L6
    L7:
          mov r19, r43
          storeret r43
          br L5
    L5:
_recurseList:
          loadinargument list, 0, r17
    L9:
          mov r17, r18
          loadAI r18, @next, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L11, L10
   L10:
          mov r17, r22
          loadAI r22, @value, r23
          storeret r23
          br L8
          br L12
   L12:
    L8:
   L11:
          mov r17, r24
          loadAI r24, @value, r25
          mov r17, r26
          loadAI r26, @next, r27
          storeoutargument r27, 0
          call _recurseList, 1
          loadret r28
          mult r25, r28, r29
          storeret r29
          br L8
          br L12
 _main:
          loadi 0, r23
          mov r23, r22
          loadi 0, r24
          mov r24, r21
          call _buildList, 0
          loadret r25
          mov r25, r17
          mov r17, r26
          storeoutargument r26, 0
          call _multiple, 1
          loadret r27
          mov r27, r18
          mov r17, r28
          storeoutargument r28, 0
          call _add, 1
          loadret r29
          mov r29, r19
          mov r18, r30
          mov r19, r31
          loadi 2, r32
          div r31, r32, r33
          sub r30, r33, r34
          mov r34, r20
          mov r22, r35
          loadi 10, r36
          loadi 0, r37
          comp r36, r35, ccr
          movlt 1, r37
          compi 1, r37, ccr
          cbrne cc, L15, L14
   L14:
          mov r21, r38
          mov r17, r39
          storeoutargument r39, 0
          call _recurseList, 1
          loadret r40
          add r38, r40, r41
          mov r41, r21
          mov r22, r42
          loadi 1, r43
          add r42, r43, r44
          mov r44, r22
          mov r22, r45
          loadi 10, r46
          loadi 0, r47
          comp r46, r45, ccr
          movlt 1, r47
          compi 1, r47, ccr
          cbrne cc, L15, L14
   L15:
          mov r21, r48
          print r48
          mov r21, r49
          loadi 0, r50
          loadi 0, r51
          comp r50, r49, ccr
          movne 1, r51
          compi 1, r51, ccr
          cbrne cc, L17, L16
   L16:
          mov r21, r52
          loadi 1, r53
          sub r52, r53, r54
          mov r54, r21
          mov r21, r55
          loadi 0, r56
          loadi 0, r57
          comp r56, r55, ccr
          movne 1, r57
          compi 1, r57, ccr
          cbrne cc, L17, L16
   L17:
          mov r20, r58
          print r58
          mov r21, r59
          print r59
          loadi 0, r60
          storeret r60
          br L13
   L13:
