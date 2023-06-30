package indigo

fun main() {
    val classification = listOf("A", 2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K")
    val naipe = listOf("♦", "♥", "♠", "♣")
    val cards = listOf(
    "A♠", "2♠", "3♠", "4♠", "5♠", "6♠", "7♠", "8♠", "9♠", "10♠", "J♠", "Q♠", "K♠",
    "A♥", "2♥", "3♥", "4♥", "5♥", "6♥", "7♥", "8♥", "9♥", "10♥", "J♥", "Q♥", "K♥",
    "A♦", "2♦", "3♦", "4♦", "5♦", "6♦", "7♦", "8♦", "9♦", "10♦", "J♦", "Q♦", "K♦",
    "A♣", "2♣", "3♣", "4♣", "5♣", "6♣", "7♣", "8♣", "9♣", "10♣", "J♣", "Q♣", "K♣")

    for (c in classification) {
        print("$c ")
    }

    println()

    for (n in naipe) {
        print("$n ")
    }

    println()
    
    for (c in cards) {
        print("$c ")
    }
}