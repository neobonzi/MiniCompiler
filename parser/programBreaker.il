 _fun2:
          loadinargument x, 0, r17
          loadinargument y, 1, r18
    L2:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L4, L3
    L3:
          mov r18, r22
          storeret r22
          br L1
          br L5
    L5:
    L1:
    L4:
          mov r17, r23
          loadi 1, r24
          sub r23, r24, r25
          mov r18, r26
          storeoutargument r25, 0
          storeoutargument r26, 1
          call _fun2, 2
          loadret r27
          storeret r27
          br L1
          br L5
 _fun1:
          loadinargument x, 0, r17
          loadinargument y, 1, r18
          loadinargument z, 2, r19
          loadi 5, r21
          loadi 6, r22
          add r21, r22, r23
          mov r17, r24
          loadi 2, r25
          mult r24, r25, r26
          sub r23, r26, r27
          loadi 4, r28
          mov r18, r29
          div r28, r29, r30
          add r27, r30, r31
          mov r19, r32
          add r31, r32, r33
          mov r33, r20
    L7:
          mov r20, r34
          mov r18, r35
          loadi 0, r36
          comp r35, r34, ccr
          movgt 1, r36
          compi 1, r36, ccr
          cbrne cc, L9, L8
    L8:
          mov r20, r37
          mov r17, r38
          storeoutargument r37, 0
          storeoutargument r38, 1
          call _fun2, 2
          loadret r39
          storeret r39
          br L6
          br L14
   L14:
          mov r20, r50
          storeret r50
          br L6
    L6:
    L9:
   L10:
          loadi 5, r40
          loadi 6, r41
          loadi 0, r42
          comp r41, r40, ccr
          movlt 1, r42
          mov r20, r43
          mov r18, r44
          loadi 0, r45
          comp r44, r43, ccr
          movle 1, r45
          and r42, r45, r46
          compi 1, r46, ccr
          cbrne cc, L12, L11
   L11:
          mov r20, r47
          mov r18, r48
          storeoutargument r47, 0
          storeoutargument r48, 1
          call _fun2, 2
          loadret r49
          storeret r49
          br L6
          br L13
   L13:
          br L14
   L12:
          br L13
 _main:
          loadi 0, r18
          mov r18, r17
          read r17
          mov r17, r19
          loadi 10000, r20
          loadi 0, r21
          comp r20, r19, ccr
          movlt 1, r21
          compi 1, r21, ccr
          cbrne cc, L17, L16
   L16:
          loadi 3, r22
          mov r17, r23
          loadi 5, r24
          storeoutargument r22, 0
          storeoutargument r23, 1
          storeoutargument r24, 2
          call _fun1, 3
          loadret r25
          print r25
          mov r17, r26
          loadi 1, r27
          add r26, r27, r28
          mov r28, r17
          mov r17, r29
          loadi 10000, r30
          loadi 0, r31
          comp r30, r29, ccr
          movlt 1, r31
          compi 1, r31, ccr
          cbrne cc, L17, L16
   L17:
          loadi 0, r32
          storeret r32
          br L15
   L15:
