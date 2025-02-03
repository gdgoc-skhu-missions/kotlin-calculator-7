package calculator

fun main() {
    print("덧셈할 문자열을 입력해 주세요.")
    var num = readLine().toString()
    if(identifySign==true){

    }
    else {
        val list1 = mutableListOf<Int>()
        list1 = basicSplit(num)
    }

    sum()
}

fun basicSplit(a : String) : List<Int>{
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