_concatLists:
          loadinargument first, 0, r17
          loadinargument second, 1, r18
          mov r17, r20
          mov r20, r19
    L2:
          mov r17, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          moveq 1, r23
          compi 1, r23, ccr
          cbrne cc, L4, L3
    L3:
          mov r18, r24
          storeret r24
          br L1
          br L5
    L5:
          mov r19, r25
          loadAI r25, @next, r26
          loadi 0, r27
          loadi 0, r28
          comp r27, r26, ccr
          movne 1, r28
          compi 1, r28, ccr
          cbrne cc, L7, L6
    L6:
          mov r19, r29
          loadAI r29, @next, r30
          mov r30, r19
          mov r19, r31
          loadAI r31, @next, r32
          loadi 0, r33
          loadi 0, r34
          comp r33, r32, ccr
          movne 1, r34
          compi 1, r34, ccr
          cbrne cc, L7, L6
    L7:
          mov r18, r35
          storeai r35, r19,  @next
          mov r17, r36
          storeret r36
          br L1
    L1:
    L4:
          br L5
  _add:
          loadinargument list, 0, r17
          loadinargument toAdd, 1, r18
          new node, r20
          mov r20, r19
          mov r18, r21
          storeai r21, r19,  @data
          mov r17, r22
          storeai r22, r19,  @next
          mov r19, r23
          storeret r23
          br L8
    L8:
 _size:
          loadinargument list, 0, r17
   L10:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          compi 1, r20, ccr
          cbrne cc, L12, L11
   L11:
          loadi 0, r21
          storeret r21
          br L9
          br L13
   L13:
          loadi 1, r22
          mov r17, r23
          loadAI r23, @next, r24
          storeoutargument r24, 0
          call _size, 1
          loadret r25
          add r22, r25, r26
          storeret r26
          br L9
    L9:
   L12:
          br L13
  _get:
          loadinargument list, 0, r17
          loadinargument index, 1, r18
   L15:
          mov r18, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          moveq 1, r21
          compi 1, r21, ccr
          cbrne cc, L17, L16
   L16:
          mov r17, r22
          loadAI r22, @data, r23
          storeret r23
          br L14
          br L18
   L18:
          mov r17, r24
          loadAI r24, @next, r25
          mov r18, r26
          loadi 1, r27
          sub r26, r27, r28
          storeoutargument r25, 0
          storeoutargument r28, 1
          call _get, 2
          loadret r29
          storeret r29
          br L14
   L14:
   L17:
          br L18
  _pop:
          loadinargument list, 0, r17
          mov r17, r18
          loadAI r18, @next, r19
          mov r19, r17
          mov r17, r20
          storeret r20
          br L19
   L19:
_printList:
          loadinargument list, 0, r17
   L21:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movne 1, r20
          compi 1, r20, ccr
          cbrne cc, L23, L22
   L22:
          mov r17, r21
          loadAI r21, @data, r22
          print r22
          mov r17, r23
          loadAI r23, @next, r24
          storeoutargument r24, 0
          call _printList, 1
          loadret r25
          br L24
   L24:
   L20:
   L23:
          br L24
_treeprint:
          loadinargument root, 0, r17
   L26:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movne 1, r20
          compi 1, r20, ccr
          cbrne cc, L28, L27
   L27:
          mov r17, r21
          loadAI r21, @left, r22
          storeoutargument r22, 0
          call _treeprint, 1
          loadret r23
          mov r17, r24
          loadAI r24, @data, r25
          print r25
          mov r17, r26
          loadAI r26, @right, r27
          storeoutargument r27, 0
          call _treeprint, 1
          loadret r28
          br L29
   L29:
   L25:
   L28:
          br L29
_freeList:
          loadinargument list, 0, r17
   L31:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          movne 1, r20
          compi 1, r20, ccr
          cbrne cc, L33, L32
   L32:
          mov r17, r21
          loadAI r21, @next, r22
          storeoutargument r22, 0
          call _freeList, 1
          loadret r23
          mov r17, r24
          del r24
          br L34
   L34:
   L30:
   L33:
          br L34
