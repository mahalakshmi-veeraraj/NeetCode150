class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i) continue;
            while (arr[i] < n && arr[i] != i) {
                int temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i) return i;
        }
        return n;
    }
}