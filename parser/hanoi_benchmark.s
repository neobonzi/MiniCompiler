      .file   "hanoi_benchmark.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
      .comm   peg2,8,8
      .comm   peg3,8,8
      .comm   numMoves,8,8
      .comm   peg1,8,8
 _move:
       pushq %rbp
       movq %rsp, %rbp
       subq $136, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq %rsi, %r15
    L2:
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L4
       jmp L3
    L3:
       movq peg1(%rip), %rbx
       movq %rbx, %r14
       movq peg1(%rip), %rbx
       movq 8(%rbx), %r12
       leaq peg1(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L9
    L9:
   L10:
       movq %r15, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L12
       jmp L11
   L11:
       movq peg1(%rip), %rbx
       movq %rbx, 8(%r14)
       movq %r14, %r12
       leaq peg1(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L17
   L17:
       movq numMoves(%rip), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       leaq numMoves(%rip), %rbx
       movq %r12, 0(%rbx)
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $136, %rsp
       popq %rbp
       ret
   L12:
   L13:
       movq %r15, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L15
       jmp L14
   L14:
       movq peg2(%rip), %rbx
       movq %rbx, 8(%r14)
       movq %r14, %r12
       leaq peg2(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L16
   L16:
       jmp L17
   L15:
       movq peg3(%rip), %rbx
       movq %rbx, 8(%r14)
       movq %r14, %r12
       leaq peg3(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L16
    L4:
    L5:
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L7
       jmp L6
    L6:
       movq peg2(%rip), %rbx
       movq %rbx, %r14
       movq peg2(%rip), %rbx
       movq 8(%rbx), %r12
       leaq peg2(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L8
    L8:
       jmp L9
    L7:
       movq peg3(%rip), %rbx
       movq %rbx, %r14
       movq peg3(%rip), %rbx
       movq 8(%rbx), %r12
       leaq peg3(%rip), %rbx
       movq %r12, 0(%rbx)
       jmp L8
_hanoi:
       pushq %rbp
       movq %rsp, %rbp
       subq $176, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq %rsi, %r11
       movq %r11, -64(%rbp)
       movq %rdx, %r11
       movq %r11, -72(%rbp)
       movq %rcx, %r11
       movq %r11, -80(%rbp)
   L19:
       movq -56(%rbp), %r10
       movq %r10, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L21
       jmp L20
   L20:
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %r12, %rdi
       movq %rbx, %rsi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _move
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       jmp L22
   L22:
   L18:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $176, %rsp
       popq %rbp
       ret
   L21:
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r11
       movq %r11, -88(%rbp)
       popq %r8
       movq -64(%rbp), %r10
       movq %r10, %r13
       movq -80(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq -88(%rbp), %r10
       movq %r10, %rdi
       movq %r13, %rsi
       movq %r12, %rdx
       movq %rbx, %rcx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _hanoi
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq -72(%rbp), %r10
       movq %r10, %rbx
       movq %r12, %rdi
       movq %rbx, %rsi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _move
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %r11
       movq %r11, -96(%rbp)
       popq %r8
       movq -80(%rbp), %r10
       movq %r10, %r13
       movq -72(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
       movq %r10, %rbx
       movq -96(%rbp), %r10
       movq %r10, %rdi
       movq %r13, %rsi
       movq %r12, %rdx
       movq %rbx, %rcx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _hanoi
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       jmp L22
_printPeg:
       pushq %rbp
       movq %rsp, %rbp
       subq $152, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %rbx
       movq %rbx, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -64(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L25
       jmp L24
   L24:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -56(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L25
       jmp L24
   L25:
   L23:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $152, %rsp
       popq %rbp
       ret
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $176, %rsp
       movq $0, %r12
       leaq peg1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $0, %r12
       leaq peg2(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $0, %r12
       leaq peg3(%rip), %rbx
       movq %r12, 0(%rbx)
       movq $0, %r12
       leaq numMoves(%rip), %rbx
       movq %r12, 0(%rbx)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -8(%rbp), %rsi
       movq $0, %rax
       call _scanf
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       popq %rax
       movq -8(%rbp), %rbx
       movq %rbx, %r11
       movq %r11, -24(%rbp)
   L27:
       movq -24(%rbp), %r10
       movq %r10, -32(%rbp)
       movq %r10, %r10
       movq $1, %r12
       movq $0, %rbx
       movq -32(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovge %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L29
       jmp L28
   L28:
       movq -24(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %r11
       movq %r11, -40(%rbp)
       movq -40(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -48(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L31
       jmp L30
   L30:
       movq $16, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq -40(%rbp), %r10
       movq %r10, %rbx
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
       movq %rbx, 0(%r11)
       movq peg1(%rip), %rbx
       movq -56(%rbp), %r11
       movq %r11, -56(%rbp)
       movq %rbx, 8(%r11)
       movq -56(%rbp), %r10
       movq %r10, %r12
       leaq peg1(%rip), %rbx
       movq %r12, 0(%rbx)
       movq -40(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -40(%rbp)
       movq -40(%rbp), %r10
       movq %r10, -64(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -64(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L31
       jmp L30
   L31:
       movq $1, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg1(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $2, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg2(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $3, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg3(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq -24(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $1, %r11
       movq %r11, -80(%rbp)
       movq $3, %r12
       movq $2, %rbx
       movq -72(%rbp), %r10
       movq %r10, %rdi
       movq -80(%rbp), %r10
       movq %r10, %rsi
       movq %r12, %rdx
       movq %rbx, %rcx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _hanoi
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $1, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg1(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $2, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg2(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $3, %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg3(%rip), %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _printPeg
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq numMoves(%rip), %rbx
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       leaq L_.str(%rip), %rdi
       movq $0, %rax
       movq %rbx, %rsi
       call _printf
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq peg3(%rip), %r11
       movq %r11, -88(%rbp)
       movq $0, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L33
       jmp L32
   L32:
       movq peg3(%rip), %rbx
       movq %rbx, %r11
       movq %r11, -56(%rbp)
       movq peg3(%rip), %rbx
       movq 8(%rbx), %r12
       leaq peg3(%rip), %rbx
       movq %r12, 0(%rbx)
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq peg3(%rip), %r11
       movq %r11, -96(%rbp)
       movq $0, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L33
       jmp L32
   L33:
       jmp L34
   L34:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L26
   L26:
       addq $176, %rsp
       popq %rbp
       ret
   L29:
       jmp L34
