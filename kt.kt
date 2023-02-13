class SudokuSolver {

    // Initialize a 9x9 board with zeros
    private val board = Array(9) { IntArray(9) }

    // Function to check if the number can be placed in the given cell
    private fun isValid(row: Int, col: Int, num: Int): Boolean {
        // Check if the number is present in the current row
        for (i in 0 until 9) {
            if (board[row][i] == num) return false
        }
        // Check if the number is present in the current column
        for (i in 0 until 9) {
            if (board[i][col] == num) return false
        }
        // Check if the number is present in the current 3x3 subgrid
        val rowStart = row - row % 3
        val colStart = col - col % 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (board[i + rowStart][j + colStart] == num) return false
            }
        }
        // If the number is not present in the current row, column, or subgrid, it can be placed in the cell
        return true
    }

    // Recursive function to solve the sudoku puzzle
    fun solve(): Boolean {
        for (row in 0 until 9) {
            for (col in 0 until 9) {
                // If the cell is empty, fill it with a number
                if (board[row][col] == 0) {
                    for (num in 1..9) {
                        // Check if the number can be placed in the cell
                        if (isValid(row, col, num)) {
                            board[row][col] = num
                            // Recursively call the solve function to fill the remaining cells
                            if (solve()) return true
                            // If the number cannot be placed, backtrack and try a different number
                            board[row][col] = 0
                        }
                    }
                    // If no number can be placed, return false
                    return false
                }
            }
        }
        // If all cells are filled, the puzzle is solved
        return true
    }

    // Function to print the board
    fun printBoard() {
        for (row in board) {
            for (cell in row) {
                print("$cell ")
            }
            println()
        }
    }
}

// Main function to test the sudoku solver
fun main(args: Array<String>) {
    // Initialize the sudoku solver
    val solver = SudokuSolver()
    // Fill the board with a sample sudoku puzzle
    solver.board[0] = intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0)
    solver.board[1] = intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0)
    solver.board[2] = intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0)
    solver.board[3] = intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3)
    solver.board[4] = intArrayOf(4, 0
