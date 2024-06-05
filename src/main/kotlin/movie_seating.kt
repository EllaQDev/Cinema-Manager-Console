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

fun main() {
    val rows = 1..7
    val columns = 1..8
    //print Cinema title
    println("Cinema")

    println(columns.joinToString(separator = " ", prefix = "  "))
    for (n in rows) {
        print(n)
        repeat(8) {
            print(" S")
        }
        println()
    }

}