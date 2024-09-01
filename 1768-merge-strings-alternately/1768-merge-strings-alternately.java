class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int n = word1.length();
        int m = word2.length();
        StringBuilder answerStrBuilder = new StringBuilder();
        while (i < Math.min(n, m)) {
            answerStrBuilder.append(word1.charAt(i));
            answerStrBuilder.append(word2.charAt(i));
            i++;
        }
        if (n > m) answerStrBuilder.append(word1.substring(i));
        else answerStrBuilder.append(word2.substring(i));
        return answerStrBuilder.toString();
    }
}