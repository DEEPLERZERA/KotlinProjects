package minesweeper

import kotlin.random.Random

fun main() {
    print("Quantas minas você quer que tenha no campo?: ")
    val numMinas = readLine()!!.toInt()
    var quantMinas = 0
    
    val campo = Array(9) { CharArray(9) { '.' } } // Inicializa o campo vazio
    
    // Coloca as minas aleatoriamente no campo
    while (quantMinas < numMinas) {
        val fila = Random.nextInt(9)
        val coluna = Random.nextInt(9)
        if (campo[fila][coluna] != 'X') {
            campo[fila][coluna] = 'X'
            quantMinas++
        }
    }
    
    // Preenche o campo com o número de minas ao redor das células vazias
    for (i in 0 until campo.size) {
        for (j in 0 until campo[i].size) {
            if (campo[i][j] == '.') {
                val numMinasAoRedor = contarMinasAoRedor(campo, i, j)
                if (numMinasAoRedor > 0) {
                    campo[i][j] = numMinasAoRedor.toString()[0]
                }
            }
        }
    }
    
    // Imprime o campo
    for (linha in campo) {
        println(linha.joinToString(""))
    }
}

// Função auxiliar para contar o número de minas ao redor de uma célula
fun contarMinasAoRedor(campo: Array<CharArray>, fila: Int, coluna: Int): Int {
    var count = 0
    val minFila = maxOf(0, fila - 1)
    val maxFila = minOf(fila + 1, campo.size - 1)
    val minColuna = maxOf(0, coluna - 1)
    val maxColuna = minOf(coluna + 1, campo[fila].size - 1)
    
    for (i in minFila..maxFila) {
        for (j in minColuna..maxColuna) {
            if (campo[i][j] == 'X') {
                count++
            }
        }
    }
    
    return count
}
