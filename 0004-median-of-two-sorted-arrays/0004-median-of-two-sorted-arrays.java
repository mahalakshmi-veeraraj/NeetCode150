class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            mergedArray[index++] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            mergedArray[index++] = nums2[i];
        }
        Arrays.sort(mergedArray);
        int n = mergedArray.length;
        if (n % 2 != 0) return mergedArray[n / 2];
        return (double)(mergedArray[n / 2] + mergedArray[(n / 2) - 1]) / 2;
    }
}