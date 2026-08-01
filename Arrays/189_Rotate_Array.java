/*
Problem:
189. Rotate Array

Difficulty:
Medium

Topic:
Array, Two Pointers

Approach:
1) Find the length of the array.
2) Reduce k using modulo (k = k % n) because rotating n times gives the same array.
3) Reverse the entire array.
4) Reverse the first k elements.
5) Reverse the remaining (n - k) elements.
6) The array is now rotated to the right by k positions.

Example:
Input:
nums = [1,2,3,4,5,6,7], k = 3

Step 1: Reverse entire array
[7,6,5,4,3,2,1]

Step 2: Reverse first k elements
[5,6,7,4,3,2,1]

Step 3: Reverse remaining elements
[5,6,7,1,2,3,4]

Output:
[5,6,7,1,2,3,4]

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/rotate-array/
*/

class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Handle cases where k is greater than array length
        k %= n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse elements between two indices
    private void reverse(int[] arr, int start, int end) {

        // Continue swapping until both pointers meet
        while (start < end) {

            // Swap the elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move both pointers
            start++;
            end--;
        }
    }
}
