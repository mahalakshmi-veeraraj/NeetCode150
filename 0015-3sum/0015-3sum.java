class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> hashSet = new HashSet<>();
        int moreNeeded = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            left = i + 1;
            right = n - 1;
            moreNeeded = 0 - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == moreNeeded) {
                    List<Integer> listSubAnswer = new ArrayList<>();
                    listSubAnswer.add(nums[i]);
                    listSubAnswer.add(nums[left]);
                    listSubAnswer.add(nums[right]);
                    Collections.sort(listSubAnswer);
                    hashSet.add(listSubAnswer);
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] < moreNeeded) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (List<Integer> key : hashSet) {
            listAnswer.add(key);
        }
        return listAnswer;
    }
}