_freeTree:
          loadinargument root, 0, r17
   L36:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          loadi 1, r21
          xor r21, r20, r22
          compi 1, r22, ccr
          cbrne cc, L38, L37
   L37:
          mov r17, r23
          loadAI r23, @left, r24
          storeoutargument r24, 0
          call _freeTree, 1
          loadret r25
          mov r17, r26
          loadAI r26, @right, r27
          storeoutargument r27, 0
          call _freeTree, 1
          loadret r28
          mov r17, r29
          del r29
          br L39
   L39:
   L35:
   L38:
          br L39
_postOrder:
          loadinargument root, 0, r17
   L41:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          movne 1, r21
          compi 1, r21, ccr
          cbrne cc, L43, L42
   L42:
          new node, r22
          mov r22, r18
          mov r17, r23
          loadAI r23, @data, r24
          storeai r24, r18,  @data
          loadi 0, r25
          storeai r25, r18,  @next
          mov r17, r26
          loadAI r26, @left, r27
          storeoutargument r27, 0
          call _postOrder, 1
          loadret r28
          mov r17, r29
          loadAI r29, @right, r30
          storeoutargument r30, 0
          call _postOrder, 1
          loadret r31
          storeoutargument r28, 0
          storeoutargument r31, 1
          call _concatLists, 2
          loadret r32
          mov r18, r33
          storeoutargument r32, 0
          storeoutargument r33, 1
          call _concatLists, 2
          loadret r34
          storeret r34
          br L40
          br L44
   L44:
          loadi 0, r35
          storeret r35
          br L40
   L40:
   L43:
          br L44
_treeadd:
          loadinargument root, 0, r17
          loadinargument toAdd, 1, r18
   L46:
          mov r17, r20
          loadi 0, r21
          loadi 0, r22
          comp r21, r20, ccr
          moveq 1, r22
          compi 1, r22, ccr
          cbrne cc, L48, L47
   L47:
          new tnode, r23
          mov r23, r19
          mov r18, r24
          storeai r24, r19,  @data
          loadi 0, r25
          storeai r25, r19,  @left
          loadi 0, r26
          storeai r26, r19,  @right
          mov r19, r27
          storeret r27
          br L45
          br L49
   L49:
   L50:
          mov r18, r28
          mov r17, r29
          loadAI r29, @data, r30
          loadi 0, r31
          comp r30, r28, ccr
          movlt 1, r31
          compi 1, r31, ccr
          cbrne cc, L52, L51
   L51:
          mov r17, r32
          loadAI r32, @left, r33
          mov r18, r34
          storeoutargument r33, 0
          storeoutargument r34, 1
          call _treeadd, 2
          loadret r35
          storeai r35, r17,  @left
          br L53
   L53:
          mov r17, r40
          storeret r40
          br L45
   L45:
   L52:
          mov r17, r36
          loadAI r36, @right, r37
          mov r18, r38
          storeoutargument r37, 0
          storeoutargument r38, 1
          call _treeadd, 2
          loadret r39
          storeai r39, r17,  @right
          br L53
   L48:
          br L49
_quickSort:
          loadinargument list, 0, r17
          loadi 0, r23
          mov r23, r20
          loadi 0, r24
          mov r24, r21
   L55:
          mov r17, r25
          storeoutargument r25, 0
          call _size, 1
          loadret r26
          loadi 1, r27
          loadi 0, r28
          comp r27, r26, ccr
          movle 1, r28
          compi 1, r28, ccr
          cbrne cc, L57, L56
   L56:
          mov r17, r29
          storeret r29
          br L54
          br L58
   L58:
          mov r17, r30
          loadi 0, r31
          storeoutargument r30, 0
          storeoutargument r31, 1
          call _get, 2
          loadret r32
          mov r17, r33
          mov r17, r34
          storeoutargument r34, 0
          call _size, 1
          loadret r35
          loadi 1, r36
          sub r35, r36, r37
          storeoutargument r33, 0
          storeoutargument r37, 1
          call _get, 2
          loadret r38
          add r32, r38, r39
          loadi 2, r40
          div r39, r40, r41
          mov r41, r18
          mov r17, r42
          mov r42, r22
          loadi 0, r43
          mov r43, r19
          mov r22, r44
          loadi 0, r45
          loadi 0, r46
          comp r45, r44, ccr
          movne 1, r46
          compi 1, r46, ccr
          cbrne cc, L60, L59
   L59:
   L61:
          mov r17, r47
          mov r19, r48
          storeoutargument r47, 0
          storeoutargument r48, 1
          call _get, 2
          loadret r49
          mov r18, r50
          loadi 0, r51
          comp r50, r49, ccr
          movgt 1, r51
          compi 1, r51, ccr
          cbrne cc, L63, L62
   L62:
          mov r21, r52
          mov r17, r53
          mov r19, r54
          storeoutargument r53, 0
          storeoutargument r54, 1
          call _get, 2
          loadret r55
          storeoutargument r52, 0
          storeoutargument r55, 1
          call _add, 2
          loadret r56
          mov r56, r21
          br L64
   L64:
          mov r22, r62
          loadAI r62, @next, r63
          mov r63, r22
          mov r19, r64
          loadi 1, r65
          add r64, r65, r66
          mov r66, r19
          mov r22, r67
          loadi 0, r68
          loadi 0, r69
          comp r68, r67, ccr
          movne 1, r69
          compi 1, r69, ccr
          cbrne cc, L60, L59
   L63:
          mov r20, r57
          mov r17, r58
          mov r19, r59
          storeoutargument r58, 0
          storeoutargument r59, 1
          call _get, 2
          loadret r60
          storeoutargument r57, 0
          storeoutargument r60, 1
          call _add, 2
          loadret r61
          mov r61, r20
          br L64
   L60:
          mov r17, r70
          storeoutargument r70, 0
          call _freeList, 1
          loadret r71
          mov r20, r72
          storeoutargument r72, 0
          call _quickSort, 1
          loadret r73
          mov r21, r74
          storeoutargument r74, 0
          call _quickSort, 1
          loadret r75
          storeoutargument r73, 0
          storeoutargument r75, 1
          call _concatLists, 2
          loadret r76
          storeret r76
          br L54
   L54:
   L57:
          br L58
_quickSortMain:
          loadinargument list, 0, r17
          mov r17, r18
          storeoutargument r18, 0
          call _printList, 1
          loadret r19
          loadi 999, r20
          loadi -1, r21
          mult r21, r20, r21
          print r21
          mov r17, r22
          storeoutargument r22, 0
          call _printList, 1
          loadret r23
          loadi 999, r24
          loadi -1, r25
          mult r25, r24, r25
          print r25
          mov r17, r26
          storeoutargument r26, 0
          call _printList, 1
          loadret r27
          loadi 999, r28
          loadi -1, r29
          mult r29, r28, r29
          print r29
          loadi 0, r30
          storeret r30
          br L65
   L65:
_treesearch:
          loadinargument root, 0, r17
          loadinargument target, 1, r18
          loadi 1, r19
          loadi -1, r20
          mult r20, r19, r20
          print r20
   L67:
          mov r17, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          movne 1, r23
          compi 1, r23, ccr
          cbrne cc, L69, L68
   L68:
   L70:
          mov r17, r24
          loadAI r24, @data, r25
          mov r18, r26
          loadi 0, r27
          comp r26, r25, ccr
          moveq 1, r27
          compi 1, r27, ccr
          cbrne cc, L72, L71
   L71:
          loadi 1, r28
          storeret r28
          br L66
          br L73
   L73:
   L74:
          mov r17, r29
          loadAI r29, @left, r30
          mov r18, r31
          storeoutargument r30, 0
          storeoutargument r31, 1
          call _treesearch, 2
          loadret r32
          loadi 1, r33
          loadi 0, r34
          comp r33, r32, ccr
          moveq 1, r34
          compi 1, r34, ccr
          cbrne cc, L76, L75
   L75:
          loadi 1, r35
          storeret r35
          br L66
          br L77
   L77:
   L78:
          mov r17, r36
          loadAI r36, @right, r37
          mov r18, r38
          storeoutargument r37, 0
          storeoutargument r38, 1
          call _treesearch, 2
          loadret r39
          loadi 1, r40
          loadi 0, r41
          comp r40, r39, ccr
          moveq 1, r41
          compi 1, r41, ccr
          cbrne cc, L80, L79
   L79:
          loadi 1, r42
          storeret r42
          br L66
          br L81
   L81:
          br L82
   L82:
          loadi 0, r44
          storeret r44
          br L66
   L66:
   L80:
          loadi 0, r43
          storeret r43
          br L66
          br L81
   L76:
          br L77
   L72:
          br L73
   L69:
          br L82
_inOrder:
          loadinargument root, 0, r17
   L84:
          mov r17, r19
          loadi 0, r20
          loadi 0, r21
          comp r20, r19, ccr
          movne 1, r21
          compi 1, r21, ccr
          cbrne cc, L86, L85
   L85:
          new node, r22
          mov r22, r18
          mov r17, r23
          loadAI r23, @data, r24
          storeai r24, r18,  @data
          loadi 0, r25
          storeai r25, r18,  @next
          mov r17, r26
          loadAI r26, @left, r27
          storeoutargument r27, 0
          call _inOrder, 1
          loadret r28
          mov r18, r29
          mov r17, r30
          loadAI r30, @right, r31
          storeoutargument r31, 0
          call _inOrder, 1
          loadret r32
          storeoutargument r29, 0
          storeoutargument r32, 1
          call _concatLists, 2
          loadret r33
          storeoutargument r28, 0
          storeoutargument r33, 1
          call _concatLists, 2
          loadret r34
          storeret r34
          br L83
          br L87
   L87:
   L83:
   L86:
          loadi 0, r35
          storeret r35
          br L83
          br L87
_bintreesearch:
          loadinargument root, 0, r17
          loadinargument target, 1, r18
          loadi 1, r19
          loadi -1, r20
          mult r20, r19, r20
          print r20
   L89:
          mov r17, r21
          loadi 0, r22
          loadi 0, r23
          comp r22, r21, ccr
          movne 1, r23
          compi 1, r23, ccr
          cbrne cc, L91, L90
   L90:
   L92:
          mov r17, r24
          loadAI r24, @data, r25
          mov r18, r26
          loadi 0, r27
          comp r26, r25, ccr
          moveq 1, r27
          compi 1, r27, ccr
          cbrne cc, L94, L93
   L93:
          loadi 1, r28
          storeret r28
          br L88
          br L95
   L95:
   L96:
          mov r18, r29
          mov r17, r30
          loadAI r30, @data, r31
          loadi 0, r32
          comp r31, r29, ccr
          movlt 1, r32
          compi 1, r32, ccr
          cbrne cc, L98, L97
   L97:
          mov r17, r33
          loadAI r33, @left, r34
          mov r18, r35
          storeoutargument r34, 0
          storeoutargument r35, 1
          call _bintreesearch, 2
          loadret r36
          storeret r36
          br L88
          br L99
   L99:
          br L100
  L100:
          loadi 0, r41
          storeret r41
          br L88
   L88:
   L98:
          mov r17, r37
          loadAI r37, @right, r38
          mov r18, r39
          storeoutargument r38, 0
          storeoutargument r39, 1
          call _bintreesearch, 2
          loadret r40
          storeret r40
          br L88
          br L99
   L94:
          br L95
   L91:
          br L100
_buildTree:
          loadinargument list, 0, r17
          loadi 0, r20
          mov r20, r19
          loadi 0, r21
          mov r21, r18
          mov r18, r22
          mov r17, r23
          storeoutargument r23, 0
          call _size, 1
          loadret r24
          loadi 0, r25
          comp r24, r22, ccr
          movlt 1, r25
          compi 1, r25, ccr
          cbrne cc, L103, L102
  L102:
          mov r19, r26
          mov r17, r27
          mov r18, r28
          storeoutargument r27, 0
          storeoutargument r28, 1
          call _get, 2
          loadret r29
          storeoutargument r26, 0
          storeoutargument r29, 1
          call _treeadd, 2
          loadret r30
          mov r30, r19
          mov r18, r31
          loadi 1, r32
          add r31, r32, r33
          mov r33, r18
          mov r18, r34
          mov r17, r35
          storeoutargument r35, 0
          call _size, 1
          loadret r36
          loadi 0, r37
          comp r36, r34, ccr
          movlt 1, r37
          compi 1, r37, ccr
          cbrne cc, L103, L102
  L103:
          mov r19, r38
          storeret r38
          br L101
  L101:
_treeMain:
          loadinargument list, 0, r17
          mov r17, r21
          storeoutargument r21, 0
          call _buildTree, 1
          loadret r22
          mov r22, r18
          mov r18, r23
          storeoutargument r23, 0
          call _treeprint, 1
          loadret r24
          loadi 999, r25
          loadi -1, r26
          mult r26, r25, r26
          print r26
          mov r18, r27
          storeoutargument r27, 0
          call _inOrder, 1
          loadret r28
          mov r28, r19
          mov r19, r29
          storeoutargument r29, 0
          call _printList, 1
          loadret r30
          loadi 999, r31
          loadi -1, r32
          mult r32, r31, r32
          print r32
          mov r19, r33
          storeoutargument r33, 0
          call _freeList, 1
          loadret r34
          mov r18, r35
          storeoutargument r35, 0
          call _postOrder, 1
          loadret r36
          mov r36, r20
          mov r20, r37
          storeoutargument r37, 0
          call _printList, 1
          loadret r38
          loadi 999, r39
          loadi -1, r40
          mult r40, r39, r40
          print r40
          mov r20, r41
          storeoutargument r41, 0
          call _freeList, 1
          loadret r42
          mov r18, r43
          loadi 0, r44
          storeoutargument r43, 0
          storeoutargument r44, 1
          call _treesearch, 2
          loadret r45
          print r45
          loadi 999, r46
          loadi -1, r47
          mult r47, r46, r47
          print r47
          mov r18, r48
          loadi 10, r49
          storeoutargument r48, 0
          storeoutargument r49, 1
          call _treesearch, 2
          loadret r50
          print r50
          loadi 999, r51
          loadi -1, r52
          mult r52, r51, r52
          print r52
          mov r18, r53
          loadi 2, r54
          loadi -1, r55
          mult r55, r54, r55
          storeoutargument r53, 0
          storeoutargument r55, 1
          call _treesearch, 2
          loadret r56
          print r56
          loadi 999, r57
          loadi -1, r58
          mult r58, r57, r58
          print r58
          mov r18, r59
          loadi 2, r60
          storeoutargument r59, 0
          storeoutargument r60, 1
          call _treesearch, 2
          loadret r61
          print r61
          loadi 999, r62
          loadi -1, r63
          mult r63, r62, r63
          print r63
          mov r18, r64
          loadi 3, r65
          storeoutargument r64, 0
          storeoutargument r65, 1
          call _treesearch, 2
          loadret r66
          print r66
          loadi 999, r67
          loadi -1, r68
          mult r68, r67, r68
          print r68
          mov r18, r69
          loadi 9, r70
          storeoutargument r69, 0
          storeoutargument r70, 1
          call _treesearch, 2
          loadret r71
          print r71
          loadi 999, r72
          loadi -1, r73
          mult r73, r72, r73
          print r73
          mov r18, r74
          loadi 1, r75
          storeoutargument r74, 0
          storeoutargument r75, 1
          call _treesearch, 2
          loadret r76
          print r76
          loadi 999, r77
          loadi -1, r78
          mult r78, r77, r78
          print r78
          mov r18, r79
          loadi 0, r80
          storeoutargument r79, 0
          storeoutargument r80, 1
          call _bintreesearch, 2
          loadret r81
          print r81
          loadi 999, r82
          loadi -1, r83
          mult r83, r82, r83
          print r83
          mov r18, r84
          loadi 10, r85
          storeoutargument r84, 0
          storeoutargument r85, 1
          call _bintreesearch, 2
          loadret r86
          print r86
          loadi 999, r87
          loadi -1, r88
          mult r88, r87, r88
          print r88
          mov r18, r89
          loadi 2, r90
          loadi -1, r91
          mult r91, r90, r91
          storeoutargument r89, 0
          storeoutargument r91, 1
          call _bintreesearch, 2
          loadret r92
          print r92
          loadi 999, r93
          loadi -1, r94
          mult r94, r93, r94
          print r94
          mov r18, r95
          loadi 2, r96
          storeoutargument r95, 0
          storeoutargument r96, 1
          call _bintreesearch, 2
          loadret r97
          print r97
          loadi 999, r98
          loadi -1, r99
          mult r99, r98, r99
          print r99
          mov r18, r100
          loadi 3, r101
          storeoutargument r100, 0
          storeoutargument r101, 1
          call _bintreesearch, 2
          loadret r102
          print r102
          loadi 999, r103
          loadi -1, r104
          mult r104, r103, r104
          print r104
          mov r18, r105
          loadi 9, r106
          storeoutargument r105, 0
          storeoutargument r106, 1
          call _bintreesearch, 2
          loadret r107
          print r107
          loadi 999, r108
          loadi -1, r109
          mult r109, r108, r109
          print r109
          mov r18, r110
          loadi 1, r111
          storeoutargument r110, 0
          storeoutargument r111, 1
          call _bintreesearch, 2
          loadret r112
          print r112
          loadi 999, r113
          loadi -1, r114
          mult r114, r113, r114
          print r114
          mov r18, r115
          storeoutargument r115, 0
          call _freeTree, 1
          loadret r116
  L104:
