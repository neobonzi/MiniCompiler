 _main:
          loadi 1000, r22
          loadi 2, r23
          loadi 0, r29
          comp r23, r22, ccr
          movgt 1, r29
          compi 1, r29, ccr
          cbrne cc, L3, L2
    L2:
          print r22
          loadi 2, r32
          div r22, r32, r33
          loadi 0, r36
          comp r23, r33, ccr
          movgt 1, r36
          compi 1, r36, ccr
          cbrne cc, L3, L2
    L3:
          loadi 0, r37
          storeret r37
          br L1
    L1:
