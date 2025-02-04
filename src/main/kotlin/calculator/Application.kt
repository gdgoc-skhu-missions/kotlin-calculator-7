package calculator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()
    

}

fun basicSplit(a : String) : List<String>{
    return a.split(',',':')
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

