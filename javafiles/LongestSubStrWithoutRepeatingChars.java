package javafiles;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 *
 */
public class LongestSubStrWithoutRepeatingChars {
    public static int solution(String s) {

        int windowStart = 0;
        int windowEnd = 0;
        int max = 0;
        HashMap<Character, Boolean> charMap = new HashMap<>();

        for (; windowEnd < s.length(); windowEnd++) {
            char currentCharacter = s.charAt(windowEnd);
            if (charMap.get(currentCharacter) == null || charMap.get(currentCharacter) != true) {
                charMap.put(currentCharacter, true);
                int windowCapacity = windowEnd - windowStart + 1;
                if (windowCapacity > max) {
                    max = windowCapacity;
                }
            } else {
                // At this point we have found a repeating char
                // so we want to start looking for a new sub string
                // we do this by setting all previous characters up until our current character
                // to false in our map.
                // we do this using our windowstart which the first time this block runs will be
                // zero
                // then we will increment our window start thereby setting all chars up to our
                // current char to false (resetting our map) and also shrinking our window
                while (charMap.get(currentCharacter) == true) {
                    charMap.put(s.charAt(windowStart), false);
                    windowStart++;
                }
                // Mark the current character as seen since we've seen it
                charMap.put(currentCharacter, true);
            }
        }

        return max;
    }
}
