class ParkingLot {
    private val parkingSpots = Array<Pair<String, String>?>(2) { null }

    fun park(registrationNumber: String, color: String) {
        val spot = parkingSpots.indexOfFirst { it == null }
        if (spot != -1) {
            parkingSpots[spot] = Pair(registrationNumber, color)
            println("$color car parked in spot ${spot + 1}.")
        } else {
            println("No available spots.")
        }
    }

    fun leave(spotNumber: Int) {
        if (spotNumber in 1..parkingSpots.size) {
            val spotIndex = spotNumber - 1
            val car = parkingSpots[spotIndex]
            if (car != null) {
                parkingSpots[spotIndex] = null
                println("Spot $spotNumber is free.")
            } else {
                println("There is no car in spot $spotNumber.")
            }
        } else {
            println("Invalid spot number.")
        }
    }
}

fun main() {
    val parkingLot = ParkingLot()

    while (true) {
        val input = readLine() ?: break
        val command = input.split(" ")

        when (command[0]) {
            "park" -> {
                val registrationNumber = command[1]
                val color = command[2]
                parkingLot.park(registrationNumber, color)
            }
            "leave" -> {
                val spotNumber = command[1].toIntOrNull()
                if (spotNumber != null) {
                    parkingLot.leave(spotNumber)
                } else {
                    println("Invalid spot number.")
                }
            }
            else -> println("Invalid command.")
        }
    }
}
