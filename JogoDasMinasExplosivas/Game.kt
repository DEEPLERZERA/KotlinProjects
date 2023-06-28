package minesweeper

import kotlin.random.Random

const val COLUMNS = 9
const val ROWS = 9

val field = MutableList(ROWS) {
    MutableList(COLUMNS) { '.' }
}

fun Char.isMine() = this == 'X'

fun placeMine(
    row: Int = Random.nextInt(ROWS),
    column: Int = Random.nextInt(COLUMNS)
) {
    if (field[row][column].isMine()) {
        placeMine()
    } else {
        field[row][column] = 'X'
    }
}

fun onNonMineCell(
    block: (r: Int, c: Int) -> Unit
) {
    repeat(ROWS) { r ->
        repeat(COLUMNS) { c ->
            if (!field[r][c].isMine()) {
                block(r, c)
            }
        }
    }
}

fun calculateNeighbors() = onNonMineCell { r, c ->
    var count = 0
    for (nr in r - 1..r + 1) {
        for (nc in c - 1..c + 1) {
            if (nr >= 0 && nr < ROWS &&
                    nc >= 0 && nc < COLUMNS &&
                    !(nr == r && nc == c) &&
                    field[nr][nc].isMine()) {
                        count++
            }
        }
    }
    if (count != 0) field[r][c] = '0' + count
}

fun List<Char>.print() = map { cell ->
    when(cell) {
        'W', 'R' -> '*' // marked mine
        'X' -> '.' // hide mine
        else -> cell
    }
}.joinToString("")

fun printField() {
    // │123456789│
    //—│—————————│
    //9│.1.......│
    //—│—————————│
    print(" |")
    repeat(COLUMNS) { c -> print(c + 1) }
    print("|\n—|—————————|\n")
    repeat(ROWS) { r ->
        println("${r + 1}|${field[r].print()}|")
    }
    print("—|—————————|")
}

fun setupGame() {
    println("How many mines do you want on the field?")
    val mines = readln().toInt()
    repeat(mines) { placeMine() }
    calculateNeighbors()
    printField()
}

fun markMine(row: Int, column: Int) {
    field[row][column] = when(field[row][column]) {
        in '1'..'8' -> {
            println("There is a number here!")
            return
        }
        'W' -> '.' // unmark wrongly marked mine
        'R' -> 'X' // unmark rightly marked mine
        '.' -> 'W' // mark wrongly marked mine
        'X' -> 'R' // mark rightly marked mine
        else -> throw IllegalStateException()
    }
    printField()
}

fun gameIsFinished() = !field.any { row ->
    row.any { cell -> cell == 'X' || cell == 'W' }
}

fun markMines() {
    while(!gameIsFinished()) {
        println("Set/delete mines marks (x and y coordinates):")
        val (x, y) = readln()
            .split(" ")
            .map { it.toInt() - 1 }
        markMine(row = y, column = x)
    }
}

fun main() {
    setupGame()
    markMines()
    println("Congratulations! You found all the mines!")
}