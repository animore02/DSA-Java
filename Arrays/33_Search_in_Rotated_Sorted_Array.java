/*
Problem:
33. Search in Rotated Sorted Array

Difficulty:
Medium

Topic:
Array, Binary Search

Approach:
1. Initialize `left` at the beginning of the array and `right` at the end.
2. Continue searching while `left <= right`.
3. Calculate the middle index using:
   `mid = left + (right - left) / 2`
4. If `nums[mid]` is equal to the target:
   - Return `mid`.
5. Determine which half of the array is sorted:
   - If `nums[left] <= nums[mid]`, the left half is sorted.
   - Otherwise, the right half is sorted.
6. If the left half is sorted:
   - Check whether the target lies within the sorted left half.
   - If yes, search the left half by moving `right`.
   - Otherwise, search the right half by moving `left`.
7. If the right half is sorted:
   - Check whether the target lies within the sorted right half.
   - If yes, search the right half by moving `left`.
   - Otherwise, search the left half by moving `right`.
8. If the target is not found, return `-1`.

Time Complexity:
O(log n)

Space Complexity:
O(1)

LeetCode:
[https://leetcode.com/problems/search-in-rotated-sorted-array/](https://leetcode.com/problems/search-in-rotated-sorted-array/)
*/

class Solution {

    public int search(int[] nums, int target) {

        // Initialize search boundaries
        int left = 0;
        int right = nums.length - 1;

        // Binary search
        while (left <= right) {

            // Calculate middle index
            int mid = left + (right - left) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // ==============================
            // Left half is sorted
            // ==============================

            if (nums[left] <= nums[mid]) {

                // Check if target lies in the sorted left half
                if (nums[left] <= target && target < nums[mid]) {

                    // Search in left half
                    right = mid - 1;

                } else {

                    // Search in right half
                    left = mid + 1;
                }

            }

            // ==============================
            // Right half is sorted
            // ==============================

            else {

                // Check if target lies in the sorted right half
                if (nums[mid] < target && target <= nums[right]) {

                    // Search in right half
                    left = mid + 1;

                } else {

                    // Search in left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}