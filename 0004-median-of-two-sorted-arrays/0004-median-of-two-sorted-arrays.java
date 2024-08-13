class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int low = 0;
        int high = nums1.length;
        int mid1 = 0;
        int mid2 = 0;
        int totalNumberOfElementsOnLeft = (n + 1) / 2;
        int l1 = 0;
        int l2 = 0;
        int r1 = 0;
        int r2 = 0;
        while (low <= high) {
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;
            mid1 = (low + high) / 2;
            mid2 = totalNumberOfElementsOnLeft - mid1;
            if(mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            else l1 = Integer.MIN_VALUE;
            if (mid1 < n1) r1 = nums1[mid1];
            else r1 = Integer.MAX_VALUE;
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            else l2 = Integer.MIN_VALUE;
            if (mid2 < n2) r2 = nums2[mid2];
            else r2 = Integer.MAX_VALUE;
            if (l2 > r1) {
                low = mid1 + 1;
            }
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                if (n % 2 != 0) {
                    return (double) Math.max(l1, l2);
                }
                else {
                    double element1 = (double) Math.max(l1, l2);
                    double element2 = (double) Math.min(r1, r2);
                    double median = (element1 + element2) / 2;
                    return median;
                }    
            }
        }
        return 0;
    }
}