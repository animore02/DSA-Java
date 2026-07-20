package Arrays;
/*
Problem:
1. Two Sum

Difficulty:
Easy

Topic:
Array, HashMap

Approach:
Use a HashMap to store each number and its index while traversing the array.
For every element, calculate the complement (target - nums[i]).
If the complement already exists in the HashMap, return its index and the current index.

Time Complexity:
O(n)

Space Complexity:
O(n)

LeetCode:
https://leetcode.com/problems/two-sum/
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
