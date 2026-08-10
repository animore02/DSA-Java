/*
Problem:
387. First Unique Character in a String

Difficulty:
Easy

Topic:
String, HashMap, Frequency Counting

Approach:

1. Create a HashMap:

   - Key   = character
   - Value = frequency/count of that character

   The map stores how many times each character appears
   in the string.

2. Traverse through the entire string using:

      for(char ch : s.toCharArray())

3. For every character:

   - Get its current frequency using:

       freq.getOrDefault(ch, 0)

   - Add 1 to the frequency.

   Example:

       If 'a' is not present:
           freq.getOrDefault('a', 0) → 0

       After adding 1:
           freq.put('a', 1)

4. After building the frequency map, traverse the string
   again from left to right.

5. For each character:

   - Check its frequency using:

       freq.get(s.charAt(i))

6. If the frequency is 1:

   - This character appears only once.
   - Since we are traversing from left to right, this is
     the first unique character.
   - Return its index i.

7. If no character has frequency 1:

   - Return -1.


Time Complexity:
O(n)

- First loop traverses the string → O(n)
- Second loop traverses the string → O(n)
- Total:

    O(n) + O(n) = O(n)

Space Complexity:
O(k)

- The HashMap stores the frequency of each distinct
  character.
- k = number of distinct characters.

For lowercase English letters, k is at most 26,
so practically this can be considered O(1).

LeetCode:
https://leetcode.com/problems/first-unique-character-in-a-string/
*/

class Solution {
    public int firstUniqChar(String s) {

        // Stores the frequency of every character
        Map<Character, Integer> freq = new HashMap<>();

        // Count the frequency of each character
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Traverse the string from left to right
        for (int i = 0; i < s.length(); i++) {

            // If the character appears only once,
            // it is the first unique character
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // No unique character exists
        return -1;
    }
}