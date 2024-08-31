class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        else if (x < 0) return false;
        StringBuilder sb  = new StringBuilder();
        int input = x;
        while (input > 0) {
            sb.append(input % 10);
            input = input / 10;
        }
        return x == Long.valueOf(sb.toString());
    }
}