/*
Problem:
46. Permutations

Difficulty:
Medium

Topic:
Array, Backtracking, Recursion

Approach:

1. Create an empty list `ans` to store all permutations.
2. Use a recursive helper function with:
   - `arr` → the input array.
   - `idx` → the current position we need to fill.
   - `ans` → stores all generated permutations.
3. Base Case:
   - If `idx == arr.length`, the entire array is arranged.
   - Create a new `List<Integer>`.
   - Copy all elements of `arr` into the list.
   - Add the list to `ans`.
4. Recursive Case:
   - Start a loop from `idx` to `arr.length - 1`.
5. For every position `i`:
   - Swap `arr[idx]` with `arr[i]`.
   - This places a different element at the current position.
6. Recursively call:
   - `helper(arr, idx + 1, ans)`
   - This generates permutations for the remaining positions.
7. Backtrack:
   - Swap `arr[idx]` and `arr[i]` again.
   - This restores the original array before trying the next choice.
8. After all recursive calls are completed:
   - Return `ans`.

Why do we swap?

- Swapping places each possible element at the current index.
- For example, for `[1, 2, 3]`:
  - Put `1` at index `0`
  - Put `2` at index `0`
  - Put `3` at index `0`
- Then recursively arrange the remaining elements.

Why do we backtrack?

- After generating permutations for one choice, we need to restore
  the array to its previous state.
- This allows us to try the next possible choice.

Example:

arr = [1, 2, 3]

Generated permutations:

[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 2, 1]
[3, 1, 2]

Time Complexity:
O(n × n!)

- There are `n!` permutations.
- For every permutation, we copy `n` elements into a new list.

Space Complexity:
O(n)

- `O(n)` recursion stack.
- Excluding the output list.
- Including the output, space complexity is `O(n × n!)`.

LeetCode:
https://leetcode.com/problems/permutations/
*/

class Solution {

    private void helper(int[] arr, int idx, List<List<Integer>> ans) {

        // Base case:
        // If idx reaches the end, one complete permutation is formed
        if (idx == arr.length) {

            // Create a new list for the current permutation
            List<Integer> list = new ArrayList<>();

            // Copy elements from array into the list
            for (int num : arr) {
                list.add(num);
            }

            // Add the permutation to the answer
            ans.add(list);

            return;
        }

        // Try every element from idx to the end
        for (int i = idx; i < arr.length; i++) {

            // Place arr[i] at the current index
            swap(arr, idx, i);

            // Recursively generate permutations
            // for the remaining elements
            helper(arr, idx + 1, ans);

            // Backtrack:
            // Restore the array before trying the next choice
            swap(arr, idx, i);
        }
    }

    private void swap(int[] arr, int i, int j) {

        // Store arr[i] temporarily
        int temp = arr[i];

        // Swap elements
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {

        // Store all permutations
        List<List<Integer>> ans = new ArrayList<>();

        // Start generating permutations from index 0
        helper(nums, 0, ans);

        // Return all permutations
        return ans;
    }
}