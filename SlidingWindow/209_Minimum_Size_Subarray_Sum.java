/*
Problem:
209. Minimum Size Subarray Sum

Difficulty:
Medium

Topic:
Array, Sliding Window

Approach:
    1. Initialize:
        - sum = 0
        - start = 0
        - min = Integer.MAX_VALUE
    2. Traverse the array using the end pointer.
    3. Add the current element to the running sum.
    4. While the sum is greater than or equal to the target:
        - Update the minimum subarray length.
        - Remove the leftmost element from the sum.
        - Move the start pointer forward.
    5. If no valid subarray is found, return 0.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/minimum-size-subarray-sum/
*/

class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}