/*
Problem:
238. Product of Array Except Self

Difficulty:
Medium

Topic:
Array, Prefix Product, Suffix Product

Approach:
1) Create an answer array `ans` of size n.

2) Calculate the prefix product:
   - Set ans[0] = 1 because there are no elements to the left of index 0.
   - For every index i, store the product of all elements before index i.
   - Formula:
     ans[i] = ans[i - 1] * nums[i - 1]

3) Initialize `suffix = 1`.
   - This variable stores the product of all elements to the right
     of the current index.

4) Traverse the array from right to left:
   - Multiply the prefix product stored in ans[i] with suffix.
   - Update suffix by multiplying it with nums[i].

5) After the traversal, ans[i] contains the product of all elements
   except nums[i].

6) Return the answer array.

Example:
nums = [1, 2, 3, 4]

Prefix products:
ans = [1, 1, 2, 6]

Suffix traversal:
i = 3 -> ans[3] = 6  * 1  = 6
i = 2 -> ans[2] = 2  * 4  = 8
i = 1 -> ans[1] = 1  * 12 = 12
i = 0 -> ans[0] = 1  * 24 = 24

Output:
[24, 12, 8, 6]

Time Complexity:
O(n)

Space Complexity:
O(1)
The output array is not counted as extra space.

LeetCode:
https://leetcode.com/problems/product-of-array-except-self/
*/

class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Answer array will first store prefix products
        int[] ans = new int[n];

        // No elements exist on the left of index 0
        ans[0] = 1;

        // Calculate prefix products
        for (int i = 1; i < n; i++) {

            // Product of all elements before index i
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Stores product of elements to the right
        int suffix = 1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Prefix product * suffix product
            ans[i] = ans[i] * suffix;

            // Update suffix for the next index
            suffix *= nums[i];
        }

        // Return final answer
        return ans;
    }
}