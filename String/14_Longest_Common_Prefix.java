/*
Problem:
14. Longest Common Prefix

Difficulty:
Easy

Topic:
Array, String

Approach:

1. Check if the input array is null or empty.
   - If yes, return an empty string.

2. Take the first string as the initial prefix.
   - Initially, assume the complete first string is the common prefix.

3. Compare the prefix with every other string in the array.

4. Use indexOf(prefix) to check whether the current string starts
   with the prefix.
   - If indexOf(prefix) returns 0:
     - The prefix exists at the beginning of the string.
     - Continue to the next string.
   - If it does not return 0:
     - The current prefix is not common.
     - Remove the last character from the prefix.
     - Continue checking.

5. If the prefix becomes empty:
   - No common prefix exists.
   - Return an empty string.

6. After checking all strings:
   - Return the remaining prefix.

Example:

Input:
["flower", "flow", "flight"]

Initial prefix:
"flower"

Compare with "flow":
"flower" → "flowe" → "flow"

Compare with "flight":
"flow" → "flo" → "fl"

Answer:
"fl"

Time Complexity:
O(n × m)

- n = number of strings
- m = length of the shortest/common prefix
- Each string may require removing characters from the prefix.

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/longest-common-prefix/
*/

class Solution {

    // Main function

    public String longestCommonPrefix(String[] strs) {

        // Handle null or empty input
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initially take the first string as the prefix
        String prefix = strs[0];

        // Compare prefix with every other string
        for (int i = 1; i < strs.length; i++) {

            /*
             * Check whether the current string starts
             * with the current prefix.
             *
             * indexOf(prefix) == 0 means prefix occurs
             * at the beginning of the string.
             */
            while (strs[i].indexOf(prefix) != 0) {

                // Remove the last character from prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // No common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}