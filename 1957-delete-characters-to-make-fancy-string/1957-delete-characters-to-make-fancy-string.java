class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        char currentChar = '\0';
        char previousChar = '\0';
        int frequencyCount = 0;
        StringBuilder answerStrBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            currentChar = s.charAt(i);
            if (i == 0 || previousChar == currentChar) {
                frequencyCount++;
            }
            else {
                frequencyCount = 1;
            }
            if (frequencyCount < 3) answerStrBuilder.append(currentChar);
            previousChar = currentChar;
        }
        return answerStrBuilder.toString();
    }
}