fun main() {
    //input theatre size
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val seatingChart = List(rows){ MutableList(seats) {"S"} }

    while(true) {
        println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit")
        val input = readln().toInt()
        when (input) {
            0 -> break
            1 -> printSeatingPlan(seatingChart)
            2 -> purchaseTicket(seatingChart)
        }
    }
}

fun printSeatingPlan(plan: List<MutableList<String>>) {
    println("Cinema:")
    val seatRange = (1..plan.first().size).toList()
    print("  ")
    println(seatRange.joinToString(separator = " "))
    for ((i,row) in plan.withIndex()) {
        print("${i+1} ")
        print("${row.joinToString(separator = " ")}\n")
    }
}

fun purchaseTicket(plan: List<MutableList<String>>){
    val totalSeats = plan.size * plan.first().size
    val numPremiumRows = plan.size/2
    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val seat = readln().toInt()
    plan[row-1][seat-1] = "B"
    if (totalSeats <= 60) {
        println("Ticket price: \$10")
    } else {
        if (row in 1..numPremiumRows) {
            println("Ticket price: \$10")
        } else {
            println("Ticket price: \$8")
        }
    }
}