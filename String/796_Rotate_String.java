/*
Problem:
796. Rotate String.

Difficulty:
Easy

Topic:
String, String Matching

Approch:
    1)First, check if both strings have the same length. If their lengths are different, one string cannot be a rotation of the other, so return false.

    2)Concatenate the original string with itself using (s + s). This creates a string that contains all possible rotations of s as substrings.

    3)Check if goal is a substring of (s + s) using the contains() method.

    4)If goal is found, it means goal is a valid rotation of s, so return true.Otherwise, return false.

Time Complexity:
    Checking string lengths → O(1)
    Concatenating s + s → O(n)
    Checking contains(goal) → O(n) (average case)
    Overall:
    O(n)

Space Complexity:
    O(n)
    The concatenated string (s + s) requires additional space proportional to the length of s.

LeetCode:
https://leetcode.com/problems/rotate-string/
*/
class solution{
    public boolean rotateString(String s, String goal) {
        if(s.length() !=  goal.length())return false;

        return (s+s).contains(goal);
    }
}

