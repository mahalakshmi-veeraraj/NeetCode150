class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) return findMedianSortedArrays(nums2, nums1);
        int totalElements = n + m;
        int totalElementsOnLeft = (totalElements + 1) / 2;
        int low = 0;
        int high = n;
        int middle1 = 0;
        int middle2 = 0;
        int l1 = 0;
        int l2 = 0;
        int r1 = 0;
        int r2 = 0;
        while (low <= high) {
            middle1 = (low + high) / 2;
            middle2 = totalElementsOnLeft - middle1;
            
            if (middle1 - 1 >= 0) l1 = nums1[middle1 - 1];
            else l1 = Integer.MIN_VALUE;
            if (middle1 < n) r1 = nums1[middle1];
            else r1 = Integer.MAX_VALUE;
            
            if (middle2 - 1 >= 0) l2 = nums2[middle2 - 1];
            else l2 = Integer.MIN_VALUE;
            if (middle2 < m) r2 = nums2[middle2];
            else r2 = Integer.MAX_VALUE;
            
            if (l2 > r1) low = middle1 + 1;
            else if (l1 > r2) high = middle1 - 1;
            else {
                if (totalElements % 2 != 0) return Math.max(l1, l2);
                else return ((double)Math.max(l1, l2) + (double)Math.min(r1, r2)) / 2;
            }
        }
        return 0;
    }
}