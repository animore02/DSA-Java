/*
Problem:
26. Remove Duplicates from Sorted Array

Difficulty:
Easy

Topic:
Array, Two Pointers

Approach:
    1)Use two pointers to overwrite duplicate elements in-place.
    2)The first pointer (i) keeps track of the position where the next unique element
    should be placed. Traverse the array with the second pointer (j). Whenever a
    new unique element is found (nums[j] != nums[j - 1]), copy it to nums[i] and
    increment i. 
    3)The first i elements of the array will contain all unique elements.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=1;
        for(int j=1; j<n; j++){
            if(nums[j] != nums[j-1]){
                 nums[i] = nums[j];
			     i++;
            }
        }
        return i;
    }
}