/*
Problem:
88. Merge Sorted Array

Difficulty:
Easy

Topic:
Array, TwoPointer, Sorting

Approach:
1)Initialize three pointers:
    i points to the last valid element in nums1 (m - 1).
    j points to the last element in nums2 (n - 1).
    k points to the last position in nums1 (m + n - 1).
2)Compare nums1[i] and nums2[j].
3)Place the larger element at nums1[k] and move the corresponding pointer (i or j) along with k.
4)Continue until one of the arrays is fully processed.
5)If any elements remain in nums2, copy them into nums1.
6)No need to copy remaining elements from nums1 because they are already in the correct position.

Time Complexity:
O(m+n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/merge-sorted-array/
*/
class solution {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}
