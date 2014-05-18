      .file   "4.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%d\n\0"
      .text
      .globl _main
      .comm   bb,8,8
      .comm   b,8,8
      .comm   bbb,8,8
      .comm   bob,8,8
      .comm   i,8,8
      .comm   j,8,8
      .comm   k,8,8
    _g:
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), %rax
       movq 16(%rbp), %rax
       movq $3, %rax
       movq %rax, %rax
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), r17
       movq 16(%rbp), r18
       movq $3, r22
       movq r22, %rax
    L1:
       popq %rbp
       ret
       popq %rbp
       ret
  _foo:
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), %rdi
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), r17
    L2:
       movq %rdi, %rdx
       movq $0, %rbx
       movq $0, %rsi
       cmp %rdx, %rbx
       movq $1, %rsi
       cmovle %rsi, %rcx
       cmp $1, %rcx
       jne L4
       jmp L3
       movq r17, r18
       movq $0, r19
       movq $0, r20
       cmp r18, r19
       movq $1, r20
       cmovle r20, r21
       cmp $1, r21
       jne L4
       jmp L3
    L3:
       movq $1, %rsp
       movq %rsp, %rax
       jmp L5
       movq $1, r22
       movq r22, %rax
       jmp L5
    L5:
    L6:
       popq %rbp
       ret
       popq %rbp
       ret
    L4:
       movq %rdi, %r9
       movq %rdi, %rdi
       movq $1, %r8
       movq %rdi, %rdx
       subq %r8, %rdx
       movq %rdx, %rdi
       call _foo
       movq %rax, %r8
       movq %r9, %rsp
       imulq %r8, %rsp
       movq %rsp, %rax
       jmp L5
       movq r17, r23
       movq r17, r24
       movq $1, r25
       movq r24, r26
       subq r25, r26
       movq r26, %rdi
       call _foo
       movq %rax, r27
       movq r23, r28
       imulq r27, r28
       movq r28, %rax
       jmp L5
    _f:
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), %rcx
       movq 16(%rbp), %rbx
       movq $7, %rsp
       movq b(%rip), %rdi
       movq 8(%rdi), %rsi
       movq 32(%rsi), %rdx
       movq 32(%rdx), %rax
       movq %rsp, 0(%rax)
       leaq b(%rip), %rax
       movq 8(%rax), %rsp
       movq 32(%rsp), %rsp
       movq 32(%rsp), %rsp
       movq 32(%rsp), %rbx
       movq %rbx, %rax
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), r17
       movq 16(%rbp), r18
       movq $7, r22
       movq b(%rip), r23
       movq 8(r23), r24
       movq 32(r24), r25
       movq 32(r25), r26
       movq r22, 0(r26)
       leaq b(%rip), r27
       movq 8(r27), r28
       movq 32(r28), r29
       movq 32(r29), r30
       movq 32(r30), r31
       movq r31, %rax
    L7:
       popq %rbp
       ret
       popq %rbp
       ret
  _bar:
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), %rax
       movq 16(%rbp), %rax
       pushq %rbp
       movq %rsp, %rbp
       movq 8(%rbp), r17
       movq 16(%rbp), r18
    L8:
       popq %rbp
       ret
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
    L9:
       movq $2, r23
       movq r23, %r8
   L10:
       movq %r8, %rsp
       movq $1, %rdx
       movq $0, %rcx
       movq %rdx, %rdi
       movq %rcx, %rsi
       call _g
       movq %rax, %rbx
       movq $0, %r10
       cmp %rsp, %rbx
       movq $1, %r10
       cmovlt %r10, %rdi
       jne L12
       jmp L11
   L11:
       movq $1, %rsi
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rsi, %rsi
       call _printf
       jmp L13
   L13:
   L14:
       movq %r8, %r11
       movq $1, %r9
       movq $0, %r8
       movq %r9, %rdi
       movq %r8, %rsi
       call _g
       movq %rax, %rsp
       movq $0, r35
       cmp %r11, %rsp
       movq $1, r35
       cmovgt r35, r36
       cmp $1, r36
       jne L16
       jmp L15
   L15:
       movq $1, %r15
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %r15, %rsi
       call _printf
       jmp L17
   L17:
       movq $1, %r13
       cmp $1, %r13
       jne L19
       jmp L18
   L18:
       movq $7, %r12
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %r12, %rsi
       call _printf
       movq $1, %r11
       cmp $1, %r11
       jne L19
       jmp L18
   L19:
       movq $1, r42
       movq $8, %rdi
       call malloc
       movq %rax, r43
       movq r42, %rdi
       movq r43, %rsi
       call _g
       movq %rax, r44
       movq $8, %rdi
       call malloc
       movq %rax, r45
       movq r44, %rdi
       movq r45, %rsi
       call _f
       movq %rax, r46
       movq $1, r47
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq r47, %rsi
       call _printf
       movq $8, %rdi
       call malloc
       movq %rax, r48
       movq $1, r49
       movq $8, %rdi
       call malloc
       movq %rax, r50
       movq r49, %rdi
       movq r50, %rsi
       call _g
       movq %rax, r51
       movq r48, %rdi
       movq r51, %rsi
       call _bar
       movq %rax, r52
       movq $2, r53
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq r53, %rsi
       call _printf
       movq $1, r54
       movq $8, %rdi
       call malloc
       movq %rax, r55
       movq r54, %rdi
       movq r55, %rsi
       call _g
       movq %rax, r56
       movq $8, %rdi
       call malloc
       movq %rax, r57
       movq r56, %rdi
       movq r57, %rsi
       call _f
       movq %rax, %rsp
       movq 8(%rsp), r59
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq r59, %rsi
       call _printf
       movq $0, r60
       movq r60, %rax
   L20:
       popq %rbp
       ret
   L16:
       movq $3, %r14
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %r14, %rsi
       call _printf
       jmp L17
