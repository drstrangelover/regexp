package main.kotlin.regexp

fun regexpMatch(input: String, regexp: String): Boolean {
    return NFA(infixToPostfix("[>z]*$regexp[>z]*")).match(input)
}

fun main(args: Array<String>) {
    fun test(string : String, regexp : String) {
        println("$string  >>>>  $regexp  = ${NFA(infixToPostfix(regexp)).match(string)}")
    }

 //   test("@b/&&","[>-z]+/*&+p?m*")
   // println(match("abcde","bcv?p*de+"))
   println("ab?cde".regexp("ab\\?cde"))
  //  println(NFA(infixToPostfix("as[az]as")).match("\\?asdfasfd"))
}



fun String.regexp(regexp: String) : String {
    if (regexpMatch(this,regexp)) {
        var i = 0
        while (!regexpMatch(this.dropLast(this.length - 1 - i),regexp)) {
            i++
        }
        var j = 0
        while (regexpMatch(this.drop(j).dropLast(this.length - 1 - i),regexp)) {
            j++
        }
        return this.drop(j-1).dropLast(this.length - 1 -i)

    }
    return ""
}



class RegExp(var input: String, var regexp: String) {
    fun match(): Boolean {
        return regexpMatch(this.input,this.regexp)
    }
    fun find(): String {
        return this.input.regexp(this.regexp)
    }
}