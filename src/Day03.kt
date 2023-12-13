fun main() {
    fun part1(input: List<String>): Int {

        return 1
    }

    fun part2(input: List<String>): Int {
       return 2
    }
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 8)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()

}
private fun parseInput(input: List<String>) =  input.map {
        val (game, sets) = it.split(": ")
        val(_, gameId) = game.split(" ")
        val cubeSets = sets.split(";")
            .map {
                it.split(", ").map {
                    val (count, color) = it.trim().split(" ")
                    CubeSet(count.toInt(), Color.of(color))
                }

            }
        gameId.toInt() to cubeSets.flatten()
    }


data class CubeSet(val count: Int, val color: Color)

enum class Color(val value: String) {
    Red("red"),
    Green("green"),
    Blue("blue");

    companion object {

        fun of(value: String): Color {
            return values().find { it.value == value } ?: error("color $value not found")
        }
    }
}
