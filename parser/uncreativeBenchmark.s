      .file   "uncreativeBenchmark.c"
      .section    __TEXT,__cstring,cstring_literals
L_.str:
      .asciz   "%ld\n\0"
      .text
      .globl _main
L2_.str:
      .asciz   "%ld\0"
      .text
      .globl _main
_countTotal:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r13
       movq $0, %rbx
       movq %rbx, %rbx
       movq %r13, %rbx
       movq 0(%rbx), %r12
       movq %r13, %rbx
       movq 8(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 16(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 24(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 32(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 40(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 48(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 56(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %r12
       popq %r8
       movq %r13, %rbx
       movq 64(%rbx), %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %rbx
       movq %rbx, %rbx
       movq %rbx, %rax
       jmp L1
    L1:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
_printRecursive:
       pushq %rbp
       movq %rsp, %rbp
       subq $152, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r11
       movq %r11, -56(%rbp)
       movq %rsi, %r11
       movq %r11, -64(%rbp)
    L3:
       movq -64(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L5
       jmp L4
    L4:
       movq -56(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rax
       jmp L2
       jmp L6
    L6:
    L2:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $152, %rsp
       popq %rbp
       ret
    L5:
       movq -56(%rbp), %r10
       movq %r10, %rbx
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
       movq -64(%rbp), %r10
       movq %r10, %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       subq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq %rbx, %r11
       movq %r11, -64(%rbp)
       movq -56(%rbp), %r10
       movq %r10, %r12
       movq -64(%rbp), %r10
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq %rbx, %rax
       jmp L2
       jmp L6
_convertBinary:
       pushq %rbp
       movq %rsp, %rbp
       subq $128, %rsp
       movq %rbx, -8(%rbp)
       movq %r12, -16(%rbp)
       movq %r13, -24(%rbp)
       movq %r14, -32(%rbp)
       movq %r15, -40(%rbp)
       movq %rdi, %r14
    L8:
       movq %r14, %r13
       movq $0, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L10
       jmp L9
    L9:
       movq $0, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L43
   L43:
    L7:
       movq -8(%rbp), %rbx
       movq -16(%rbp), %r12
       movq -24(%rbp), %r13
       movq -32(%rbp), %r14
       movq -40(%rbp), %r15
       addq $128, %rsp
       popq %rbp
       ret
   L10:
   L11:
       movq %r14, %r13
       movq $1, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L13
       jmp L12
   L12:
       movq $1, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L42
   L42:
       jmp L43
   L13:
   L14:
       movq %r14, %r13
       movq $2, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L16
       jmp L15
   L15:
       movq $10, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L41
   L41:
       jmp L42
   L16:
   L17:
       movq %r14, %r13
       movq $3, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L19
       jmp L18
   L18:
       movq $11, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L40
   L40:
       jmp L41
   L19:
   L20:
       movq %r14, %r13
       movq $4, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L22
       jmp L21
   L21:
       movq $100, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L39
   L39:
       jmp L40
   L22:
   L23:
       movq %r14, %r13
       movq $5, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L25
       jmp L24
   L24:
       movq $101, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L38
   L38:
       jmp L39
   L25:
   L26:
       movq %r14, %r13
       movq $6, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L28
       jmp L27
   L27:
       movq $110, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L37
   L37:
       jmp L38
   L28:
   L29:
       movq %r14, %r13
       movq $7, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L31
       jmp L30
   L30:
       movq $111, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L36
   L36:
       jmp L37
   L31:
   L32:
       movq %r14, %r13
       movq $8, %r12
       movq $0, %rbx
       cmpq %r12, %r13
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L34
       jmp L33
   L33:
       movq $1000, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L35
   L35:
       jmp L36
   L34:
       movq $1001, %rbx
       movq %rbx, %rax
       jmp L7
       jmp L35
 _main:
       pushq %rbp
       movq %rsp, %rbp
       subq $200, %rsp
       movq $72, %rdi
       call _malloc
       movq %rax, %rbx
       movq %rbx, %r11
       movq %r11, -16(%rbp)
       movq $0, %rbx
       movq %rbx, %rbx
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 0(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 8(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 16(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 24(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 32(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 40(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 48(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 56(%r11)
       movq $0, %rbx
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 64(%r11)
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -16(%rbp), %rsi
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
       movq -16(%rbp), %rbx
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
       movq %r10, -40(%rbp)
       movq %r10, %r10
       movq $0, %r12
       movq $0, %rbx
       movq -40(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmovne %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L46
       jmp L45
   L45:
   L47:
       movq -32(%rbp), %r10
       movq %r10, -48(%rbp)
       movq %r10, %r10
       movq $1, %r12
       movq $0, %rbx
       movq -48(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L49
       jmp L48
   L48:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 0(%r11)
       jmp L78
   L78:
       pushq %rax
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       leaq L2_.str(%rip), %rdi
       leaq -48(%rbp), %rsi
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
       movq -48(%rbp), %rbx
       movq %rbx, %r11
       movq %r11, -32(%rbp)
       movq -32(%rbp), %r10
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
       jne L46
       jmp L45
   L49:
   L50:
       movq -32(%rbp), %r10
       movq %r10, -72(%rbp)
       movq %r10, %r10
       movq $2, %r12
       movq $0, %rbx
       movq -72(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L52
       jmp L51
   L51:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 8(%r11)
       jmp L77
   L77:
       jmp L78
   L52:
   L53:
       movq -32(%rbp), %r10
       movq %r10, -80(%rbp)
       movq %r10, %r10
       movq $3, %r12
       movq $0, %rbx
       movq -80(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L55
       jmp L54
   L54:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 16(%r11)
       jmp L76
   L76:
       jmp L77
   L55:
   L56:
       movq -32(%rbp), %r10
       movq %r10, -88(%rbp)
       movq %r10, %r10
       movq $4, %r12
       movq $0, %rbx
       movq -88(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L58
       jmp L57
   L57:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 24(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 24(%r11)
       jmp L75
   L75:
       jmp L76
   L58:
   L59:
       movq -32(%rbp), %r10
       movq %r10, -96(%rbp)
       movq %r10, %r10
       movq $5, %r12
       movq $0, %rbx
       movq -96(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L61
       jmp L60
   L60:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 32(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 32(%r11)
       jmp L74
   L74:
       jmp L75
   L61:
   L62:
       movq -32(%rbp), %r10
       movq %r10, -104(%rbp)
       movq %r10, %r10
       movq $6, %r12
       movq $0, %rbx
       movq -104(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L64
       jmp L63
   L63:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 40(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 40(%r11)
       jmp L73
   L73:
       jmp L74
   L64:
   L65:
       movq -32(%rbp), %r10
       movq %r10, -112(%rbp)
       movq %r10, %r10
       movq $7, %r12
       movq $0, %rbx
       movq -112(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L67
       jmp L66
   L66:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 48(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 48(%r11)
       jmp L72
   L72:
       jmp L73
   L67:
   L68:
       movq -32(%rbp), %r10
       movq %r10, -120(%rbp)
       movq %r10, %r10
       movq $8, %r12
       movq $0, %rbx
       movq -120(%rbp), %r11
       cmpq %r12, %r11
       pushq %r8
       movq $1, %r8
       cmoveq %r8, %rbx
       popq %r8
       cmpq $1, %rbx
       jne L70
       jmp L69
   L69:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 56(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 56(%r11)
       jmp L71
   L71:
       jmp L72
   L70:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 64(%rbx), %r12
       movq $1, %rbx
       pushq %r8
       movq %r12, %r8
       addq %rbx, %r8
       movq %r8, %rbx
       popq %r8
       movq -16(%rbp), %r11
       movq %r11, -16(%rbp)
       movq %rbx, 64(%r11)
       jmp L71
   L46:
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _countTotal
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
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
       movq $1, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 0(%rbx), %rbx
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
       call _printRecursive
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
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 8(%rbx), %rbx
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
       call _printRecursive
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
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 16(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $4, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 24(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $5, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 32(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $6, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 40(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $7, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 48(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $8, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 56(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $9, %rbx
       movq %rbx, %rdi
       pushq %rcx
       pushq %rdx
       pushq %rsi
       pushq %rdi
       pushq %r8
       pushq %r9
       pushq %r10
       pushq %r11
       call _convertBinary
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %r12
       movq -16(%rbp), %r10
       movq %r10, %rbx
       movq 64(%rbx), %rbx
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
       call _printRecursive
       popq %r11
       popq %r10
       popq %r9
       popq %r8
       popq %rdi
       popq %rsi
       popq %rdx
       popq %rcx
       movq %rax, %rbx
       movq $0, %rbx
       movq %rbx, %rax
       jmp L44
   L44:
       addq $200, %rsp
       popq %rbp
       ret
