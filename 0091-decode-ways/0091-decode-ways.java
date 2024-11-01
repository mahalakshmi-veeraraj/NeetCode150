class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        return find (s, 0, dp);
    }
    private int find (String s, int index, int[] dp) {
        if (index == s.length()) return 1;
        else if (index > s.length()) return 0;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != -1) return dp[index];
        
        int answer = 0;
        // take single character.
        boolean take = true;
        if (index + 1 < s.length() && s.charAt(index + 1) == '0') take =false;
        if (take) answer += find (s, index + 1, dp);
        
        // take two characters.
        if (index + 2 <= s.length() && Integer.valueOf(s.substring(index, index + 2)) >= 27) {
            return answer;
        }
        answer += find (s, index + 2, dp);
        dp[index] = answer;
        return dp[index];
    }
}