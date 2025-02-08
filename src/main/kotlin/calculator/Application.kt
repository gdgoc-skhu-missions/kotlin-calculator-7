package calculator

import kotlin.text.toRegex
import calculator.defineInt

const val ZERO = 0

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine()

    if (num.isNullOrBlank()) {
        getResult(ZERO)
        return
    }

    var numList = mutableListOf<Int>()
    var isCoustom = identifySign(num)
    if (isCoustom) {
        val sign = extractSign(num)
        var splitList = customSplit(num, sign)
        var intList = stringToInt(splitList)

        numList.addAll(defineInt(intList))

    } else {
        var splitList = basicSplit(num)
        var intList = stringToInt(splitList)
        numList.addAll(defineInt(intList))
    }
    val result = sum(numList)

    print("결과: ${result}")
}

// 예외처리 부분 
fun inputNotPositive() {
    throw IllegalArgumentException("입력값이 양수가 아닙니다.")
}

fun incorrectSign() {
    throw IllegalArgumentException("구분자와 양수가 아닌 문자가 입력되었습니다.")
}

fun undefineSign() {
    throw IllegalArgumentException("커스텀 구분자를 잘못 정의하였습니다")
}

fun identifySign(a: String): Boolean {
    val slash = a.first()
    return slash == '/'
}

fun basicSplit(a: String): List<String> {
    return a.split(',', ':')
}

fun customSplit(a: String, sign: Char): List<String> {
    val b = a.slice(5..a.length - 1)
    return b.split(sign)
}

fun extractSign(a: String): Char {
    val regex = Regex("^//[0-9\\s]\\\\n.*")
    if (regex.matches(a)) {
        undefineSign()
    }
    val sign = a.slice(2..3).first()
    return sign
}

fun stringToInt(a: List<String>): List<Int> {
    var numList = mutableListOf<Int>()
    for (i in a) {
        try {
            var k = i.toInt()
            numList.add(k)
        } catch (e: NumberFormatException) {
            incorrectSign()
        }
    }
    return numList
}

fun defineInt(a: List<Int>): List<Int> {
    for (i in a) {
        if (i <= 0) {
            inputNotPositive()
        }
    }
    return a
}

fun sum(a: List<Int>): Int = a.sum()

fun getResult(result: Int) {
    print("결과 : ${result}")
}
  