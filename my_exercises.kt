import javax.lang.model.type.UnionType

fun main() {
    //CHALLENGE 1
    //1.1
    val firstname = "Joe"
    if (firstname == "George") {
        val lastname = "Lucas"
    } else if (firstname == "Andrzej") {
        val lastname = "Wajda"
    }
    val fullName = firstname + " " //+ lastname
    // warunki są zawsze fałszywe, kompilator nie widzi "lastname", powinnismy dodac else lastname = ""

    //1.2
    val answer1 = true && true
    val answer2 = false || false
    val answer3 = (true && 1 != 2) || (4 > 3 && 100 < 1)
    val answer4 = ((10 / 2) > 3) && ((10 % 2) == 0)
    val answer5 = !(true && !false)
    // true =  1, 3, 4 false =  2, 5

    //zad 1.3
    fun isPowerOf2(n: Double): Boolean {
        val log = Math.log10(n)
        return log != Math.floor(log)
    }
    println(isPowerOf2(64.4))

    //zad 1.4?

    //CHALLENGE 2
    //2.1
    var sum = 0
    for (i in 0..10) {
        sum += i
    }
    // Wynik bedzie wynosil 55, zostaly dodane wszystkie liczby od 1 do 10 wlacznie

    //2.2
    // Mamy rozne zakresy 1. 0..2 to znaczy od 0 do 2 wlacznie, 5 downTo 0 czyli od 5 do 0, lub 0 until 10 gdzie 10 nie
    //jest włączone do zakresu. Mozna rowiez dodawac krok np for(i in 0..10, step 2)

    //2.3 Closed range nigdy nie bedzie pusty poniewaz zawsze zawiera skrajne liczby, nawet przy 0..0 zawiera 0

    //2.4 Roznica w switchu pomiedzy C++ a Koltlinem jest taka, ze w Kotlinie uzywamy zamiast switch slowa when,
    // zamiast case 1 wpisujemy 1-> , zamiast default piszemy else ->

    //2.5
    var countDown: Int = 10
    while(countDown >= 0){
        println(countDown)
        countDown -= 1
    }

    //CHALLENGE 3
    // 3.1
    //a) aby zadziałał program dodalam val
    fun threeMultiplication(x: Int): Int {
        val x = x * 3
        return x
    }
    println(threeMultiplication(10))
    //b) zmieniono typ danych i dodano wyjscie :Int
    fun maxValue(args: Array<Int>): Int {
        var max = args[0]
        var x = 1
        while (x < args.size) {
            var item = args[x]
            max = if (max >= item) max else item
            x += 1
        }
        return max
    }

    //c)????

    //3.2 Wkleic slowa
    //resultif(userChoice == gameChoice) result = "Tie!"
    // elseif((userChoice  ==  "Rock" && gameChoice == "Scissors") || (userChoice == "Paper" && gameChoice == "Rock")
    // || (userChoice == "Scissors" && gameChoice == "Paper"))

    //CHALLENGE 4
    //4.1 nullable variables moga zawierac wartosc lub byc puste, aby pracowac z taka wartoscia trzba najpierw
    //sprawdzic czy nie sa null (np operatorem Elvisa)
    //Nullsafety - zabieg w kodzie dzięki któremu zapobiegniemy errorom gdy mamy NULL tak gdzie nie pownno go być

    //4.2 Elvis operator to ?: np val y = x?.length ?: -1 gdy x nie jest null elvis zwraca to w innnym przypadku zwracamy -1

    //4.4 poprawne są name i middlename

    // 4.3 Jesli mamy Name?.toUpperCase() to znaczy if(name != null) name.toUpperCase else null,
    // konwertuje dowolną wartość na typ inny niż null i zgłasza wyjątek, jeśli wartość jest null.
    // Gdy x!!, a to zwróci niepustą wartość x, jeśli x jest null np:
    //val y = x!!.length

    //4.5
    fun divideIfWhole(x: Double,y:Double): Int? {
        var count:Int?=null
        var change:Double
        var new_x:Double=x
        change=x%y
        while(change==0.0)
        {
            change=new_x%y
            new_x=new_x/y
            count=count ?: 0
            count=if (change==0.0) (count+1) else count
        }
        return count
    }
    var answer:Int?=divideIfWhole(4.0,2.0)
    if (answer !=null) println("It divided $answer times") else println("Not divisible")


    // CHALLENGE 5
    //5.1
    fun removeOne(item: Int, list: List<Int>): List<Int> {
        val newListMinusElement = list - list[item]
        return newListMinusElement
    }

    val lista = mutableListOf(1, 2, 3)
    println(removeOne(0, lista))

    //5.2
    fun remove(item: Int, list: List<Int>): List<Int>{
        val new_List= list.toMutableList()
        while(new_List.contains(item)){
            new_List.remove(item)
        }
        return new_List
    }

    // 5.3
    fun reverse(array: Array<Int>): Array<Int>{
        val array_copy=array.copyOf()
        var array_it:Int

        for(i in 0 until array.size){
            array_it=array.size - i - 1
            array.set(i,array_copy[array_it])
        }
        return array
    }


    //5.4
    fun minMax(numbers: Array<Int>): Pair<Int,Int> {
        var MAX = numbers[0]
        var MIN = numbers[0]
        for (i in 0..numbers.size - 1) {
            if (numbers[i] > MAX) {
                MAX = numbers[i]

            }
            if(i in 0..numbers.size -1){
                if(numbers[i] < MIN){
                    MIN = numbers[i]
                }
            }

        }
        return Pair(MAX,MIN)
    }

    var array_1 = arrayOf(1,2,3,4,5,6)
    println(minMax(array_1))

    // CHALLENGE 6
    // 6.1
    // W lambdzie podajemy parametry czynnosc np X: Int, Y: Int -> X + Y, to funkcje anonimowe, zwracaja ostatnie wyrazenie

    //6.2 It to niejawny parametr lambdy, referencja do argumentu przy jednoargumentowych funkcji lambda

    //6.3
    fun repeatTask(times: Int, task: () -> Unit) {
        repeat(times) {
            task()
        }
    }
    var unit_hello: () -> Unit = {
        println("Hello")
    }
    repeatTask(3,unit_hello)

    //6.4
    val appRatings = mapOf(
        "Kalendarz" to arrayOf(1,5,5,4,2,1,5,4),
        "Kurier" to arrayOf(5,4,2,5,4,1,1,2),
        "Myszojelenipedia" to arrayOf(2,1,2,2,1,2,4,2))

    val averageRatings= mutableMapOf<String,Double>()

    appRatings.forEach {
            arg->averageRatings.put(arg.key,arg.value.average())
    }
    val filterRating= averageRatings.filter { it.value > 3.0 }

}