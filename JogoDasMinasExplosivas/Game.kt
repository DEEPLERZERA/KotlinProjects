package minesweeper
import kotlin.random.Random

fun main() {
    print("Quantas minas você quer que tenha no campo?: ")
    var numMinas = readLine()!!.toInt()
    var quantMinas = 0
    
    for(i in 1..9)  {
        var fila = Random.nextInt(1)
        for(j in 1..9)  {
         var coluna = Random.nextInt(1)
            if(fila==coluna && quantMinas < numMinas) {
                print("X")
                quantMinas++
            } else {
                print(".")
            }    
        }
        println()
    }
}
