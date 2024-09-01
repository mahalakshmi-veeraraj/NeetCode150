class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currStr = strs[i];
            int j = 0;
            String subAnswer = "";
            while (j < longestCommonPrefix.length()) {
                if (currStr.indexOf(longestCommonPrefix.substring(0, j + 1)) == 0) {
                    subAnswer = longestCommonPrefix.substring(0, j + 1);
                    j++;
                }
                else {
                    break;
                }
            }
            longestCommonPrefix = subAnswer;
        }
        return longestCommonPrefix;
    }
}