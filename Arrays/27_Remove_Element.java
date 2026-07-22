/*
Problem:
27. Remove Element

Difficulty:
Easy

Topic:
Array, TwoPointer

Approach:
Traverse the array once. 
Whenever an element is not equal to val, place it at the next available position (k) and increment k. 
After the traversal, k is the number of remaining elements.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/remove-element/
*/

class solution{
    public int removeElement(int[] nums, int val){
        int  k = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}