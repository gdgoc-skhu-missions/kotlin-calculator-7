package calculator

import kotlin.text.toRegex

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()

    if(num == " " || num == ""){
        zeroReturn()
    }

    var numList = mutableListOf<Int>().
    var isCoustom = identifySign(num)
    if(isCoustom){
        val sign = extractSign(num)
        var splitList = customSplit(num, sign)
        var intList = stringToInt(splitList)
        numList.add(defineInt(intList))
        
    }
    else{
       var splitList = basicSplit(num)
       var intList = stringToInt(splitList)
       numList.add(stringToInt(splitList)) 
    }
    val  result =  sum(numList)

    print("결과값은 : ${result}")
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

// fun extractSign(a : String) : Char {

fun extractSign(a : String) :  { 
    if(a.slice(3..5).equals("\n"))  {
        return undefineSign()
    } 
    val sign = a.slice(2..3).first()
    if(sign.equals(" ")){
        return undefineSign()
    }
    return sign
}

fun stringToInt(a : List<String>) : List<Int> {
    var numList = mutableListOf<Int>()
    for(i in a) {=
        var k = i.toInt()
        numList.add(k)
    }
    return numList
}
fun defineInt(a:List<Int>){
    for(i in a){
        if(i <= 0 ){
        return inputnotPositive()
        }
    }
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

fun incorrectSign(){
        throw IllegalArgumentException("구분자와 양수가 아닌 문자가 입력되었습니다.")
}
fun undefineSign(){
        throw IllegalArgumentException(" //와\n사이에 커스텀 구분자를 정의하지 않았습니다.")
}

  