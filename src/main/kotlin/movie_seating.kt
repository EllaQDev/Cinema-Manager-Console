/* first assignment = make this seating chart print out to console
Cinema:
  1 2 3 4 5 6 7 8
1 S S S S S S S S
2 S S S S S S S S
3 S S S S S S S S
4 S S S S S S S S
5 S S S S S S S S
6 S S S S S S S S
7 S S S S S S S S

 */

//second assignment: Objectives
//In this stage, you need to read two positive integer numbers from the input:
// the number of rows and the number of seats in each row. The ticket price is
// determined by the following rules:
//
//If the total number of seats in the screen room is not more than 60,
// then the price of each ticket is 10 dollars.
//In a larger room, the tickets are 10 dollars for the front half of the
// rows and 8 dollars for the back half. Please note that the number of rows can be odd,
// for example, 9 rows. In this case, the first half is the first 4 rows,
// and the second half is the rest 5 rows.
//Calculate the profit from the sold tickets depending on the number of seats
// and print the result as shown in the examples below.
// After that, your program should stop. Note that in this project,
// the number of rows and seats won't be greater than 9.
//
//Examples
//The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.
//
//Example 1
//
//Enter the number of rows:
//> 4
//Enter the number of seats in each row:
//> 5
//Total income:
//$200
//
//Example 2
//
//Enter the number of rows:
//> 8
//Enter the number of seats in each row:
//> 9
//Total income:
//$648
//
//Example 3
//
//Enter the number of rows:
//> 9
//Enter the number of seats in each row:
//> 7
//Total income:
//$560
fun main() {
    val rows = 1..7
    val columns = 1..8
    //print Cinema title
    println("Cinema:")

    println(columns.joinToString(separator = " ", prefix = "  "))
    for (n in rows) {
        print(n)
        repeat(8) {
            print(" S")
        }
        println()
    }

    //prompt user for # rows and receive input
    println("Enter the number of rows:")
    val numRows = readln().toInt()
    //prompt user for # columns and receive input
    println("Enter the number of seats in each row:")
    val numCol = readln().toInt()
    //label for income
    print("Total income:\n$")
    val totalSeats = numRows * numCol
    //conditional calculation of total income
    if (totalSeats <= 60) {
        print(totalSeats * 10)
    } else {
        val numPremiumRows = numRows/2
        val numReducedRows = numRows - numPremiumRows
        print(numPremiumRows * 10 * numCol + numReducedRows * 8 * numCol)
    }
}