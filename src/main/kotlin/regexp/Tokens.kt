package main.kotlin.regexp



abstract class Token(open val value : Char)

class OperatorToken(override val value: Char) : Token(value)

class OperandToken(override val value: Char) : Token(value)