package cinema

fun main() { //Declarando funçao principal
    println("Enter the number of rows:") //Imprimindo na tela
    val rows = readLine()!!.toInt() //Lendo o numero de linhas
    println("Enter the number of seats in each row:") 
    val seats = readLine()!!.toInt() //Lendo o numero de assentos
    val cinema = Array(rows) { Array(seats) { "S" } } //Criando o array cinema com o numero de linhas e assentos
    val totalSeats = rows * seats
    var ticketPrice = 0
    var exit = false
    var purchasedTickets = 0
    var currentIncome = 0
 
    fun printCinema() { //Declarando funçao para imprimir o cinema
        val rows = cinema.size 
        val seats = cinema[0].size

        print(" ")
        for (i in 1..seats) { //Imprimindo o numero de assentos
            print(" $i") 
        }
        println()

        for (i in 0 until rows) { //Imprimindo o numero de linhas
            print(i + 1)
            for (j in 0 until seats) { //Imprimindo os assentos
                print(" ${cinema[i][j]}") 
            }
            println()
        }
    }

    while (!exit) { //Loop para o menu
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val choice = readLine()!!.toInt() //Lendo a escolha do usuario

        when (choice) { 
            1 -> { //Imprimindo o cinema
                println("Cinema:")
                printCinema()
            }
            2 -> { //Comprando um ingresso
                println("Enter a row number:")
                var chosenRow = readLine()!!.toInt()
                println("Enter a seat number in that row:")
                var chosenSeat = readLine()!!.toInt()

                while (chosenRow < 1 || chosenRow > rows || chosenSeat < 1 || chosenSeat > seats) { //Verificando se o usuario digitou um numero valido
                    println("Wrong input!")
                    println("Enter a row number:")
                    chosenRow = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    chosenSeat = readLine()!!.toInt()
                }

                while(cinema[chosenRow - 1][chosenSeat - 1] == "B") { //Verificando se o assento ja foi comprado
                    println("That ticket has already been purchased!")
                    println("Enter a row number:")
                    chosenRow = readLine()!!.toInt()
                    println("Enter a seat number in that row:")
                    chosenSeat = readLine()!!.toInt()
                }

                val frontHalfRows = rows / 2 //Calculando o numero de linhas da frente
                val backHalfRows = rows - frontHalfRows //Calculando o numero de linhas de tras

                if (totalSeats <= 60 || chosenRow <= frontHalfRows) { //Calculando o preço do ingresso
                    ticketPrice = 10
                } else {
                    ticketPrice = 8
                }

                cinema[chosenRow - 1][chosenSeat - 1] = "B" //Marcando o assento como comprado

                println("Ticket price: $$ticketPrice")
                purchasedTickets++
                currentIncome += ticketPrice
            }
            3 -> { //Imprimindo as estatisticas
                val percentage = purchasedTickets.toDouble() / totalSeats * 100
                val formatPercentage = "%.2f".format(percentage)
                val frontHalfRows = rows / 2
                val backHalfRows = rows - frontHalfRows
                var totalIncome = 0
                if (totalSeats <= 60) {
                    totalIncome = totalSeats * 10
                }
                else {
                    totalIncome = frontHalfRows * seats * 10 + backHalfRows * seats * 8 
                }
                println("Number of purchased tickets: $purchasedTickets")
                println("Percentage: $formatPercentage%")
                println("Current income: $$currentIncome")
                println("Total income: $$totalIncome")
            }
            0 -> {
                exit = true
            }
            else -> {
                println("Invalid choice!")
            }
        }
    }
}
