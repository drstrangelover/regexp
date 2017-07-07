package test.kotlin.regexp

import main.kotlin.regexp.tokenize
import org.junit.Test
import regexp.match
import kotlin.test.assertEquals


class InfixToPostfixTests() {

    @Test
    fun infixToPostfixTest() {
    //    assert()
    }

    @Test
    fun tokenizeTest() {
        assertEquals('?',tokenize("\\?")[0].value)
    }

    @Test
    fun matchTest() {
        assertEquals(true, "    ".match("  +"))
    }

    @Test
    fun exceptTest() {
        assertEquals(true, "a".match("^b"))
        assertEquals(false,"b".match("^b"))
    }
}