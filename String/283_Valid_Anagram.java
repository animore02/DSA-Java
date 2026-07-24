/*
Problem:
283. Valid Anagram.

Difficulty:
Easy

Topic:
String

Approach:
1)First, check if both strings have the same length. If not, they cannot be anagrams, so return false.

2)Create a frequency array of size 26 to store the count of each lowercase letter.
    Traverse the first string and increment the count for each character.
    Traverse the second string and decrement the count for each character.

3)Finally, iterate through the frequency array. If any count is not zero, the strings are not anagrams. Otherwise, all character frequencies match, so return true.

Time Complexity: O(n)
    -One traversal of s → O(n)
    -One traversal of t → O(n)
    -Traversal of frequency array (size 26) → O(26) ≈ O(1)
Overall: 
O(n)

Space Complexity: 
O(1)
  -The frequency array always has a fixed size of 26, regardless of the input size.

LeetCode:
https://leetcode.com/problems/valid-anagram/
*/

class solution{
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch - 'a']++;
        }

        for(char ch: t.toCharArray()){
            freq[ch - 'a']--;
        }

        for(int cnt : freq){
            if(cnt != 0)
              return false;
        }

        return true;
    }
}