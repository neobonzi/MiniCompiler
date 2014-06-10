_calcPower:
          loadinargument base, 0, r17
          loadinargument exp, 1, r18
          loadi 1, r20
          mov r20, r19
          mov r18, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          movgt 1, r23
          compi 1, r23, ccr
          cbrne cc, L3, L2
    L2:
          mov r19, r24
          mov r17, r25
          mult r24, r25, r26
          mov r26, r19
          mov r18, r27
          loadi 1, r28
          sub r27, r28, r29
          mov r29, r18
          mov r18, r30
          loadi 0, r31
          loadi 0, r32
          comp r31, r30, ccr
          movgt 1, r32
          compi 1, r32, ccr
          cbrne cc, L3, L2
    L3:
          mov r19, r33
          storeret r33
          br L1
    L1:
 _main:
          new Power, r22
          mov r22, r17
          read r23
          mov r23, r18
          mov r18, r24
          storeai r24, r17,  @base
          read r25
          mov r25, r18
    L5:
          mov r18, r26
          loadi 0, r27
          loadi 0, r28
          comp r27, r26, ccr
          movlt 1, r28
          compi 1, r28, ccr
          cbrne cc, L7, L6
    L6:
          loadi 1, r29
          loadi -1, r30
          mult r30, r29, r30
          storeret r30
          br L4
          br L8
    L8:
          loadi 1, r31
          storeret r31
          br L4
    L4:
    L7:
          br L8
