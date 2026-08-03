/*
Problem:
287. Find the Duplicate Number

Difficulty:
Medium

Topic:
Array, Two Pointers, Floyd's Cycle Detection

Approach:
1) Treat the array as a linked list:
   - Each index represents a node.
   - The value at each index represents the next node to visit.
   - Since one number is duplicated, two indices point to the same node, creating a cycle.

2) Initialize two pointers, `slow` and `fast`, at the first index (0).
   - Move `slow` one step at a time (`slow = nums[slow]`).
   - Move `fast` two steps at a time (`fast = nums[nums[fast]]`).

3) Continue moving both pointers until they meet.
   - Their first meeting confirms that a cycle exists in the array.

4) Reset one pointer (`slow`) back to the starting index (0), while keeping the other pointer (`fast`) at the meeting point.

5) Move both pointers one step at a time.
   - The index where they meet again is the duplicate number.

Intuition:
- Because one number appears more than once, following the array values forms a cycle.
- The first meeting of the slow and fast pointers only proves that a cycle exists.
- Resetting one pointer to the start and moving both pointers one step at a time causes them to meet at the entrance of the cycle, which corresponds to the duplicate number.
- This works because of Floyd's Cycle Detection Algorithm, where the mathematical relationship between the distances traveled guarantees that the second meeting point is the start of the cycle.

Time Complexity:
O(n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/find-the-duplicate-number/
*/

class Solution {
    public int findDuplicate(int[] nums) {

        // Initialize slow and fast pointers
        int slow = 0;
        int fast = 0;

        // Find the meeting point inside the cycle
        do {
            // Move slow pointer by one step
            slow = nums[slow];

            // Move fast pointer by two steps
            fast = nums[nums[fast]];

        } while (slow != fast);

        // Find the entrance of the cycle
        slow = 0;

        while (slow != fast) {

            // Move both pointers one step
            slow = nums[slow];
            fast = nums[fast];
        }

        // The meeting point is the duplicate number
        return slow;
    }
}