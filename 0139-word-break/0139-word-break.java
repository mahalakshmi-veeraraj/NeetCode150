class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return find (s, wordDict, 0, dp) == 1;
    }
    private int find (String s, List<String> wordDict, int position, int[] dp) {
        if (position == s.length()) return 1;
        if (dp[position] != -1) return dp[position];
        StringBuilder strBuilder = new StringBuilder();
        for (int index = position; index < s.length(); index++) {
            strBuilder.append(s.charAt(index));
            if (wordDict.contains(strBuilder.toString()) && find (s, wordDict, index + 1, dp) == 1) {
                dp[index] = 1;
                return 1;
            }
        }
        dp[position] = 0;
        return 0;
    }
}