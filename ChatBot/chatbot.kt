package bot

import java.util.Scanner


val scanner = Scanner(System.`in`) 
fun main() {
    greet("Aid", "2020") 
    remindName()
    guessAge()
    count()
    test()
    end()
}

fun greet(assistantName: String, birthYear: String) {
    println("Hello! My name is ${assistantName}.")
    println("I was created in ${birthYear}.")
    println("Please, remind me your name.")
}

fun remindName() {
    val name = scanner.nextLine()
    println("What a great name you have, ${name}!")
}

fun guessAge() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    val rem3 = scanner.nextInt()
    val rem5 = scanner.nextInt()
    val rem7 = scanner.nextInt()
    val age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105
    println("Your age is ${age}; that's a good time to start programming!")
}

fun count() {
    println("Now I will prove to you that I can count to any number you want.")
    val num = scanner.nextInt()
    for (i in 0..num) {
        print(i)
        println("!")
    }
}

fun test() {
    println("Let's test your programming knowledge.")
    println("Why do we use while loop in some cases?")
    println("1. To run against a turtle")
    println("2. To make some hotdogs")
    println("3. To achieve a certain goal, after a certain time")
    println("4. To reach a certain goal immediately")
    var choice = 0
    var correct = 3
    var guessed = false

    while(!guessed) {
        choice = scanner.nextInt()
        if(choice == correct) {
            guessed = true
        }else {
            println("Please, try again.")
        }
      }
}


fun end() {
    println("Congratulations, have a nice day!") 
}
