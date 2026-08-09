/*
Problem:
169. Majority Element

Difficulty:
Easy

Topic:
Array

Approach:

1. Initialize two variables:

   - candidate = 0
     Stores the current possible majority element.

   - cnt = 0
     Stores the current vote/count for the candidate.

2. Traverse through every number in the array.

3. If cnt becomes 0:

   - Choose the current number as the new candidate.

4. Compare the current number with the candidate.

   - If num == candidate:
     - Increase cnt by 1.
     - This means the current number supports the candidate.

   - If num != candidate:
     - Decrease cnt by 1.
     - This means the current number cancels out one
       occurrence of the candidate.

5. Continue this process for the entire array.

6. Return candidate.

Why does this work?

The problem guarantees that the majority element appears
more than n/2 times.

Think of every different number as cancelling one occurrence
of the majority element.

Since the majority element appears more than all other
elements combined, it cannot be completely cancelled.

Therefore, the remaining candidate at the end is the
majority element.


Time Complexity:
O(n)

- We traverse the array only once.
- n = number of elements in the array.

Space Complexity:
O(1)

- Only candidate and cnt variables are used.
- No extra array or data structure is required.

LeetCode:
https://leetcode.com/problems/majority-element/
*/

class Solution {

    public int majorityElement(int[] nums) {

        // Stores the current possible majority element
        int candidate = 0;

        // Stores the vote/count for the candidate
        int cnt = 0;

        // Traverse through every number
        for (int num : nums) {

            // If count becomes 0, choose a new candidate
            if (cnt == 0) {
                candidate = num;
            }

            // Vote for or against the candidate
            if (num == candidate) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // The majority element remains as the candidate
        return candidate;
    }
}