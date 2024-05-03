class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int row = 0; row < text1.length(); row++) {
            for (int col = 0; col < text2.length(); col++) {
                dp[row][col] = -1;
            }
        }
        return lcs(0, 0, text1, text2, dp);
    }
    private int lcs(int i, int j, String text1, String text2, int[][] dp) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs(i + 1, j + 1, text1, text2, dp);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(lcs(i + 1, j, text1, text2, dp), lcs(i, j + 1, text1, text2, dp));
            return dp[i][j];
        }
    }
}


// abcde
// ace

// a 
// a 
// matching

// ab
// ac

// Max(
//     ab
//     a
//     ,
//     a
//     ac 
// )