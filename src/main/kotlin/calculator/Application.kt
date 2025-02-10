package calculator

const val ZERO: Int = 0

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine()!!


    if (num.isBlank()) {
        getResult(ZERO)
        return
    }


    var numList = mutableListOf<Int>()

    val result = getCustomSign(num)

    if (result.isNullOrBlank()) {
        val splitList = basicSplit(num)
        var intList = stringToInt(splitList)
        numList.addAll(defineInt(intList))

    }

    if (result!!.isNotBlank()) {
        if (!num.contains("\\n")) {
            incorrectSign()
        }

        print(result) // result = d
        val splitList = customSplit(num, result) // 여기서 오류가 나네
        val intList = stringToInt(splitList)
        numList.addAll(defineInt(intList))
    }

    val result1 = sum(numList)
    print(getResult(result1))

}


// 기본 구분자를 나누는 함수
fun basicSplit(a: String): List<String> {
    return a.split(',', ':')
}

// 커스텀 구분자를 나누는 함수
fun customSplit(a: String, sign: String): List<String> {
    if (!a.contains(sign)) {
        incorrectSign()
    }
    val b = a.substringAfter("\\n")
    print("\n 숫자부분 : $b\n")
    return b.split(sign)
}


// 스트링을 숫자로 바꿔주는 함수
fun stringToInt(a: List<String>): List<Int> {
    var numList = mutableListOf<Int>()
    for (i in a) {
        var k = i.toInt()
        numList.add(k)
    }
    return numList
}

// 양수가 아닌지 검수하는 함수
fun defineInt(a: List<Int>): List<Int> {
    for (i in a) {
        if (i <= 0) {
            inputNotPositive()
        }
    }
    return a
}

fun getCustomSign(input: String): String? {
    val regex = Regex("^//(.+)\\\\n")
    val matchResult = regex.find(input)
    if (matchResult == null) {
        undefineSign()
    }
    return matchResult?.groupValues?.get(1) // "//"와 "\n" 사이의 문자열 그대로 반환
}



fun sum(a: List<Int>): Int {
    var result = 0
    for (i in a) {
        result += i
    }
    return result
}


fun getResult(
    result: Int
) {
    print("결과 : ${result}")

}


fun inputNotPositive() {
    throw IllegalArgumentException("입력값이 양수가 아닙니다. ")
}

fun incorrectSign() {
    throw IllegalArgumentException("구분자와 양수가 아닌 문자가 입력되었습니다.")
}

fun undefineSign() {
    throw IllegalArgumentException("//와\n사이에 커스텀 구분자를 정의하지 않았습니다.")
}
