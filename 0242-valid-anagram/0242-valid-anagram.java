class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArray[s.charAt(i)-97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            freqArray[t.charAt(i)-97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (freqArray[i] != 0) {
                return false;
            }
        }
        return true;
    }
}