  _mod:
          loadinargument a, 0, r17
          loadinargument b, 1, r18
          mov r17, r19
          mov r17, r20
          mov r18, r21
          div r20, r21, r22
          mov r18, r23
          mult r22, r23, r24
          sub r19, r24, r25
          storeret r25
          br L1
    L1:
_hailstone:
          loadinargument n, 0, r17
          loadi 1, r18
          compi 1, r18, ccr
          cbrne cc, L4, L3
    L3:
          mov r17, r19
          print r19
    L5:
          mov r17, r20
          loadi 2, r21
          storeoutargument r20, 0
          storeoutargument r21, 1
          call _mod, 2
          loadret r22
          loadi 1, r23
          loadi 0, r24
          comp r23, r22, ccr
          moveq 1, r24
          compi 1, r24, ccr
          cbrne cc, L7, L6
    L6:
          loadi 3, r25
          mov r17, r26
          mult r25, r26, r27
          loadi 1, r28
          add r27, r28, r29
          mov r29, r17
          br L8
    L8:
    L9:
          mov r17, r33
          loadi 1, r34
          loadi 0, r35
          comp r34, r33, ccr
          movle 1, r35
          compi 1, r35, ccr
          cbrne cc, L11, L10
   L10:
          mov r17, r36
          print r36
          br L2
          br L12
   L12:
          loadi 1, r37
          compi 1, r37, ccr
          cbrne cc, L4, L3
   L11:
          br L12
    L7:
          mov r17, r30
          loadi 2, r31
          div r30, r31, r32
          mov r32, r17
          br L8
    L4:
    L2:
 _main:
          read r18
          mov r18, r17
          mov r17, r19
          storeoutargument r19, 0
          call _hailstone, 1
          loadret r20
          loadi 0, r21
          storeret r21
          br L13
   L13:
