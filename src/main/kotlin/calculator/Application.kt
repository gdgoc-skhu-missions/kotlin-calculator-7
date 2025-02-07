package calculator


fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine()!!

// 0 일때 처리
    if (num == " " || num == "") {
        getResult(zeroReturn())
        return
    }
// 숫자 리스트 변수 선언
    var numList = mutableListOf<Int>()
    // 커스텀 된 숫자 (커스텀 문자가 들어있는지 확인하기 위한 변수 선언)
    var isCustom = identifySign(num)
    // 만약 커스텀문자가 있으면
    if (isCustom) {
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

// 0을 리턴하는 함수
fun zeroReturn(): Int {
    return 0;
}
// 커스텀 구분자가 있는지 확인하는 함수
fun identifySign(a: String): Boolean {
    val slash = a.first()
    if (slash.equals("/")) {
        return true
    }
    return false
}
// 기본 구분자를 나누는 함수
fun basicSplit(a: String): List<String> {
    return a.split(',', ':')
}
// 커스텀 구분자를 나누는 함수
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
// 더하는 함수
fun sum(a: List<Int>): Int {
    var result = 0
    for (i in a) {
        result += i
    }
    return result
}
// 결과값 출력하는 함수
fun getResult(
    result: Int
) {
    print("결과값은 : ${result} 입니다.")

}
