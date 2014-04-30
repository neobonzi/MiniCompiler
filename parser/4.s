         g:
                pushq %rbp
                movq %rsp, %rbp
        L1:
                popq %rbp
                ret
       foo:
                pushq %rbp
                movq %rsp, %rbp
        L2:
        L3:
        L5:
        L6:
                popq %rbp
                ret
        L4:
         f:
                pushq %rbp
                movq %rsp, %rbp
        L7:
                popq %rbp
                ret
       bar:
                pushq %rbp
                movq %rsp, %rbp
        L8:
                popq %rbp
                ret
      main:
                pushq %rbp
                movq %rsp, %rbp
        L9:
       L10:
       L11:
       L13:
       L14:
       L15:
       L17:
       L18:
       L19:
       L20:
                popq %rbp
                ret
       L16:
