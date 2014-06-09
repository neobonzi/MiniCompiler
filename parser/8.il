_buildList:
          new node, r25
          mov r25, r19
          new node, r26
          mov r26, r20
          new node, r27
          mov r27, r21
          new node, r28
          mov r28, r22
          new node, r29
          mov r29, r23
          new node, r30
          mov r30, r24
          loadAI r19, @value, r31
          read r31
          loadAI r20, @value, r32
          read r32
          loadAI r21, @value, r33
          read r33
          loadAI r22, @value, r34
          read r34
          loadAI r23, @value, r35
          read r35
          loadAI r24, @value, r36
          read r36
          mov r20, r37
          storeai r37, r19,  @next
          mov r21, r38
          storeai r38, r20,  @next
          mov r22, r39
          storeai r39, r21,  @next
          mov r23, r40
          storeai r40, r22,  @next
          mov r24, r41
          storeai r41, r23,  @next
          loadi 0, r42
          storeai r42, r24,  @next
          mov r19, r43
          storeret r43
          br L1
    L1:
 _main:
          call _buildList, 0
          loadret r17
          loadi 0, r18
          storeret r18
          br L2
    L2:
