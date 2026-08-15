/*
Problem:
51. N-Queens

Difficulty:
Hard

Topic:
Backtracking, Recursion, Array

Approach:

1. Create a `result` list:

   - Stores all valid arrangements of the queens.

2. Represent the chessboard using a 2D `char` array:

   - `'.'` represents an empty cell.
   - `'Q'` represents a queen.

3. Start placing queens row by row using the `helper()` function.

4. For every row:

   - Try placing a queen in every column.
   - Before placing the queen, call `isSafe()`.

5. `isSafe(board, row, col)` checks whether the current
   position is safe.

   It checks three directions:

   - Same column:
     - Check all rows above the current row.

   - Upper-left diagonal:
     - Move row upward and column to the left.

   - Upper-right diagonal:
     - Move row upward and column to the right.

   If a queen is found in any of these directions,
   return `false`.

   Otherwise, return `true`.

6. If the position is safe:

   - Place the queen:
     `board[row][col] = 'Q'`

   - Recursively move to the next row:
     `helper(board, row + 1)`

7. After the recursive call:

   - Remove the queen:
     `board[row][col] = '.'`

   This is called BACKTRACKING.

   It allows us to try another column for the current row.

8. Base Case:

   - If `row == board.length`, it means queens have been
     successfully placed in all rows.
   - Convert the board into a list of strings.
   - Add that arrangement to `result`.

9. Finally, return `result`.

Why does this work?

We place exactly one queen in each row.

Before placing a queen, we check whether it conflicts with
any queen already placed in the previous rows.

Since we only place a queen when it is safe, every completed
board is a valid N-Queens solution.

When a choice leads to no solution, we remove the queen and
try another column. This process is called backtracking.

Example for n = 4:

. Q . .
. . . Q
Q . . .
. . Q .

This is one valid arrangement because no two queens share
the same row, column, or diagonal.


Time Complexity:
O(N!)

- We try different column positions for each row.
- Backtracking reduces many invalid possibilities early.
- The exact complexity is often described as O(N!) for the
  standard backtracking solution, ignoring the cost of
  checking safety and copying each solution.

Space Complexity:
O(N^2)

- `board` requires O(N^2) space.
- Recursion uses O(N) stack space.
- `result` additionally stores all valid solutions.

LeetCode:
https://leetcode.com/problems/n-queens/
*/

class Solution {

    // Stores all valid N-Queens arrangements
    List<List<String>> result = new ArrayList<>();

    /*
     * Checks whether a queen can be safely placed
     * at board[row][col].
     */
    private boolean isSafe(char[][] board, int row, int col) {

        // Check the same column
        for (int i = row - 1; i >= 0; i--) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // No queen is attacking this position
        return true;
    }

    /*
     * Recursively places queens row by row.
     */
    private void helper(char[][] board, int row) {

        // All queens have been successfully placed
        if (row == board.length) {
            addResult(board);
            return;
        }

        // Try every column in the current row
        for (int i = 0; i < board.length; i++) {

            // Place queen only if the position is safe
            if (isSafe(board, row, i)) {

                // Choose
                board[row][i] = 'Q';

                // Explore
                helper(board, row + 1);

                // Backtrack
                board[row][i] = '.';
            }
        }
    }

    /*
     * Converts the current board into a list of strings
     * and stores it in the result.
     */
    private void addResult(char[][] board) {

        List<String> list = new ArrayList<>();

        for (char[] row : board) {
            list.add(new String(row));
        }

        result.add(list);
    }

    public List<List<String>> solveNQueens(int n) {

        // Create an n x n chessboard
        char[][] board = new char[n][n];

        // Initialize every cell with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Start placing queens from row 0
        helper(board, 0);

        // Return all valid arrangements
        return result;
    }
}