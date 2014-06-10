_compare:
          loadinargument a, 0, r17
          loadinargument b, 1, r18
          mov r17, r19
          loadAI r19, @val, r20
          mov r18, r21
          loadAI r21, @val, r22
          sub r20, r22, r23
          storeret r23
          br L1
    L1:
_deathSort:
          loadinargument head, 0, r17
          loadi 1, r21
          mov r21, r18
          mov r18, r22
          loadi 1, r23
          loadi 0, r24
          comp r23, r22, ccr
          moveq 1, r24
          compi 1, r24, ccr
          cbrne cc, L4, L3
    L3:
          loadi 0, r25
          mov r25, r18
          mov r17, r26
          mov r26, r20
          mov r20, r27
          loadAI r27, @next, r28
          mov r17, r29
          loadi 0, r30
          comp r29, r28, ccr
          movne 1, r30
          compi 1, r30, ccr
          cbrne cc, L6, L5
    L5:
    L7:
          mov r20, r31
          mov r20, r32
          loadAI r32, @next, r33
          storeoutargument r31, 0
          storeoutargument r33, 1
          call _compare, 2
          loadret r34
          loadi 0, r35
          loadi 0, r36
          comp r35, r34, ccr
          movgt 1, r36
          compi 1, r36, ccr
          cbrne cc, L9, L8
    L8:
          mov r20, r37
          loadAI r37, @val, r38
          mov r38, r19
          mov r20, r39
          loadAI r39, @next, r40
          loadAI r40, @val, r41
          storeai r41, r20,  @val
          mov r19, r42
          loadAI r20, @next, r43
          storeai r42, r43,  @val
          loadi 1, r44
          mov r44, r18
          br L10
   L10:
          mov r20, r45
          loadAI r45, @next, r46
          mov r46, r20
          mov r20, r47
          loadAI r47, @next, r48
          mov r17, r49
          loadi 0, r50
          comp r49, r48, ccr
          movne 1, r50
          compi 1, r50, ccr
          cbrne cc, L6, L5
    L9:
          br L10
    L6:
          mov r18, r51
          loadi 1, r52
          loadi 0, r53
          comp r52, r51, ccr
          moveq 1, r53
          compi 1, r53, ccr
          cbrne cc, L4, L3
    L4:
    L2:
_printEVILList:
          loadinargument head, 0, r17
          mov r17, r20
          loadAI r20, @next, r21
          mov r21, r18
          mov r17, r22
          loadAI r22, @val, r23
          print r23
          mov r17, r24
          del r24
          mov r18, r25
          mov r17, r26
          loadi 0, r27
          comp r26, r25, ccr
          movne 1, r27
          compi 1, r27, ccr
          cbrne cc, L13, L12
   L12:
          mov r18, r28
          mov r28, r19
          mov r18, r29
          loadAI r29, @val, r30
          print r30
          mov r18, r31
          loadAI r31, @next, r32
          mov r32, r18
          mov r19, r33
          del r33
          mov r18, r34
          mov r17, r35
          loadi 0, r36
          comp r35, r34, ccr
          movne 1, r36
          compi 1, r36, ccr
          cbrne cc, L13, L12
   L13:
   L11:
 _main:
          loadi 666, r22
          computeglobaladdress swapped, r23
          store r22, r23
          read r24
          mov r24, r17
   L15:
          mov r17, r25
          loadi 0, r26
          loadi 0, r27
          comp r26, r25, ccr
          movle 1, r27
          compi 1, r27, ccr
          cbrne cc, L17, L16
   L16:
          loadi 1, r28
          loadi -1, r29
          mult r29, r28, r29
          print r29
          loadi 1, r30
          loadi -1, r31
          mult r31, r30, r31
          storeret r31
          br L14
          br L18
   L18:
          mov r17, r32
          loadi 1000, r33
          mult r32, r33, r34
          mov r34, r17
          mov r17, r35
          mov r35, r18
          new Node, r36
          mov r36, r20
          mov r18, r37
          storeai r37, r20,  @val
          mov r20, r38
          storeai r38, r20,  @prev
          mov r20, r39
          storeai r39, r20,  @next
          mov r18, r40
          loadi 1, r41
          sub r40, r41, r42
          mov r42, r18
          mov r20, r43
          mov r43, r21
          mov r18, r44
          loadi 0, r45
          loadi 0, r46
          comp r45, r44, ccr
          movgt 1, r46
          compi 1, r46, ccr
          cbrne cc, L20, L19
   L19:
          new Node, r47
          mov r47, r19
          mov r18, r48
          storeai r48, r19,  @val
          mov r21, r49
          storeai r49, r19,  @prev
          mov r20, r50
          storeai r50, r19,  @next
          mov r19, r51
          storeai r51, r21,  @next
          mov r19, r52
          mov r52, r21
          mov r18, r53
          loadi 1, r54
          sub r53, r54, r55
          mov r55, r18
          mov r18, r56
          loadi 0, r57
          loadi 0, r58
          comp r57, r56, ccr
          movgt 1, r58
          compi 1, r58, ccr
          cbrne cc, L20, L19
   L20:
          mov r20, r59
          storeoutargument r59, 0
          call _deathSort, 1
          loadret r60
          mov r20, r61
          storeoutargument r61, 0
          call _printEVILList, 1
          loadret r62
          loadi 0, r63
          storeret r63
          br L14
   L14:
   L17:
          br L18
