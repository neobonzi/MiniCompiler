 _wait:
          loadinargument waitTime, 0, r17
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movgt 1, r20
          compi 1, r20, ccr
          cbrne cc, L2, L1
    L1:
          mov r17, r21
          loadi 1, r22
          sub r21, r22, r23
          mov r23, r17
          mov r17, r24
          loadi 0, r25
          loadi 0, r26
          comp r25, r24, ccr
          movgt 1, r26
          compi 1, r26, ccr
          cbrne cc, L2, L1
    L2:
          loadi 0, r27
          storeret r27
    L3:
          ret true
_power:
          loadinargument base, 0, r17
          loadinargument exponent, 1, r18
          loadi 1, r20
          mov r20, r19
          mov r18, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          movgt 1, r23
          compi 1, r23, ccr
          cbrne cc, L5, L4
    L4:
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
          cbrne cc, L5, L4
    L5:
          mov r19, r33
          storeret r33
    L6:
          ret true
_recursiveDecimalSum:
          loadinargument binaryNum, 0, r17
          loadinargument decimalSum, 1, r18
          loadinargument recursiveDepth, 2, r19
    L7:
          mov r17, r23
          loadi 0, r24
          loadi 0, r25
          comp r24, r23, ccr
          movgt 1, r25
          compi 1, r25, ccr
          cbrne cc, L9, L8
    L8:
          loadi 2, r26
          mov r26, r21
          mov r17, r27
          loadi 10, r28
          div r27, r28, r29
          mov r29, r20
          mov r20, r30
          loadi 10, r31
          mult r30, r31, r32
          mov r32, r20
          mov r17, r33
          mov r20, r34
          sub r33, r34, r35
          mov r35, r20
   L10:
          mov r20, r36
          loadi 1, r37
          loadi 0, r38
          comp r37, r36, ccr
          moveq 1, r38
          compi 1, r38, ccr
          cbrne cc, L12, L11
   L11:
          mov r18, r39
          mov r21, r40
          mov r19, r41
          storeoutargument r40, 0
          storeoutargument r41, 1
          call _power, 2
          loadret r42
          add r39, r42, r43
          mov r43, r18
          br L13
   L13:
          mov r17, r44
          loadi 10, r45
          div r44, r45, r46
          mov r18, r47
          mov r19, r48
          loadi 1, r49
          add r48, r49, r50
          storeoutargument r46, 0
          storeoutargument r47, 1
          storeoutargument r50, 2
          call _recursiveDecimalSum, 3
          loadret r51
          storeret r51
          br L14
   L14:
          mov r18, r52
          storeret r52
   L15:
          ret true
   L12:
          br L13
    L9:
          br L14
_convertToDecimal:
          loadinargument binaryNum, 0, r17
          loadi 0, r20
          mov r20, r18
          loadi 0, r21
          mov r21, r19
          mov r17, r22
          mov r19, r23
          mov r18, r24
          storeoutargument r22, 0
          storeoutargument r23, 1
          storeoutargument r24, 2
          call _recursiveDecimalSum, 3
          loadret r25
          storeret r25
   L16:
          ret true
 _main:
          read r17
          mov r17, r19
          storeoutargument r19, 0
          call _convertToDecimal, 1
          loadret r20
          mov r20, r17
          mov r17, r21
          mov r17, r22
          mult r21, r22, r23
          mov r23, r18
          mov r18, r24
          loadi 0, r25
          loadi 0, r26
          comp r25, r24, ccr
          movgt 1, r26
          compi 1, r26, ccr
          cbrne cc, L18, L17
   L17:
          mov r18, r27
          storeoutargument r27, 0
          call _wait, 1
          loadret r28
          mov r18, r29
          loadi 1, r30
          sub r29, r30, r31
          mov r31, r18
          mov r18, r32
          loadi 0, r33
          loadi 0, r34
          comp r33, r32, ccr
          movgt 1, r34
          compi 1, r34, ccr
          cbrne cc, L18, L17
   L18:
          mov r17, r35
          print r35
          loadi 0, r36
          storeret r36
   L19:
          ret true
