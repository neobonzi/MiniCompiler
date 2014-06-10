_length:
          loadinargument list, 0, r17
    L2:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          compi 1, r20, ccr
          cbrne cc, L4, L3
    L3:
          loadi 0, r21
          storeret r21
          br L1
          br L5
    L5:
          loadi 1, r22
          mov r17, r23
          loadAI r23, @rest, r24
          storeoutargument r24, 0
          call _length, 1
          loadret r25
          add r22, r25, r26
          storeret r26
          br L1
    L1:
    L4:
          br L5
_addToFront:
          loadinargument list, 0, r17
          loadinargument element, 1, r18
    L7:
          mov r17, r20
          loadi 0, r21
          loadi 0, r22
          comp r21, r20, ccr
          moveq 1, r22
          compi 1, r22, ccr
          cbrne cc, L9, L8
    L8:
          new intList, r23
          mov r23, r17
          mov r18, r24
          storeai r24, r17,  @data
          loadi 0, r25
          storeai r25, r17,  @rest
          mov r17, r26
          storeret r26
          br L6
          br L10
   L10:
          new intList, r27
          mov r27, r19
          mov r18, r28
          storeai r28, r19,  @data
          mov r17, r29
          storeai r29, r19,  @rest
          mov r19, r30
          storeret r30
          br L6
    L6:
    L9:
          br L10
_deleteFirst:
          loadinargument list, 0, r17
   L12:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L14, L13
   L13:
          loadi 0, r22
          storeret r22
          br L11
          br L15
   L15:
          mov r17, r23
          mov r23, r18
          mov r17, r24
          loadAI r24, @rest, r25
          mov r25, r17
          mov r18, r26
          del r26
          mov r17, r27
          storeret r27
          br L11
   L11:
   L14:
          br L15
 _main:
          read r19
          storeglobal r19, @intList
          loadi 0, r21
          mov r21, r18
          loadi 0, r22
          mov r22, r17
          loadglobal @intList, r23
          loadi 0, r24
          loadi 0, r25
          comp r24, r23, ccr
          movgt 1, r25
          compi 1, r25, ccr
          cbrne cc, L18, L17
   L17:
          mov r17, r26
          loadglobal @intList, r27
          storeoutargument r26, 0
          storeoutargument r27, 1
          call _addToFront, 2
          loadret r28
          mov r28, r17
          mov r17, r29
          loadAI r29, @data, r30
          print r30
          loadglobal @intList, r31
          loadi 1, r32
          sub r31, r32, r33
          computeglobaladdress intList, r34
          store r33, r34
          loadglobal @intList, r35
          loadi 0, r36
          loadi 0, r37
          comp r36, r35, ccr
          movgt 1, r37
          compi 1, r37, ccr
          cbrne cc, L18, L17
   L18:
          mov r17, r38
          storeoutargument r38, 0
          call _length, 1
          loadret r39
          print r39
          mov r17, r40
          storeoutargument r40, 0
          call _length, 1
          loadret r41
          loadi 0, r42
          loadi 0, r43
          comp r42, r41, ccr
          movgt 1, r43
          compi 1, r43, ccr
          cbrne cc, L20, L19
   L19:
          mov r18, r44
          mov r17, r45
          loadAI r45, @data, r46
          add r44, r46, r47
          mov r47, r18
          mov r17, r48
          storeoutargument r48, 0
          call _length, 1
          loadret r49
          print r49
          mov r17, r50
          storeoutargument r50, 0
          call _deleteFirst, 1
          loadret r51
          mov r51, r17
          mov r17, r52
          storeoutargument r52, 0
          call _length, 1
          loadret r53
          loadi 0, r54
          loadi 0, r55
          comp r54, r53, ccr
          movgt 1, r55
          compi 1, r55, ccr
          cbrne cc, L20, L19
   L20:
          mov r18, r56
          print r56
          loadi 0, r57
          storeret r57
          br L16
   L16:
