class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalElements = nums1.length + nums2.length;
        int median1Index = totalElements / 2;
        int median2Index = totalElements % 2 != 0 ? median1Index : median1Index - 1;
        int median1 = 0;
        int median2 = 0;
        int n = 0;
        int m = 0;
        int index = 0;
        while (n < nums1.length && m < nums2.length) {
            if (nums1[n] <= nums2[m]) {
                if (index == median1Index) median1 = nums1[n];
                if (index == median2Index) median2 = nums1[n];
                n++;
            }
            else {
                if (index == median1Index) median1 = nums2[m];
                if (index == median2Index) median2 = nums2[m];
                m++;
            }
            index++;
        }
        while (n < nums1.length) {
            if (index == median1Index) median1 = nums1[n];
            if (index == median2Index) median2 = nums1[n];
            n++;
            index++;
        }
        while (m < nums2.length) {
            if (index == median1Index) median1 = nums2[m];
            if (index == median2Index) median2 = nums2[m];
            m++;
            index++;
        }
        return ((double) median1 + (double) median2) / 2;
    }
}