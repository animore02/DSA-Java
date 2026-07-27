/*
Problem:
53. Maximum SubArray

Difficulty:
Medium

Topic:
Array, 

Approach:
   1)Iterate through the array using a variable i. During each iteration, add the current element arr[i] to a running sum variable.
   2)Keep track of the maximum sum encountered during the iteration by comparing the current sum with the previous maximum sum, and update it if the current sum is greater.
   3)If at any point the sum becomes negative, reset it to 0, as a negative sum won't contribute positively to the overall maximum sum.
   4)Continue the iteration until all elements in the array are processed.
   5)Finally, return the maximum sum encountered during the iteration.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/maximum-subarray/
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];

            if(sum > max){
                max = sum;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}