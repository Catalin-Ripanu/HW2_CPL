    .data
    .align  2
    .globl  class_nameTab
    .globl  Int_protObj
    .globl  String_protObj
    .globl  bool_const0
    .globl  bool_const1
    .globl  Main_protObj
    .globl  _int_tag
    .globl  _string_tag
    .globl  _bool_tag
_int_tag:
    .word   2
_string_tag:
    .word   3
_bool_tag:
    .word   4
str_const0:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
str_const1:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const1
    .asciiz "Object"
    .align  2
str_const2:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const2
    .asciiz "IO"
    .align  2
str_const3:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const3
    .asciiz "Int"
    .align  2
str_const4:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const1
    .asciiz "String"
    .align  2
str_const5:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "Bool"
    .align  2
str_const6:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "List"
    .align  2
str_const7:
    .word   3
    .word   7
    .word   String_dispTab
    .word   int_const5
    .asciiz "32-big.cl"
    .align  2
str_const8:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz " "
    .align  2
str_const9:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "
"
    .align  2
str_const10:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "Main"
    .align  2
str_const11:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "!"
    .align  2
str_const12:
    .word   3
    .word   12
    .word   String_dispTab
    .word   int_const7
    .asciiz "Calculam factorial pentru: "
    .align  2
str_const13:
    .word   3
    .word   10
    .word   String_dispTab
    .word   int_const8
    .asciiz "Factorial recursiv: "
    .align  2
str_const14:
    .word   3
    .word   10
    .word   String_dispTab
    .word   int_const8
    .asciiz "Factorial iterativ: "
    .align  2
str_const15:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const3
    .asciiz "A2I"
    .align  2
str_const16:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "0"
    .align  2
str_const17:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "1"
    .align  2
str_const18:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "2"
    .align  2
str_const19:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "3"
    .align  2
str_const20:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "4"
    .align  2
str_const21:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "5"
    .align  2
str_const22:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "6"
    .align  2
str_const23:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "7"
    .align  2
str_const24:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "8"
    .align  2
str_const25:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "9"
    .align  2
str_const26:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "-"
    .align  2
str_const27:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const6
    .asciiz "+"
    .align  2
int_const0:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   0 
int_const1:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   6 
int_const2:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   2 
int_const3:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   3 
int_const4:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   4 
int_const5:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   9 
int_const6:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   1 
int_const7:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   27 
int_const8:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   20 
int_const9:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   5 
int_const10:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   7 
int_const11:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   8 
int_const12:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   10 
bool_const0:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   0
bool_const1:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   1
class_nameTab:
    .word   str_const1 
    .word   str_const2 
    .word   str_const3 
    .word   str_const4 
    .word   str_const5 
    .word   str_const6 
    .word   str_const10 
    .word   str_const15 
class_objTab:
    .word   Object_protObj
    .word   Object_init 
    .word   IO_protObj
    .word   IO_init 
    .word   Int_protObj
    .word   Int_init 
    .word   String_protObj
    .word   String_init 
    .word   Bool_protObj
    .word   Bool_init 
    .word   List_protObj
    .word   List_init 
    .word   Main_protObj
    .word   Main_init 
    .word   A2I_protObj
    .word   A2I_init 
Object_protObj:
    .word   0
    .word   3
    .word   Object_dispTab
IO_protObj:
    .word   1
    .word   3
    .word   IO_dispTab
Int_protObj:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   0
String_protObj:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
Bool_protObj:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   0
List_protObj:
    .word 5
    .word 3
    .word List_dispTab
 
Main_protObj:
    .word 6
    .word 3
    .word Main_dispTab
 
A2I_protObj:
    .word 7
    .word 3
    .word A2I_dispTab
 
Object_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
 
IO_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
    .word IO.out_string 
    .word IO.out_int 
    .word IO.in_string 
    .word IO.in_int 
 
Int_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
 
String_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
    .word String.length 
    .word String.concat 
    .word String.substr 
 
Bool_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
 
List_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
    .word IO.out_string 
    .word IO.out_int 
    .word IO.in_string 
    .word IO.in_int 
    .word List.init 
    .word List.print 
 
Main_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
    .word IO.out_string 
    .word IO.out_int 
    .word IO.in_string 
    .word IO.in_int 
    .word Main.main 
    .word Main.fact_rec 
    .word Main.fact_iter 
 
A2I_dispTab:
    .word Object.abort 
    .word Object.type_name 
    .word Object.copy 
    .word A2I.c2i 
    .word A2I.i2c 
    .word A2I.a2i 
    .word A2I.a2i_aux 
    .word A2I.i2a 
    .word A2I.i2a_aux 
 
.globl  heap_start
heap_start:
    .word   0
    .text
    .globl  Int_init
    .globl  String_init
    .globl  Bool_init
    .globl  Main_init
    .globl  Main.main
Object_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
IO_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
Int_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
String_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
Bool_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
List_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     IO_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
Main_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     IO_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
A2I_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra 
List.init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw      $a0 12($s0) 
	lw		$a0 16($fp) 
	sw      $a0 16($s0) 
	move	$a0 $s0
 
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 8
    jr      $ra 
List.print:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	addiu	$sp $sp -4
	addiu	$sp $sp -4
	move	$s0 $a0
	lw      $a0 12($s0) 
	bnez    $a0 case0
	la      $a0 str_const7
	li      $t1 24
	jal     _case_abort2
case0:
	sw		$a0 -4($fp)
	lw		$t1 0($a0)
	blt		$t1 3 casebranch0
	bgt     $t1 3 casebranch0
	lw		$a0 -4($fp) 
	b		endcase0
casebranch0:
	blt		$t1 2 casebranch1
	bgt     $t1 2 casebranch1
	lw		$a0 -4($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 A2I_protObj
    jal     Object.copy
    jal     A2I_init 
	bnez    $a0 dispatch0
	la      $a0 str_const7
	li      $t1 26
	jal     _dispatch_abort
dispatch0:
	lw      $t1 8($a0)
    lw      $t1 28($t1)
    jalr    $t1 
	b		endcase0
casebranch1:
	blt		$t1 0 casebranch2
	bgt     $t1 0 casebranch2
    move    $a0 $s0
	bnez    $a0 dispatch1
	la      $a0 str_const7
	li      $t1 27
	jal     _dispatch_abort
dispatch1:
	lw      $t1 8($a0)
    lw      $t1 0($t1)
    jalr    $t1 
    la      $a0 str_const0 
 
	b		endcase0
casebranch2:
	lw		$a0 -4($fp)
	jal		_case_abort
endcase0:
	addiu	$sp $sp 4
	sw		$a0 -4($fp) 

    la      $a0 str_const8 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 -4($fp) 
	bnez    $a0 dispatch3
	la      $a0 str_const7
	li      $t1 31
	jal     _dispatch_abort
dispatch3:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch2
	la      $a0 str_const7
	li      $t1 31
	jal     _dispatch_abort
dispatch2:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	lw      $a0 16($s0) 
    move	$t1 $a0
    la		$a0 bool_const1
    beqz	$t1 isvoid4
    la		$a0 bool_const0
isvoid4:
	lw		$t1 12($a0)
    beqz	$t1 else_7
    la      $a0 str_const9 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch5
	la      $a0 str_const7
	li      $t1 32
	jal     _dispatch_abort
dispatch5:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
    b		endif_7
else_7:
    lw      $a0 16($s0) 
	bnez    $a0 dispatch6
	la      $a0 str_const7
	li      $t1 32
	jal     _dispatch_abort
dispatch6:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
endif_7:
 
    addiu $sp $sp 4 
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra 
Main.main:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	addiu	$sp $sp -20
    la      $a0 int_const0 
	sw		$a0 -4($fp) 
    la      $a0 str_const11 
	sw		$a0 -8($fp) 
	lw		$a0 -4($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const2 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    add	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 -12($fp) 
	lw		$a0 -16($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
	lw		$a0 -12($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init 
	bnez    $a0 dispatch10
	la      $a0 str_const7
	li      $t1 47
	jal     _dispatch_abort
dispatch10:
	lw      $t1 8($a0)
    lw      $t1 28($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
	lw		$a0 -8($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init 
	bnez    $a0 dispatch9
	la      $a0 str_const7
	li      $t1 46
	jal     _dispatch_abort
dispatch9:
	lw      $t1 8($a0)
    lw      $t1 28($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
	lw		$a0 -4($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init 
	bnez    $a0 dispatch8
	la      $a0 str_const7
	li      $t1 45
	jal     _dispatch_abort
dispatch8:
	lw      $t1 8($a0)
    lw      $t1 28($t1)
    jalr    $t1 
	sw		$a0 -20($fp) 

    
	bnez    $a0 dispatch11
	la      $a0 str_const7
	li      $t1 49
	jal     _dispatch_abort
dispatch11:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
    addiu $sp $sp 20 
	addiu	$sp $sp -4
    la      $a0 str_const12 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch13
	la      $a0 str_const7
	li      $t1 52
	jal     _dispatch_abort
dispatch13:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	bnez    $a0 dispatch12
	la      $a0 str_const7
	li      $t1 52
	jal     _dispatch_abort
dispatch12:
	lw      $t1 8($a0)
    lw      $t1 24($t1)
    jalr    $t1 
	sw		$a0 -4($fp) 

    la      $a0 str_const9 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 -4($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch16
	la      $a0 str_const7
	li      $t1 55
	jal     _dispatch_abort
dispatch16:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 str_const13 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch17
	la      $a0 str_const7
	li      $t1 55
	jal     _dispatch_abort
dispatch17:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	bnez    $a0 dispatch15
	la      $a0 str_const7
	li      $t1 55
	jal     _dispatch_abort
dispatch15:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
	bnez    $a0 dispatch14
	la      $a0 str_const7
	li      $t1 56
	jal     _dispatch_abort
dispatch14:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
    la      $a0 str_const9 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 -4($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch20
	la      $a0 str_const7
	li      $t1 57
	jal     _dispatch_abort
dispatch20:
	lw      $t1 8($a0)
    lw      $t1 36($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 str_const14 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch21
	la      $a0 str_const7
	li      $t1 57
	jal     _dispatch_abort
dispatch21:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	bnez    $a0 dispatch19
	la      $a0 str_const7
	li      $t1 57
	jal     _dispatch_abort
dispatch19:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
	bnez    $a0 dispatch18
	la      $a0 str_const7
	li      $t1 58
	jal     _dispatch_abort
dispatch18:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
 
    addiu $sp $sp 4 
 
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra 
Main.fact_rec:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_22
	la		$a1 bool_const0
	jal		equality_test
eq_22:
	lw		$t1 12($a0)
    beqz	$t1 else_24
    la      $a0 int_const6 
    b		endif_24
else_24:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    sub	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch23
	la      $a0 str_const7
	li      $t1 65
	jal     _dispatch_abort
dispatch23:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    mul	$t1 $t1 $t2
	sw		$t1 12($a0)
endif_24:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
Main.fact_iter:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	addiu	$sp $sp -4
    la      $a0 int_const6 
	sw		$a0 -4($fp) 

while_27:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_25
	la		$a1 bool_const0
	jal		equality_test
eq_25:
	lw		$t1 12($a0)
	la		$a0 bool_const1
	beqz	$t1 not_26
	la		$a0 bool_const0
not_26:
	lw		$t1 12($a0)
	beqz	$t1 end_while_27
	lw		$a0 -4($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
	lw		$a0 12($fp) 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    mul	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 -4($fp) 
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    sub	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 12($fp) 
 
	b		while_27
end_while_27:
	li		$a0 0
	lw		$a0 -4($fp) 
 
    addiu $sp $sp 4 
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.c2i:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const16 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_28
	la		$a1 bool_const0
	jal		equality_test
eq_28:
	lw		$t1 12($a0)
    beqz	$t1 else_48
    la      $a0 int_const0 
    b		endif_48
else_48:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const17 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_29
	la		$a1 bool_const0
	jal		equality_test
eq_29:
	lw		$t1 12($a0)
    beqz	$t1 else_47
    la      $a0 int_const6 
    b		endif_47
else_47:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const18 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_30
	la		$a1 bool_const0
	jal		equality_test
eq_30:
	lw		$t1 12($a0)
    beqz	$t1 else_46
    la      $a0 int_const2 
    b		endif_46
else_46:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const19 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_31
	la		$a1 bool_const0
	jal		equality_test
eq_31:
	lw		$t1 12($a0)
    beqz	$t1 else_45
    la      $a0 int_const3 
    b		endif_45
else_45:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const20 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_32
	la		$a1 bool_const0
	jal		equality_test
eq_32:
	lw		$t1 12($a0)
    beqz	$t1 else_44
    la      $a0 int_const4 
    b		endif_44
else_44:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const21 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_33
	la		$a1 bool_const0
	jal		equality_test
eq_33:
	lw		$t1 12($a0)
    beqz	$t1 else_43
    la      $a0 int_const9 
    b		endif_43
else_43:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const22 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_34
	la		$a1 bool_const0
	jal		equality_test
eq_34:
	lw		$t1 12($a0)
    beqz	$t1 else_42
    la      $a0 int_const1 
    b		endif_42
else_42:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const23 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_35
	la		$a1 bool_const0
	jal		equality_test
eq_35:
	lw		$t1 12($a0)
    beqz	$t1 else_41
    la      $a0 int_const10 
    b		endif_41
else_41:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const24 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_36
	la		$a1 bool_const0
	jal		equality_test
eq_36:
	lw		$t1 12($a0)
    beqz	$t1 else_40
    la      $a0 int_const11 
    b		endif_40
else_40:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const25 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_37
	la		$a1 bool_const0
	jal		equality_test
eq_37:
	lw		$t1 12($a0)
    beqz	$t1 else_39
    la      $a0 int_const5 
    b		endif_39
else_39:
    move    $a0 $s0
	bnez    $a0 dispatch38
	la      $a0 str_const7
	li      $t1 111
	jal     _dispatch_abort
dispatch38:
	lw      $t1 8($a0)
    lw      $t1 0($t1)
    jalr    $t1 
    la      $a0 int_const0 
 
endif_39:
endif_40:
endif_41:
endif_42:
endif_43:
endif_44:
endif_45:
endif_46:
endif_47:
endif_48:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.i2c:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_49
	la		$a1 bool_const0
	jal		equality_test
eq_49:
	lw		$t1 12($a0)
    beqz	$t1 else_69
    la      $a0 str_const16 
    b		endif_69
else_69:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_50
	la		$a1 bool_const0
	jal		equality_test
eq_50:
	lw		$t1 12($a0)
    beqz	$t1 else_68
    la      $a0 str_const17 
    b		endif_68
else_68:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const2 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_51
	la		$a1 bool_const0
	jal		equality_test
eq_51:
	lw		$t1 12($a0)
    beqz	$t1 else_67
    la      $a0 str_const18 
    b		endif_67
else_67:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const3 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_52
	la		$a1 bool_const0
	jal		equality_test
eq_52:
	lw		$t1 12($a0)
    beqz	$t1 else_66
    la      $a0 str_const19 
    b		endif_66
else_66:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const4 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_53
	la		$a1 bool_const0
	jal		equality_test
eq_53:
	lw		$t1 12($a0)
    beqz	$t1 else_65
    la      $a0 str_const20 
    b		endif_65
else_65:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const9 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_54
	la		$a1 bool_const0
	jal		equality_test
eq_54:
	lw		$t1 12($a0)
    beqz	$t1 else_64
    la      $a0 str_const21 
    b		endif_64
else_64:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const1 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_55
	la		$a1 bool_const0
	jal		equality_test
eq_55:
	lw		$t1 12($a0)
    beqz	$t1 else_63
    la      $a0 str_const22 
    b		endif_63
else_63:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const10 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_56
	la		$a1 bool_const0
	jal		equality_test
eq_56:
	lw		$t1 12($a0)
    beqz	$t1 else_62
    la      $a0 str_const23 
    b		endif_62
else_62:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const11 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_57
	la		$a1 bool_const0
	jal		equality_test
eq_57:
	lw		$t1 12($a0)
    beqz	$t1 else_61
    la      $a0 str_const24 
    b		endif_61
else_61:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const5 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_58
	la		$a1 bool_const0
	jal		equality_test
eq_58:
	lw		$t1 12($a0)
    beqz	$t1 else_60
    la      $a0 str_const25 
    b		endif_60
else_60:
    move    $a0 $s0
	bnez    $a0 dispatch59
	la      $a0 str_const7
	li      $t1 129
	jal     _dispatch_abort
dispatch59:
	lw      $t1 8($a0)
    lw      $t1 0($t1)
    jalr    $t1 
    la      $a0 str_const0 
 
endif_60:
endif_61:
endif_62:
endif_63:
endif_64:
endif_65:
endif_66:
endif_67:
endif_68:
endif_69:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.a2i:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    lw		$a0 12($fp) 
	bnez    $a0 dispatch70
	la      $a0 str_const7
	li      $t1 142
	jal     _dispatch_abort
dispatch70:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_71
	la		$a1 bool_const0
	jal		equality_test
eq_71:
	lw		$t1 12($a0)
    beqz	$t1 else_85
    la      $a0 int_const0 
    b		endif_85
else_85:
    la      $a0 int_const6 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 int_const0 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 12($fp) 
	bnez    $a0 dispatch72
	la      $a0 str_const7
	li      $t1 143
	jal     _dispatch_abort
dispatch72:
	lw      $t1 8($a0)
    lw      $t1 20($t1)
    jalr    $t1 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const26 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_73
	la		$a1 bool_const0
	jal		equality_test
eq_73:
	lw		$t1 12($a0)
    beqz	$t1 else_84
    lw		$a0 12($fp) 
	bnez    $a0 dispatch76
	la      $a0 str_const7
	li      $t1 143
	jal     _dispatch_abort
dispatch76:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    sub	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 int_const6 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 12($fp) 
	bnez    $a0 dispatch75
	la      $a0 str_const7
	li      $t1 143
	jal     _dispatch_abort
dispatch75:
	lw      $t1 8($a0)
    lw      $t1 20($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch74
	la      $a0 str_const7
	li      $t1 143
	jal     _dispatch_abort
dispatch74:
	lw      $t1 8($a0)
    lw      $t1 24($t1)
    jalr    $t1 
	lw		$t1 12($a0)
	neg		$t1 $t1
	sw		$t1 12($a0)
    b		endif_84
else_84:
    la      $a0 int_const6 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 int_const0 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 12($fp) 
	bnez    $a0 dispatch77
	la      $a0 str_const7
	li      $t1 144
	jal     _dispatch_abort
dispatch77:
	lw      $t1 8($a0)
    lw      $t1 20($t1)
    jalr    $t1 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 str_const27 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_78
	la		$a1 bool_const0
	jal		equality_test
eq_78:
	lw		$t1 12($a0)
    beqz	$t1 else_83
    lw		$a0 12($fp) 
	bnez    $a0 dispatch81
	la      $a0 str_const7
	li      $t1 144
	jal     _dispatch_abort
dispatch81:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    sub	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 int_const6 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 12($fp) 
	bnez    $a0 dispatch80
	la      $a0 str_const7
	li      $t1 144
	jal     _dispatch_abort
dispatch80:
	lw      $t1 8($a0)
    lw      $t1 20($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch79
	la      $a0 str_const7
	li      $t1 144
	jal     _dispatch_abort
dispatch79:
	lw      $t1 8($a0)
    lw      $t1 24($t1)
    jalr    $t1 
    b		endif_83
else_83:
	lw		$a0 12($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch82
	la      $a0 str_const7
	li      $t1 145
	jal     _dispatch_abort
dispatch82:
	lw      $t1 8($a0)
    lw      $t1 24($t1)
    jalr    $t1 
endif_83:
endif_84:
endif_85:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.a2i_aux:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	addiu	$sp $sp -4
    la      $a0 int_const0 
	sw		$a0 -4($fp) 

	addiu	$sp $sp -4
    lw		$a0 12($fp) 
	bnez    $a0 dispatch86
	la      $a0 str_const7
	li      $t1 156
	jal     _dispatch_abort
dispatch86:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	sw		$a0 -8($fp) 

	addiu	$sp $sp -4
    la      $a0 int_const0 
	sw		$a0 -12($fp) 

while_90:
	sw		$a0 0($sp)
	addiu	$sp $sp -4
	lw		$a0 -8($fp) 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
	la		$a0 bool_const1
	blt	$t1 $t2 compare_87
	la		$a0 bool_const0
compare_87:
	lw		$t1 12($a0)
	beqz	$t1 end_while_90
	lw		$a0 -4($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const12 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    mul	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
	lw		$a0 -12($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    lw		$a0 12($fp) 
	bnez    $a0 dispatch89
	la      $a0 str_const7
	li      $t1 160
	jal     _dispatch_abort
dispatch89:
	lw      $t1 8($a0)
    lw      $t1 20($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch88
	la      $a0 str_const7
	li      $t1 160
	jal     _dispatch_abort
dispatch88:
	lw      $t1 8($a0)
    lw      $t1 12($t1)
    jalr    $t1 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    add	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 -4($fp) 
	lw		$a0 -12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    add	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 -12($fp) 
 
	b		while_90
end_while_90:
	li		$a0 0
    addiu $sp $sp 4 
    addiu $sp $sp 4 
	lw		$a0 -4($fp) 
 
    addiu $sp $sp 4 
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.i2a:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_91
	la		$a1 bool_const0
	jal		equality_test
eq_91:
	lw		$t1 12($a0)
    beqz	$t1 else_97
    la      $a0 str_const16 
    b		endif_97
else_97:
    la      $a0 int_const0 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
	lw		$a0 12($fp) 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
	la		$a0 bool_const1
	blt	$t1 $t2 compare_92
	la		$a0 bool_const0
compare_92:
	lw		$t1 12($a0)
    beqz	$t1 else_96
	lw		$a0 12($fp) 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch93
	la      $a0 str_const7
	li      $t1 177
	jal     _dispatch_abort
dispatch93:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
    b		endif_96
else_96:
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const6 
	lw		$t1 12($a0)
	neg		$t1 $t1
	sw		$t1 12($a0)
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    mul	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch95
	la      $a0 str_const7
	li      $t1 178
	jal     _dispatch_abort
dispatch95:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    la      $a0 str_const26 
	bnez    $a0 dispatch94
	la      $a0 str_const7
	li      $t1 178
	jal     _dispatch_abort
dispatch94:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
endif_96:
endif_97:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
A2I.i2a_aux:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const0 
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	move	$t2 $a0
	la		$a0 bool_const1
	beq		$t1 $t2 eq_98
	la		$a1 bool_const0
	jal		equality_test
eq_98:
	lw		$t1 12($a0)
    beqz	$t1 else_102
    la      $a0 str_const0 
    b		endif_102
else_102:
	addiu	$sp $sp -4
	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const12 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    div	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw		$a0 -4($fp) 

	lw		$a0 12($fp) 
	sw		$a0 0($sp)
	addiu	$sp $sp -4
	sw		$a0 0($sp)
	addiu	$sp $sp -4
    la      $a0 int_const12 
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    mul	$t1 $t1 $t2
	sw		$t1 12($a0)
	jal		Object.copy
	lw		$t1 4($sp)
	addiu	$sp $sp 4
	lw		$t1 12($t1)
	lw		$t2 12($a0)
    sub	$t1 $t1 $t2
	sw		$t1 12($a0)
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch100
	la      $a0 str_const7
	li      $t1 188
	jal     _dispatch_abort
dispatch100:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    
	sw      $a0 0($sp)
	addiu   $sp $sp -4 
    move    $a0 $s0
	bnez    $a0 dispatch101
	la      $a0 str_const7
	li      $t1 188
	jal     _dispatch_abort
dispatch101:
	lw      $t1 8($a0)
    lw      $t1 32($t1)
    jalr    $t1 
	bnez    $a0 dispatch99
	la      $a0 str_const7
	li      $t1 188
	jal     _dispatch_abort
dispatch99:
	lw      $t1 8($a0)
    lw      $t1 16($t1)
    jalr    $t1 
    addiu $sp $sp 4 
endif_102:
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra 
