class Solution {
    public String largestNumber(int[] input) {
        Integer[] nums = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = input[i];
        }
        Arrays.sort(nums, (e1, e2)->{
            String str1 = String.valueOf(e1) + String.valueOf(e2);
            String str2 = String.valueOf(e2) + String.valueOf(e1);
            return str2.compareTo(str1);
        });
        StringBuilder sb = new StringBuilder();
        int totalZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (nums[i] == 0) totalZeros++;
        }
        return totalZeros == nums.length ? "0" : sb.toString();
    }
}