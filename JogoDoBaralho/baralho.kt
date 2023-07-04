import kotlin.random.Random

fun main() {
    var cards = listOf(
        "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠",
        "A♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
        "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦",
        "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣"
    )
    
    while (true) {
        println("Choose an action (reset, shuffle, get, exit): ")
        var option = readln() // Lê a opção escolhida pelo usuário

        when (option) {
            "reset" -> {
                cards = listOf(
                    "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠",
                    "A♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
                    "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦",
                    "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣"
                ) 
                println("Card deck is reset.")
            }

            "shuffle" -> {
                cards = cards.shuffled(Random) // Embaralha as cartas
                println("Card deck is shuffled.")
            }

            "get" -> {
                println("Number of cards:")
                var number = readln().toInt() // Lê o número de cartas a serem retiradas

                if (number in 1..52) { // Verifica se o número está dentro do intervalo válido
                    if (number > cards.size) {
                        println("The remaining cards are insufficient to meet the request.")
                    } else {
                        val drawnCards = cards.take(number) // Obtém as cartas do topo do baralho
                        cards = cards.drop(number) // Remove as cartas do baralho
                        println("${drawnCards.joinToString(" ")}") // Imprime as cartas retiradas
                    }
                } else {
                    println("Invalid number of cards.")
                }
            }
            
            "exit" -> {
                println("bye")
                return // Encerra o programa
            }

            else -> {
                println("Wrong action.")
            }
        }
    }
}
