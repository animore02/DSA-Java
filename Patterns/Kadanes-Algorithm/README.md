# Kadane's Algorithm

## What is Kadane's Algorithm?

Kadane's Algorithm is an optimization technique used to find the maximum sum contiguous subarray in an array.

Instead of checking every possible subarray (O(n²)), it computes the answer in one pass.

Time Complexity: O(n)
Space Complexity: O(1)

---

## When to Use?

Use Kadane's Algorithm when the problem asks for:

- Maximum subarray sum
- Largest contiguous segment
- Maximum score after choosing a continuous range
- Best profit over a continuous interval
- Maximum difference in a contiguous sequence

Keywords:
- Contiguous
- Maximum Sum
- Largest Sum
- Continuous Subarray

---

## Intuition

At every element we have two choices.

1. Extend the previous subarray.
2. Start a new subarray.

Choose whichever gives a larger sum.

Example:

Array:

2 -1 3 -5 4 6

Current Sum:

2
1
4
-1
4
10

Maximum Sum = 10

---

## Algorithm

   1.Iterate through the array using a variable i. During each iteration, add the current element arr[i] to a running sum variable.
   2.Keep track of the maximum sum encountered during the iteration by comparing the current sum with the previous maximum sum, and update it  if the current sum is greater.
   3.If at any point the sum becomes negative, reset it to 0, as a negative sum won't contribute positively to the overall maximum sum.
   4.Continue the iteration until all elements in the array are processed.
   5.Finally, return the maximum sum encountered during the iteration.



## Complexity

Time : O(n)

Space : O(1)

---

## Common Mistakes

❌ Initializing currentSum = 0

Fails for all negative arrays.

Correct:

currentSum = nums[0]

---

❌ Forgetting to update maxSum every iteration.

---

❌ Using nested loops.

That becomes O(n²).

---

## Pattern Recognition

If the question contains

✔ Maximum
✔ Contiguous
✔ Continuous
✔ Sum

Think about Kadane's Algorithm first.