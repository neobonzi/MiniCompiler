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
          loadi 0, r21
          storeret r21
          br L1
          br L9
    L9:
    L1:
    L4:
    L5:
          mov r17, r22
          loadi 2, r23
          loadi 0, r24
          comp r23, r22, ccr
          movle 1, r24
          compi 1, r24, ccr
          cbrne cc, L7, L6
    L6:
          loadi 1, r25
          storeret r25
          br L1
          br L8
    L8:
          br L9
    L7:
          mov r17, r26
          loadi 1, r27
          sub r26, r27, r28
          storeoutargument r28, 0
          call _computeFib, 1
          loadret r29
          mov r17, r30
          loadi 2, r31
          sub r30, r31, r32
          storeoutargument r32, 0
          call _computeFib, 1
          loadret r33
          add r29, r33, r34
          storeret r34
          br L1
          br L8
 _main:
          read r18
          mov r18, r17
          mov r17, r19
          storeoutargument r19, 0
          call _computeFib, 1
          loadret r20
          print r20
          loadi 0, r21
          storeret r21
          br L10
   L10:
