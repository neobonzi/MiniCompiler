 _main:
          loadi 1000, r22
          loadi 2, r23
          comp r23, r22, ccr
          cbrgt cc, L1, L2
    L1:
          print r22
          loadi 2, r31
          div r22, r31, r32
          comp r23, r32, ccr
          cbrgt cc, L1, L2
    L2:
          loadi 0, r35
          storeret r35
    L3:
          ret true
