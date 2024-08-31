class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] answerArray = new int[2];
        answerArray[0] = 0;
        answerArray[1] = 0;
        for (int i = 0; i < n; i++) {
            find(answerArray, s, i, i + 1);
            find(answerArray, s, i, i);
        }
        return s.substring(answerArray[0], answerArray[1] + 1);
    }
    private void find (int[] answerArray, String s, int c1, int c2) {
        while (c1 >= 0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)) {
            if ( (c2 - c1 + 1) > (answerArray[1] - answerArray[0] + 1) ) {
                answerArray[0] = c1;
                answerArray[1] = c2;
            }
            c1--;
            c2++;
        }
    }
}