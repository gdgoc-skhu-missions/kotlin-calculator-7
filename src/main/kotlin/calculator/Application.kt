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

fun basicSplit(a : String) : List<String>{
    return a.split(',',':')
}

fun customSplit(a : String, sign : Char) : List<String>{
    val b = a.slice(5..a.length)
    return b.split(sign)
}

fun identifySign(a : String) : Boolean {
    val slash = a.first()
    if(slash.equals("/")){
    return true
    }
    return false
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