package calculator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()

    if(num == " " || num == ""){
        zeroReturn()
    }
}

fun zeroReturn():Int{
    return 0;
}

fun identifySign(a : String) : Boolean {
    val slash = a.first()
    if(slash.equals("/")){
    return true
    }
    return false
}

fun basicSplit(a : String) : List<String>{
    return a.split(',',':')
}

fun customSplit(a : String, sign : Char) : List<String>{
    val b = a.slice(5..a.length)
    return b.split(sign)
}

fun extractSign(a : String) : String {
    val sign = a.slice(2..3)
    return sign
}


fun stringToInt(a : List<String>) : List<Int> {
    var numList = mutableListOf<Int>()
    for(i in a) {
        var k = i.toInt()
        numList.add(k)
    }
    return numList
}

fun sum(a : List<Int>) : Int {
    var result = 0
    for(i in a) {
        result += i
    }
    return result
}

// 예외처리 부분 
fun inputnotPositive():{
    throw IllegalArgumentException("입력값이 양수가 아닙니다. ")
}

fun signNotInt(){
        throw IllegalArgumentException("계산할 숫자가 따로 없습니다.")
}
fun incorrectSign(){
        throw IllegalArgumentException("구분자와 양수가 아닌 문자가 입력되었습니다.")
}
fun undefineSign(){
        throw IllegalArgumentException(" //와\n사이에 커스텀 구분자를 정의하지 않았습니다.")
}
fun customSignNotChar(){
        throw IllegalArgumentException("커스텀 구분자가 문자가 아닙니다.")
}
  