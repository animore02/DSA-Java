/*
Problem:
1071. Greatest Common Divisor of Strings

Difficulty:
Easy

Topic:
String, Math, Euclidean Algorithm

Approach:
1) Check whether both strings can be formed by repeating the same base string.
   - Concatenate the strings in both possible orders.
   - If (str1 + str2) is not equal to (str2 + str1), there is no common divisor string.
   - Return an empty string "".

2) If both concatenations are equal, the answer exists.

3) Find the GCD (Greatest Common Divisor) of the lengths of both strings using the Euclidean Algorithm.

4) Return the substring of str1 from index 0 to gcdLength.
   - This prefix is the largest string that can divide both strings.

Time Complexity:
O(n + m)

Space Complexity:
O(n + m)
(Concatenated strings require extra space.)

LeetCode:
https://leetcode.com/problems/greatest-common-divisor-of-strings/
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {

        // Check if both strings have the same repeating pattern
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Find GCD of the lengths of both strings
        int lenGcd = gcd(str1.length(), str2.length());

        // Return the common prefix of GCD length
        return str1.substring(0, lenGcd);
    }

    // Euclidean Algorithm to find GCD of two numbers
    private int gcd(int a, int b) {
        while (b != 0) {

            // Find remainder
            int temp = a % b;

            // Update values
            a = b;
            b = temp;
        }

        return a;
    }
}