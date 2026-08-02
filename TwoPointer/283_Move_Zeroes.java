/*
Problem:
283. Move Zeroes

Difficulty:
Easy

Topic:
Array, Two Pointers

Approach:
1)Initialize a pointer `count` to 0. It represents the position where the next non-zero element should be placed.
2)Traverse the array from left to right.
3)For each non-zero element:
    Swap it with the element at index `count`.
    Increment `count`.
4)After the traversal, all non-zero elements are at the beginning in their original order,
   and all zeros are automatically shifted to the end.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/move-zeroes/
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        // Position to place the next non-zero element
        int count = 0;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // If current element is non-zero
            if (nums[i] != 0) {

                // Swap current element with the element at 'count'
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;

                // Move to the next position
                count++;
            }
        }
    }
}