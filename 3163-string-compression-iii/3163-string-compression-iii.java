class Solution {
    public String compressedString(String word) {
        StringBuilder compStrBuilder = new StringBuilder();
        int index = 0;
        int n = word.length();
        char currentChar = '\0';
        int frequency = 0;
        boolean incrementIndex = true;
        while (index < n) {
            frequency = 1;
            currentChar = word.charAt(index);
            incrementIndex = true;
            while (frequency < 9 && index + 1 < n && currentChar == word.charAt(index + 1)) {
                index++;
                frequency++;             
                incrementIndex = false;
            }
            index++;
            compStrBuilder.append(String.valueOf(frequency));
            compStrBuilder.append(currentChar);
        }
        return compStrBuilder.toString();
    }
}