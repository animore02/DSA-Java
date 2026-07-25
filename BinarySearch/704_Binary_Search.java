/*
Problem:
704.Binary Search

Difficulty:
Easy

Topic:
Array, Binary Search

Approach:
    1)Divide the search space into 2 halves:
        In order to divide the search space, we need to find the middle point of it. So, we will take a ‘mid’ pointer and do the following:
        mid = (low+high) // 2 ( ‘//’ refers to integer division)
    2)Compare the middle element with the target and trim down the search space:
        In this step, we can observe 3 different cases:
        If arr[mid] == target: We have found the target. From this step, we can return the index of the target, and the recursion will end.
        If target > arr[mid]: This case signifies our target is located on the right half of the array. So, the next recursion call will be binarySearch(nums, mid+1, high).
        If target < arr[mid]: This case signifies our target is located on the left half of the array. So, the next recursion call will be binarySearch(nums, low, mid-1).
    Base case: The base case of the recursion will be low > high. If (low > high), the search space becomes invalid which means the target is not present in the array.
Time Complexity:
O(log n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/binary-search/
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left= mid + 1;
            }
        }
        return -1;
    }
}