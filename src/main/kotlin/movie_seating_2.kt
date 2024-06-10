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
                "3. Statistics\n" +
                "0. Exit")
        val input = readln().toInt()
        when (input) {
            0 -> break
            1 -> printSeatingPlan(seatingChart)
            2 -> purchaseTicket(seatingChart)
            3 -> showStatistics(seatingChart)
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
    val seatsPerRow = plan.first().size
    val totalSeats = plan.size * seatsPerRow
    val numPremiumRows = plan.size/2
    var row : Int?
    var seat : Int?
    while(true) {
        println("Enter a row number:")
        row = readln().toInt()
        println("Enter a seat number in that row:")
        seat = readln().toInt()
        if (row in 1..plan.size && seat in 1..seatsPerRow){
            if (plan[row-1][seat-1] != "B"){
                plan[row-1][seat-1] = "B"
                break
            } else {
                println("That ticket has already been purchased!")
            }
        } else {
            println("Wrong input!")
            continue
        }
    }
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
// Print following --
// The number of purchased tickets;
//The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
//Current income;
//The total income that shows how much money the theatre will get if all the tickets are sold.
fun showStatistics(plan: List<MutableList<String>>){
    val seatsPerRow = plan.first().size
    val totalSeats = plan.size * seatsPerRow
    val numPremiumRows = plan.size/2
    val numDiscountRows = plan.size - numPremiumRows
    // # purchased tickets are marked "B" in plan
    val sold = plan.flatten().count { it == "B"}
    println("Number of purchased tickets: $sold")
    // % purchased tickets
    println("Percentage: ${java.text.DecimalFormat("#,##0.00").format(sold / totalSeats.toDouble())}%")
    // current income
    if (totalSeats <= 60) {
        println(sold * 10)
    } else {
        var income = 0
        for ((i,row) in plan.withIndex()) {
            if (i in 1..numPremiumRows){
                income += (row.count { it == "B" }) * 10
            } else {
                income += (row.count { it == "B" }) * 8
            }
        }
        println("Current income: $$income")
    }
    //total potential income calculation
    if (totalSeats <= 60) {
        println("Total income: $${totalSeats * 60}")
    } else {
        var totalIncome = 0
        //add all premium seats
        for (n in 1..numPremiumRows) {
            totalIncome += 10 * seatsPerRow
        }
        for (n in 1..numDiscountRows) {
            totalIncome += 8 * seatsPerRow
        }
        println("Total income: $$totalIncome")

    }
}