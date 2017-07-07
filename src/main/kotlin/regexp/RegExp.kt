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

fun String.findLast(regexp: String) : String {
    if (matchInside(this, regexp)) {
        var i = 1
        while (matchInside(this.drop(i), regexp)) {
            i++
        }
        i--
        var j = 0
        while (!(this.drop(i).dropLast(j).match(regexp))) {
            j++
        }

        return this.drop(i).dropLast(j)

    }
    return ""
}