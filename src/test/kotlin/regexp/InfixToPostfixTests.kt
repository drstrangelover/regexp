package test.kotlin.regexp

import main.kotlin.regexp.tokenize
import org.junit.Test
import regexp.findFirst
import regexp.findLast
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
        //assertEquals("hello","hi hello = goodbye".findFirst(".*^lhello.*"))
        assertEquals("sum","= sum".findLast("= *^ +").drop(1).dropWhile { it == ' ' })
    }
}