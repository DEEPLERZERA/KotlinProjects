package minesweeper

fun main() {
    for(i in 0..9)  {
        for(j in 0..9)  {
            if(i==j || i == 8 - j) {
                print("X")
            } else {
                print(".")
            }    
        }
        println()
    }
}
