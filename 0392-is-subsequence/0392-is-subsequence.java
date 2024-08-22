class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            char currentChar = t.charAt(j);
            if (i < s.length() && currentChar == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}