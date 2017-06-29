package regexp



fun main(args: Array<String>) {
    fun test(string : String, regexp : String) {
        println("$string  >>>>  $regexp  = ${NFA(infixToPrefix(regexp)).match(string)}")
    }

    test("@b/&&","[>-z]+/*&+p?m*")

}

