class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        int n = s2.length();
        if (n < windowSize) return false;
        int totalWindows = n - windowSize;
        Map<Character,Integer> map_s1 = new HashMap<>();
        Map<Character,Integer> map_s2 = new HashMap<>();
        char ch = '\0';
        for (int i = 0; i < s1.length(); i++) {
            ch = s1.charAt(i);
            map_s1.put(ch, map_s1.getOrDefault(ch,0)+1);
        }
        // Checking the very first window.
        for (int i = 0; i < windowSize; i++) {
            ch = s2.charAt(i);
            map_s2.put(ch, map_s2.getOrDefault(ch,0)+1);
        }
        if (check (map_s1, map_s2)) return true;
        // Checking the subsequent windows.
        char inElementChar = '\0';
        char outElementChar = '\0';
        for (int i = 1; i <= totalWindows; i++) {
            inElementChar = s2.charAt(i + windowSize - 1);
            outElementChar = s2.charAt(i - 1);
            
            map_s2.put(outElementChar, map_s2.getOrDefault(outElementChar,0) - 1);
            if (map_s2.get(outElementChar) == 0) map_s2.remove(outElementChar);
            
            map_s2.put(inElementChar, map_s2.getOrDefault(inElementChar,0) + 1);
            if (check(map_s1, map_s2)) return true;
        }
        return false;
    }
    private boolean check (Map<Character, Integer> map_s1, Map<Character, Integer> map_s2) {
        for (Map.Entry<Character, Integer> entry : map_s1.entrySet()) {
            if (!map_s2.containsKey(entry.getKey())) return false;
            if (map_s2.get(entry.getKey()) < map_s1.get(entry.getKey())) return false;
        }
        return true;
    }
}

// Given two strings s1 and s2, return true if s2 contains a permutation of s1 or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// s1 = "ab", s2 = "eidbaooo"

// Permutations of s1 are as follows ab, ba
// s2 contains ba in it so answer here is true.

// Example 2:
// s1 = "ab", s2 = "eidboaoo"
// Permutations of s1 are as follows ab, ba
// s2 does not contains ab, or ba in it so answer here is false.
