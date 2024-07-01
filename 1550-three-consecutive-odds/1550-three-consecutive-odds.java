class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (oddCount == 3) return true;
            if (arr[i] % 2 != 0) oddCount++;
            else oddCount = 0;
        }
        return oddCount == 3;
    }
}