class KthLargest {
    
    List<Integer> listElement = new ArrayList<>();
    int kValue = 0;
    public KthLargest(int k, int[] nums) {
        kValue = k;
        for (int i = 0; i < nums.length; i++) listElement.add(nums[i]);
    }
    
    public int add(int val) {
        listElement.add(val);
        Collections.sort(listElement, Collections.reverseOrder());
        return listElement.get(kValue - 1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */