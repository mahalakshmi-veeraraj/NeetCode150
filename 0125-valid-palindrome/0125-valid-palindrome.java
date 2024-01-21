class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (s.trim().isEmpty() || n <= 1) return true;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
            }    
            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
            }
            if (isAlphaNumeric(s.charAt(left)) && isAlphaNumeric(s.charAt(right))) {
                char leftChar = convertIfUpperCase(s.charAt(left));
                char rightChar = convertIfUpperCase(s.charAt(right));
                if (leftChar != rightChar) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isAlphaNumeric (char ch) {
        int ascii = ch;
        if ( (ascii >= 97 && ascii <= 122) || (ascii >= 65 && ascii <= 90) || (ascii >= 48 && ascii <= 57) )
            return true;
        return false;
    }
    private char convertIfUpperCase (char ch) {
        int ascii = ch;
        if (ascii >= 65 && ascii <= 90) {
            return (char) (ascii + 32); 
        }
        return ch;
    }
}