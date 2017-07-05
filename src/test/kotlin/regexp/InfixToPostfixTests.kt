package test.kotlin.regexp

import main.kotlin.regexp.OperandToken
import main.kotlin.regexp.tokenize
import org.junit.Test
import kotlin.test.assertEquals


class InfixToPostfixTests() {

    @Test
    fun infixToPostfixTest() {
    //    assert()
    }

    @Test
    fun tokenizeTest() {
        assertEquals(arrayListOf(OperandToken('!'))[0].value,tokenize("\\!")[0].value)
    }

}