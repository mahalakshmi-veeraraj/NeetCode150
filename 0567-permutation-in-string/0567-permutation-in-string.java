class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1_Frequency_Array =  new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1_Frequency_Array[s1.charAt(i) - 97]++;
        }
        int windowSize = s1.length();
        int totalWindow = s2.length() - windowSize;
        int[] s2_Frequency_Array =  new int[26];
        for (int i = 0; i < windowSize; i++) {
            s2_Frequency_Array[s2.charAt(i) - 97]++;
        }
        if (check(s1_Frequency_Array, s2_Frequency_Array)) {
            return true;
        }
        int inElement = 0;
        int outElement = 0;
        for (int i = 1; i <= totalWindow; i++) {
            inElement = s2.charAt(i + windowSize - 1) - 97;
            outElement = s2.charAt(i - 1) - 97;
            s2_Frequency_Array[inElement]++;
            s2_Frequency_Array[outElement]--;
            if (check(s1_Frequency_Array, s2_Frequency_Array)) {
               return true;
            }   
        }
        return false;
    }
    private boolean check(int[] s1_Frequency_Array, int[] s2_Frequency_Array) {
        for (int i = 0; i < s1_Frequency_Array.length; i++) {
            if (s2_Frequency_Array[i] < s1_Frequency_Array[i]) {
                return false;
            }
        }
        return true;
    }
}