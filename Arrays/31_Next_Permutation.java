/*
Problem:
31. Next Permutation

Difficulty:
Medium

Topic:
Array, Two Pointers

Approach:
1) The next permutation is the next greater arrangement of numbers with the smallest possible change.

2) Traverse the array from right to left and find the first index where:
   nums[i] < nums[i + 1]
   - This index is called the "breaking point" (pivot).
   - Everything to the right of this index is in descending order.

3) If no breaking point exists:
   - The array is completely in descending order.
   - This is already the largest permutation.
   - Reverse the entire array to get the smallest permutation.

4) Otherwise, traverse again from the end of the array and find the first element
   that is greater than the pivot element.
   - Since the suffix is in descending order, the first greater element from the end
     is the smallest possible number that can replace the pivot.

5) Swap the pivot with this element.

6) Reverse the portion of the array after the pivot.
   - Before swapping, this suffix was in descending order.
   - Reversing it makes it ascending, giving the smallest possible arrangement.
   - This ensures we obtain the immediate next permutation.

Intuition:
- To find the next permutation with minimal change, we need to increase the number
  at the earliest possible position from the right.
- The breaking point is the first digit that can be increased.
- Swapping it with the next larger digit makes the number just slightly larger.
- Reversing the remaining suffix makes it as small as possible.
- If no breaking point exists, the array is the largest permutation, so reversing
  it produces the smallest permutation.

Time Complexity:
O(n)
- One pass to find the pivot.
- One pass to find the element to swap.
- One pass to reverse the suffix.

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/next-permutation/
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        // Find the breaking point (pivot)
        for(int i=n-2; i>pivot; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }

        // If no pivot exists, reverse the entire array
        if(pivot == -1){
            reverse(nums, 0, n-1);
            return;
        }
       
        // Find the first element greater than the pivot from the end
       for(int i=n-1; i>pivot; i--){
        if(nums[i] > nums[pivot]){
            swap(nums, pivot, i);
        }
       }
        
        // Reverse the suffix to get the smallest arrangement
        reverse(nums, pivot + 1, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
