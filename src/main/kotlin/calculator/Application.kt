package calculator

import kotlin.text.toRegex
import calculator.defineInt

const val Zero = 0

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()


    if (num.isNullOrBlank()) {
        getResult(Zero)
        return
    }

    var numList = mutableListOf<Int>()
    var isCoustom = identifySign(num)
    print(isCoustom)
    if (isCoustom) {
        val sign = extractSign(num)
        print(num.slice(5..<num.length))
        var splitList = customSplit(num.slice(5..num.length), sign)
        var intList = stringToInt(splitList)

        numList.addAll(defineInt(intList))

    } else {
        var splitList = basicSplit(num)
        var intList = stringToInt(splitList)
        numList.addAll(defineInt(intList))
    }
    val result = sum(numList)

    print("결과값은 : ${result}")
}

// 예외처리 부분 
fun inputNotPositive() {
    throw IllegalArgumentException("입력값이 양수가 아닙니다. ")
}

fun incorrectSign() {
    throw IllegalArgumentException("구분자와 양수가 아닌 문자가 입력되었습니다.")
}

fun undefineSign() {
    throw IllegalArgumentException("//와\n사이에 커스텀 구분자를 정의하지 않았습니다.")
}

fun identifySign(a: String): Boolean {
    val slash = a.first()
    if (slash.equals('/')) {
        return true
    }
    return false
}

fun basicSplit(a: String): List<String> {
    return a.split(',', ':')
}

fun customSplit(a: String, sign: Char): List<String> {
    val b = a.slice(5..a.length)
    return b.split(sign)
}


fun extractSign(a: String): Char {
    if (a.slice(3..5).equals("\n")) {
        undefineSign()
    }
    val sign = a.slice(2..3).first()
    if (sign.equals(' ')) {
        undefineSign()
    }
    return sign
}

fun stringToInt(a: List<String>): List<Int> {
    var numList = mutableListOf<Int>()
    for (i in a) {
        var k = i.toInt()
        numList.add(k)
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

fun sum(a: List<Int>): Int {
    var result = 0
    for (i in a) {
        result += i
    }
    return result
}

fun getResult(result: Int) {
    print("결과값은 : ${result} 입니다.")
}
  