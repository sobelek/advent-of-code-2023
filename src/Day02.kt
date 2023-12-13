fun main() {
    fun part1(input: List<String>): Int {
       var digArray = mutableListOf<Int>()

        for (puzzle in input){
            var filtered = puzzle.filter { it.isDigit()}
            var result = filtered.first().toString() + filtered.last().toString()
            digArray.add(result.toInt())
        }

        return digArray.sum()
    }

    fun solution(input: List<String>): Int {
        val map = (1..9).associateBy { it.toString() } + mapOf(
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9,
        )
        return input.sumOf { row ->
            val (_, firstDigit) = map
                .map { (key, value) -> row.indexOf(key) to value }
                .filter { (key) -> key != -1 }
                .minBy { (key) -> key }
            var (_, lastDigit) = map
                .map { (key, value) -> row.lastIndexOf(key) to value }
                .filter { (key) -> key != -1 }
                .maxBy { (key) -> key }

            "$firstDigit$lastDigit".toInt()
        }
    }
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println(part2(testInput))
    check(part2(testInput) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
