/*
Problem:
35. Search Insert Position

Difficulty:
Easy

Topic:
Array, Binary Search

Approach:
  1)Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index and high will point to the last index.
  2)Calculate the ‘mid’: Now, we will calculate the value of mid using the following formula: mid = (low+high) // 2 ( ‘//’ refers to integer division.
  3) arr[mid] with x: With comparing arr[mid] to x, we can observe 2 different cases:
        Case 1 - If arr[mid] >= x: This condition means that the index mid may be an answer. So, we will update the ‘ans’ variable with mid and search in the left half if there is any smaller index that satisfies the same condition. Here, we are eliminating the right half.
        Case 2 - If arr[mid] < x: In this case, mid cannot be our answer and we need to find some bigger element. So, we will eliminate the left half and search in the right half for the answer.
  4)The above process will continue until the pointer low crosses high.

Time Complexity:
O(log n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/search-insert-position/
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
       return left;
    }
}