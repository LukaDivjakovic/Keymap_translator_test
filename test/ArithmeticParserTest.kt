import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ArithmeticParserTest {
    private var arithmeticParser: ArithmeticParser = ArithmeticParser()

    @Test
    fun testParse() {
        val result = arithmeticParser.parse("(3+3)")
        assertEquals(6, result)
    }

    @Test
    fun testParse2() {
        val result = arithmeticParser.parse("(2*3)")
        assertEquals(6, result)
    }

    @Test
    fun testParse3() {
        val result = arithmeticParser.parse("(3-2)")
        assertEquals(1, result)
    }

    @Test
    fun testParse4() {
        val result = arithmeticParser.parse("3")
        assertEquals(3, result)
    }

    @Test
    fun testParse5() {
        val result = arithmeticParser.parse("-3")
        assertEquals(-3, result)
    }

    @Test
    fun testParse6() {
        val result = arithmeticParser.parse("((4+2)*5)")
        assertEquals(30, result)
    }

    @Test
    fun testParse7() {
        val result = arithmeticParser.parse("element")
        assertEquals(0, result)
    }

}