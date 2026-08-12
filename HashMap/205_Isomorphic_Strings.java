/*
Problem:
205. Isomorphic Strings

Difficulty:
Easy

Topic:
HashMap, String

Approach:

1. Get the lengths of both strings.
2. If the lengths are different:
   - Return `false`.
3. Create two HashMaps:
   - `map1` stores the mapping from characters of `s` to characters of `t`.
   - `map2` stores the mapping from characters of `t` to characters of `s`.
4. Traverse both strings character by character.
5. For every pair of characters:
   - Store `s[i]` in `ch1`.
   - Store `t[i]` in `ch2`.
6. Check `map1`:
   - If `ch1` is already mapped to a different character than `ch2`,
     return `false`.
7. Check `map2`:
   - If `ch2` is already mapped to a different character than `ch1`,
     return `false`.
8. Add both mappings:
   - `ch1 → ch2`
   - `ch2 → ch1`
9. If all characters follow a consistent one-to-one mapping:
   - Return `true`.

Why two HashMaps?

- One map checks that one character from `s` does not map to multiple
  characters in `t`.
- The second map checks that two different characters from `s` do not
  map to the same character in `t`.

Example:

s = "egg"
t = "add"

Mapping:
e → a
g → d

The mapping is consistent, so the strings are isomorphic.

Time Complexity:
O(n)

Space Complexity:
O(n)

LeetCode:
https://leetcode.com/problems/isomorphic-strings/
*/

class Solution {

    public boolean isIsomorphic(String s, String t) {

        // Get lengths of both strings
        int n = s.length();
        int m = t.length();

        // If lengths are different, strings cannot be isomorphic
        if (n != m) {
            return false;
        }

        // Map characters from s → t
        HashMap<Character, Character> map1 = new HashMap<>();

        // Map characters from t → s
        HashMap<Character, Character> map2 = new HashMap<>();

        // Traverse both strings
        for (int i = 0; i < n; i++) {

            // Get current characters
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // ==============================
            // Check s → t mapping
            // ==============================

            // If ch1 is already mapped to a different character
            if (map1.containsKey(ch1) && map1.get(ch1) != ch2) {
                return false;
            }

            // ==============================
            // Check t → s mapping
            // ==============================

            // If ch2 is already mapped to a different character
            if (map2.containsKey(ch2) && map2.get(ch2) != ch1) {
                return false;
            }

            // Store s → t mapping
            map1.put(ch1, ch2);

            // Store t → s mapping
            map2.put(ch2, ch1);
        }

        // All characters have a valid one-to-one mapping
        return true;
    }
}