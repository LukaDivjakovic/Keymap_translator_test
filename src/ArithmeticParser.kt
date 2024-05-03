class ArithmeticParser {
    private var input: String = ""
    private var index: Int = 0

    fun parse(expression: String): Int {
        input = expression
        index = 0
        return parseExpression()
    }

    private fun parseExpression(): Int {
        if (peek() == '(') {
            // If it starts with '(', it's a binary expression
            return parseBinaryExpression()
        } else if (peek() == '-' || peek().isDigit()) {
            // It's either a constant expression or a single digit
            return parseConstantExpression()
        } else {
//            honestly i dont understand what the code is supposed to do in this situation, so here is my best guess
            println("Inputted \'element\', don't have further instructions...")
            return 0
        }
    }

    private fun parseBinaryExpression(): Int {
        // Consume the '('
        index++

        // Parse the left expression
        val left = parseExpression()

        // Parse the operation
        val operation = input[index++]

        // Parse the right expression
        val right = parseExpression()

        // Make sure that the ')' is there and consume it
        assert(')' == input[index++])

        // Perform the operation and return the result
        return when (operation) {
            '+' -> left + right
            '-' -> left - right
            '*' -> left * right
            else -> throw IllegalArgumentException("Invalid operation: $operation")
        }
    }

    private fun parseConstantExpression(): Int {
        // Check if it's a negative constant
        val isNegative = if (peek() == '-') {
            index++
            true
        } else {
            false
        }

        // Parse the number
        var num = 0
        while (index < input.length && input[index].isDigit()) {
            num = num * 10 + (input[index] - '0')
            index++
        }

        return if (isNegative) -num else num
    }

    private fun peek(): Char {
        return if (index < input.length) {
            input[index]
        } else {
            ' '
        }
    }
}

fun main() {
    val parser = ArithmeticParser()

//    this is just a mnual test, more test can be done by running the ArithmeticParserTest class and all of its methods
    val result = parser.parse("((3+4)*2)")
    println("Result: $result")
}
