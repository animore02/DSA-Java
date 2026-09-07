/*
Problem:
151. Reverse Words in a String

Difficulty:
Medium

Topic:
String, StringBuilder, TwoPointers

Approach:
1. Split the string into individual words using:

   String[] words = s.split("\\s+");

   - "\\s+" means one or more whitespace characters.
   - It handles:
       * single spaces
       * multiple spaces
       * tabs
       * other whitespace characters

   Example:

   s = "the sky is blue"

   words = ["the", "sky", "is", "blue"]


2. Create a StringBuilder called `res`:

   StringBuilder res = new StringBuilder();

   - It is used to efficiently construct the final string.
   - Instead of repeatedly creating new String objects,
     StringBuilder modifies the same object.


3. Traverse the words array from RIGHT to LEFT:

   for (int i = words.length - 1; i >= 0; i--)

   - Normally, we traverse from index 0 to n-1.
   - Here, we start from the last word.
   - This reverses the order of the words.


4. Append the current word to `res`:

   res.append(words[i]);

   Example:

   words = ["the", "sky", "is", "blue"]

   Traversal:

   i = 3 → "blue"
   i = 2 → "is"
   i = 1 → "sky"
   i = 0 → "the"

   Result:

   "blue is sky the"


5. Add a space between words:

   if (i != 0) {
       res.append(" ");
   }

   Why do we check `i != 0`?

   We don't want to add an extra space after the
   last word.

   Example:

   Correct:
   "blue is sky the"

   Incorrect:
   "blue is sky the "


6. Return the final string:

   return res.toString().trim();

   - `toString()` converts StringBuilder into String.
   - `trim()` removes leading and trailing whitespace.

   In this particular implementation, `split("\\s+")`
   already removes the whitespace separators from the
   resulting words, so `trim()` is mainly an extra safeguard.


Why does this work?

The problem asks us to reverse the ORDER of the words,
not reverse the characters inside each word.

Example:

Input:
"hello world"

Correct:
"world hello"

NOT:
"dlrow olleh"


Time Complexity = O(N)

where N is the length of the input string.


Space Complexity:

O(N)

- The `split()` operation creates an array of words.
- The words together require O(N) space.
- `StringBuilder` also requires O(N) space.

Therefore:

Space Complexity = O(N)


LeetCode:
https://leetcode.com/problems/reverse-words-in-a-string/
*/


class Solution {

    public String reverseWords(String s) {

        // Split the string into words.
        // "\\s+" means one or more whitespace characters.
        String[] words = s.split("\\s+");

        // StringBuilder is used to build resulting String.
        StringBuilder res = new StringBuilder();

        // Traverse the words from right to left.
        for (int i = words.length - 1; i >= 0; i--) {

            // Add the current word to the result.
            res.append(words[i]);

            // Add a space between words.
            // Don't add a space after the last word.
            if (i != 0) {
                res.append(" ");
            }
        }

        // Convert StringBuilder into String
        // and remove unnecessary leading/trailing spaces.
        return res.toString().trim();
    }
}