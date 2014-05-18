    _g:
          loadinargument i, 0, r17
          loadinargument j, 1, r18
          loadi 3, r22
          storeret r22
    L1:
          ret true
  _foo:
          loadinargument n, 0, r17
    L2:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r18, r19, ccr
          loadi 1, r20
          movle r20, r21
          compi r21, 1, ccr
          cbrne cc, L4, L3
    L3:
          loadi 1, r22
          storeret r22
          br L5
    L5:
    L6:
          ret true
    L4:
          mov r17, r23
          mov r17, r24
          loadi 1, r25
          sub r24, r25, r26
          storeoutargument r26, 0
          call _foo, 1
          loadret r27
          mult r23, r27, r28
          storeret r28
          br L5
    _f:
          loadinargument i, 0, r17
          loadinargument j, 1, r18
          loadi 7, r22
          loadglobal @b, r23
          loadAI r23, @a, r24
          loadAI r24, @a, r25
          loadAI r25, @a, r26
          storeai r22, r26,  @i
          computeglobaladdress b, r27
          loadAI r27, @a, r28
          loadAI r28, @a, r29
          loadAI r29, @a, r30
          loadAI r30, @a, r31
          storeret r31
    L7:
          ret true
  _bar:
          loadinargument j, 0, r17
          loadinargument i, 1, r18
    L8:
          ret true
 _main:
    L9:
          loadi 2, r23
          mov r23, r18
   L10:
          mov r18, r24
          loadi 1, r25
          loadi 0, r26
          storeoutargument r25, 0
          storeoutargument r26, 1
          call _g, 2
          loadret r27
          loadi 0, r28
          comp r24, r27, ccr
          loadi 1, r28
          movlt r28, r29
          cbrne cc, L12, L11
   L11:
          loadi 1, r30
          print r30
          br L13
   L13:
   L14:
          mov r18, r31
          loadi 1, r32
          loadi 0, r33
          storeoutargument r32, 0
          storeoutargument r33, 1
          call _g, 2
          loadret r34
          loadi 0, r35
          comp r31, r34, ccr
          loadi 1, r35
          movgt r35, r36
          compi r36, 1, ccr
          cbrne cc, L16, L15
   L15:
          loadi 1, r37
          print r37
          br L17
   L17:
          loadi 1, r39
          compi r39, 1, ccr
          cbrne cc, L19, L18
   L18:
          loadi 7, r40
          print r40
          loadi 1, r41
          compi r41, 1, ccr
          cbrne cc, L19, L18
   L19:
          loadi 1, r42
          new B, r43
          storeoutargument r42, 0
          storeoutargument r43, 1
          call _g, 2
          loadret r44
          new B, r45
          storeoutargument r44, 0
          storeoutargument r45, 1
          call _f, 2
          loadret r46
          loadi 1, r47
          print r47
          new B, r48
          loadi 1, r49
          new B, r50
          storeoutargument r49, 0
          storeoutargument r50, 1
          call _g, 2
          loadret r51
          storeoutargument r48, 0
          storeoutargument r51, 1
          call _bar, 2
          loadret r52
          loadi 2, r53
          print r53
          loadi 1, r54
          new B, r55
          storeoutargument r54, 0
          storeoutargument r55, 1
          call _g, 2
          loadret r56
          new B, r57
          storeoutargument r56, 0
          storeoutargument r57, 1
          call _f, 2
          loadret r58
          loadAI r58, @i, r59
          print r59
          loadi 0, r60
          storeret r60
   L20:
          ret true
   L16:
          loadi 3, r38
          print r38
          br L17
