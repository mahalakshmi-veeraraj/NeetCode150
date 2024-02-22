class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] answerArray = new int[2];
        for (int i = 0; i < n; i++) {
            expansionApproach(answerArray, i, i, s);
            if (i != n - 1)
                expansionApproach(answerArray, i, i + 1, s);
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = answerArray[0]; i <= answerArray[1]; i++) {
            answer.append(s.charAt(i));
        }
        return answer.toString();
    }
    private void expansionApproach (int[] answerArray, int center1, int center2, String s) {
        while (center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
            if (center2 - center1 > answerArray[1] - answerArray[0]) {
                answerArray[0] = center1;
                answerArray[1] = center2;
            }
            center1--;
            center2++;
        }
    }
}