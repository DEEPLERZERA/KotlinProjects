package minesweepernumMinemi

import kotlin.random.Random

fun main() {
    val campo = Array(9) { Array(9) { '.' } }

    print("Quantas minas você quer que tenha no campo?: ")
    val numMinas = readLine()?.toIntOrNull()

    if (numMinas != null && numMinas in 0..81) {
        var minaCount = 0

        while (minaCount < numMinas) {
            val fila = Random.nextInt(9)
            val coluna = Random.nextInt(9)

            if (campo[fila][coluna] != 'X') {
                campo[fila][coluna] = 'X'
                minaCount++
            }
        }

        for (fila in campo) {
            println(fila.joinToString(""))
        }
    } else {
        println("Número invalido de minas")
    }
}