_myCopy:
          loadinargument src, 0, r17
  L106:
          mov r17, r18
          loadi 0, r19
          loadi 0, r20
          comp r19, r18, ccr
          moveq 1, r20
          compi 1, r20, ccr
          cbrne cc, L108, L107
  L107:
          loadi 0, r21
          storeret r21
          br L105
          br L109
  L109:
          loadi 0, r22
          mov r17, r23
          loadAI r23, @data, r24
          storeoutargument r22, 0
          storeoutargument r24, 1
          call _add, 2
          loadret r25
          mov r17, r26
          loadAI r26, @next, r27
          storeoutargument r27, 0
          call _myCopy, 1
          loadret r28
          storeoutargument r25, 0
          storeoutargument r28, 1
          call _concatLists, 2
          loadret r29
          storeret r29
          br L105
  L105:
  L108:
          br L109
 _main:
          loadi 0, r23
          mov r23, r19
          loadi 0, r24
          mov r24, r17
          mov r17, r25
          loadi 10, r26
          loadi 0, r27
          comp r26, r25, ccr
          movlt 1, r27
          compi 1, r27, ccr
          cbrne cc, L112, L111
  L111:
          read r28
          mov r28, r18
          mov r19, r29
          mov r18, r30
          storeoutargument r29, 0
          storeoutargument r30, 1
          call _add, 2
          loadret r31
          mov r31, r19
          mov r19, r32
          storeoutargument r32, 0
          call _myCopy, 1
          loadret r33
          mov r33, r20
          mov r19, r34
          storeoutargument r34, 0
          call _myCopy, 1
          loadret r35
          mov r35, r21
          mov r20, r36
          storeoutargument r36, 0
          call _quickSortMain, 1
          loadret r37
          mov r37, r22
          mov r22, r38
          storeoutargument r38, 0
          call _freeList, 1
          loadret r39
          mov r21, r40
          storeoutargument r40, 0
          call _treeMain, 1
          loadret r41
          mov r17, r42
          loadi 1, r43
          add r42, r43, r44
          mov r44, r17
          mov r17, r45
          loadi 10, r46
          loadi 0, r47
          comp r46, r45, ccr
          movlt 1, r47
          compi 1, r47, ccr
          cbrne cc, L112, L111
  L112:
          mov r19, r48
          storeoutargument r48, 0
          call _freeList, 1
          loadret r49
          mov r20, r50
          storeoutargument r50, 0
          call _freeList, 1
          loadret r51
          mov r21, r52
          storeoutargument r52, 0
          call _freeList, 1
          loadret r53
          loadi 0, r54
          storeret r54
          br L110
  L110:
