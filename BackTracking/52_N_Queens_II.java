/*
Problem:
52. N-Queens II

Difficulty:
Hard

Topic:
Backtracking, Recursion, Array

Approach:

1. Create a static variable `cnt`:

   - Stores the total number of valid N-Queens solutions.

2. Create a 2D `char` array called `board`:

   - Represents the chessboard.
   - `'Q'` represents a queen.
   - Empty cells are represented by `'\0'` initially.
   - After backtracking, we set the cell back to `'x'`.

3. Start placing queens row by row using the `helper()` function.

4. For every row:

   - Try placing a queen in every column.
   - Before placing the queen, call `isSafe()`.

5. `isSafe(board, row, col)` checks three directions:

   - Same column:
     - Check all rows above the current row.

   - Upper-left diagonal:
     - Move upward and to the left.

   - Upper-right diagonal:
     - Move upward and to the right.

   If a queen is found in any of these directions:

   - Return `false`.

   Otherwise:

   - Return `true`.

6. If the position is safe:

   - Place the queen:
     `board[row][i] = 'Q'`

   - Recursively move to the next row:
     `helper(board, row + 1)`

7. After returning from recursion:

   - Remove the queen:
     `board[row][i] = 'x'`

   This is called BACKTRACKING.

8. Base Case:

   - If `row == board.length`, it means queens have been
     successfully placed in all rows.
   - Increase `cnt` by 1.
   - Return.

9. Unlike N-Queens I:

   - We do NOT need to store the actual boards.
   - We only need the number of valid solutions.
   - Therefore, we simply increment `cnt`.

10. In `totalNQueens()`:

   - Reset `cnt = 0`.
   - Create the chessboard.
   - Start backtracking from row 0.
   - Return `cnt`.

Why does this work?

The algorithm places exactly one queen in every row.

Before placing a queen, `isSafe()` checks whether another
queen is attacking that position.

If a valid position is found, we continue to the next row.

If all N rows are completed, we have found one valid solution,
so we increase `cnt`.

After exploring that choice, we remove the queen and try
another column.

This allows us to explore every possible valid arrangement
without storing the arrangements themselves.


Important Difference Between N-Queens I and N-Queens II:

N-Queens I:
- Stores and returns all valid board arrangements.
- Uses `List<List<String>> result`.

N-Queens II:
- Only counts the number of valid arrangements.
- Uses `int cnt`.

For example:

n = 4

There are 2 valid N-Queens arrangements.

N-Queens I:
- Returns both boards.

N-Queens II:
- Simply returns `2`.


Time Complexity:
O(N!)

- We try different positions for queens using backtracking.
- Invalid arrangements are stopped early by `isSafe()`.

Space Complexity:
O(N^2)

- The chessboard requires O(N^2) space.
- Recursion requires O(N) stack space.
- No result list is stored.

LeetCode:
https://leetcode.com/problems/n-queens-ii/
*/

class Solution {

    // Stores the total number of valid solutions
    static int cnt = 0;

    /*
     * Checks whether a queen can be safely placed
     * at board[row][col].
     */
    public static boolean isSafe(char[][] board, int row, int col) {

        // Check the same column
        for (int i = row - 1; i >= 0; i--) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Position is safe
        return true;
    }

    /*
     * Recursively places queens row by row.
     */
    public static void helper(char[][] board, int row) {

        // All queens have been successfully placed
        if (row == board.length) {

            // Found one valid solution
            cnt++;

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
                board[row][i] = 'x';
            }
        }
    }

    public int totalNQueens(int n) {

        // Reset count for every new input
        cnt = 0;

        // Create an n x n chessboard
        char[][] board = new char[n][n];

        // Start placing queens from row 0
        helper(board, 0);

        // Return total number of valid solutions
        return cnt;
    }
}