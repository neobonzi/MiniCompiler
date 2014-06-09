_computeFib:
          loadinargument input, 0, r17
    L2:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          compi 1, r20, ccr
          cbrne cc, L4, L3
    L3:
          mov r17, r21
          print r21
          loadi 0, r22
          storeret r22
          br L1
          br L9
    L9:
    L1:
    L4:
    L5:
          mov r17, r23
          loadi 2, r24
          loadi 0, r25
          comp r24, r23, ccr
          movle 1, r25
          compi 1, r25, ccr
          cbrne cc, L7, L6
    L6:
          loadi 1, r26
          storeret r26
          br L1
          br L8
    L8:
          br L9
    L7:
          mov r17, r27
          loadi 1, r28
          sub r27, r28, r29
          storeoutargument r29, 0
          call _computeFib, 1
          loadret r30
          mov r17, r31
          loadi 2, r32
          sub r31, r32, r33
          storeoutargument r33, 0
          call _computeFib, 1
          loadret r34
          add r30, r34, r35
          storeret r35
          br L1
          br L8
 _main:
          read r17
          mov r17, r18
          storeoutargument r18, 0
          call _computeFib, 1
          loadret r19
          print r19
          loadi 0, r20
          storeret r20
          br L10
   L10:
