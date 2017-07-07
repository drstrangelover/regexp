package regexp

import main.kotlin.regexp.infixToPostfix

fun matchInside(input: String, regexp: String): Boolean {
    return NFA(infixToPostfix(".*$regexp.*")).match(input)
}

fun String.match(regexp: String) : Boolean {
    return NFA(infixToPostfix(regexp)).match(this)
}


fun String.findFirst(regexp: String) : String {
    if (matchInside(this, regexp)) {
        var i = 0
        while (!matchInside(this.dropLast(this.length - 1 - i), regexp)) {
            i++
        }
        var j = 0
        while (matchInside(this.drop(j).dropLast(this.length - 1 - i), regexp)) {
            j++
        }
        return this.drop(j-1).dropLast(this.length - 1 -i)

    }
    return ""
}



class RegExp(var input: String, var regexp: String) {
    fun match() : Boolean {
        return this.input.match(this.regexp)
    }

    fun matchInside(): Boolean {
        return matchInside(this.input, this.regexp)
    }
    fun findFirst(): String {
        return this.input.findFirst(this.regexp)
    }
}