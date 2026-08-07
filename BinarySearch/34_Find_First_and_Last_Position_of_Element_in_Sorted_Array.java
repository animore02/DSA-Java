/*
Problem:
34. Find First and Last Position of Element in Sorted Array

Difficulty:
Medium

Topic:
Array, Binary Search

Approach:

1. Create an answer array of size 2.
2. Find the first occurrence of the target using Binary Search.
   - Whenever target is found:
     - Store the index.
     - Continue searching in the left half to find an earlier occurrence.
3. Find the last occurrence of the target using Binary Search.
   - Whenever target is found:
     - Store the index.
     - Continue searching in the right half to find a later occurrence.
4. Return the array containing:
   - First occurrence index.
   - Last occurrence index.
5. If the target is not present, both methods return -1.

Time Complexity:
O(log n)
- First Binary Search : O(log n)
- Second Binary Search : O(log n)
- Overall : O(log n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {

    // Main function

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];

        ans[0] = firstOccurrence(nums, target);
        ans[1] = lastOccurrence(nums, target);

        return ans;
    }

// Approach 1 : Find First Occurrence

    private int firstOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
    
        // Stores the answer if target is found
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                // Store current index
                ans = mid;

                // Continue searching on left side
                right = mid - 1;

            } else if (arr[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return ans;
    }

    // Approach 2 : Find Last Occurrence
        

    private int lastOccurrence(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        // Stores the answer if target is found
        int ans = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                // Store current index
                ans = mid;

                // Continue searching on right side
                left = mid + 1;

            } else if (arr[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return ans;
    }
}