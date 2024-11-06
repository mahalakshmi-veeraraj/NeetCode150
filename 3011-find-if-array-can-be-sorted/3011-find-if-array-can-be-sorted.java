class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(nums[i])) continue;
            hashMap.put(nums[i], getNumberOfSetBits(nums[i]));
        }
        int k  = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[k]) {
                    if (hashMap.get(nums[j]) != hashMap.get(nums[k])) return false;
                    temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                    k--;
                }
            }
        }
        return true;
    }
    private int getNumberOfSetBits(int n) {
        int totalSetBits = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) totalSetBits++;
        }
        return totalSetBits;
    }
}