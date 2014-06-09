_getIntList:
          new IntList, r19
          mov r19, r17
          read r18
    L2:
          mov r18, r20
          loadi 1, r21
          loadi -1, r22
          mult r22, r21, r22
          loadi 0, r23
          comp r22, r20, ccr
          moveq 1, r23
          compi 1, r23, ccr
          cbrne cc, L4, L3
    L3:
          mov r18, r24
          storeai r24, r17,  @head
          loadi 0, r25
          storeai r25, r17,  @tail
          mov r17, r26
          storeret r26
          br L1
          br L5
    L5:
    L1:
    L4:
          mov r18, r27
          storeai r27, r17,  @head
          call _getIntList, 0
          loadret r28
          storeai r28, r17,  @tail
          mov r17, r29
          storeret r29
          br L1
          br L5
_biggest:
          loadinargument num1, 0, r17
          loadinargument num2, 1, r18
    L7:
          mov r17, r19
          mov r18, r20
          loadi 0, r21
          comp r20, r19, ccr
          movgt 1, r21
          compi 1, r21, ccr
          cbrne cc, L9, L8
    L8:
          mov r17, r22
          storeret r22
          br L6
          br L10
   L10:
    L6:
    L9:
          mov r18, r23
          storeret r23
          br L6
          br L10
_biggestInList:
          loadinargument list, 0, r17
          mov r17, r19
          loadAI r19, @head, r20
          mov r20, r18
          mov r17, r21
          loadAI r21, @tail, r22
          loadi 0, r23
          loadi 0, r24
          comp r23, r22, ccr
          movne 1, r24
          compi 1, r24, ccr
          cbrne cc, L13, L12
   L12:
          mov r18, r25
          mov r17, r26
          loadAI r26, @head, r27
          storeoutargument r25, 0
          storeoutargument r27, 1
          call _biggest, 2
          loadret r28
          mov r28, r18
          mov r17, r29
          loadAI r29, @tail, r30
          mov r30, r17
          mov r17, r31
          loadAI r31, @tail, r32
          loadi 0, r33
          loadi 0, r34
          comp r33, r32, ccr
          movne 1, r34
          compi 1, r34, ccr
          cbrne cc, L13, L12
   L13:
          mov r18, r35
          storeret r35
          br L11
   L11:
 _main:
          call _getIntList, 0
          loadret r18
          mov r18, r17
          mov r17, r19
          storeoutargument r19, 0
          call _biggestInList, 1
          loadret r20
          print r20
          loadi 0, r21
          storeret r21
          br L14
   L14:
