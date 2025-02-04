package calculator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()
}

fun basicSplit(a : String) : List<String>{
    return a.split(',',':')
}

fun customSplit(a : String, sign : Char) : List<String>{
    var b = a.slice(5..a.length)
    return a.split(sign)
}

fun identifySign(a : String) : Boolean {
    if(a.first=="/")
     return true
}

fun sum(a : List<Int>) : Int {
    var result = 0
    for(i in a) {
        result += i
    }
    return result
}
