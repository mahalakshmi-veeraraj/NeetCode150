class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // int[] mergedArray = new int[nums1.length + nums2.length];
        // int index = 0;
        // for (int i = 0; i < nums1.length; i++) {
        //     mergedArray[index++] = nums1[i];
        // }
        // for (int i = 0; i < nums2.length; i++) {
        //     mergedArray[index++] = nums2[i];
        // }
        // Arrays.sort(mergedArray);
        // int n = mergedArray.length;
        // if (n % 2 != 0) return mergedArray[n / 2];
        // return (double)(mergedArray[n / 2] + mergedArray[(n / 2) - 1]) / 2;
        // int element1 = 0;
        // int element2 = 0;
        // int totalElement = nums1.length + nums2.length;
        // int element1Index = totalElement / 2;
        // int element2Index = totalElement % 2 != 0 ? element1Index : ((totalElement / 2) - 1);
        // int pointer1 = 0;
        // int pointer2 = 0;
        // int count = 0;
        // while (pointer1 < nums1.length && pointer2 < nums2.length) {
        //     if (nums1[pointer1] < nums2[pointer2]) {
        //         if (count == element1Index) element1 = nums1[pointer1];
        //         if (count == element2Index) element2 = nums1[pointer1];
        //         pointer1++;
        //     }
        //     else {
        //         if (count == element1Index) element1 = nums2[pointer2];
        //         if (count == element2Index) element2 = nums2[pointer2];
        //         pointer2++;
        //     }
        //     count++;
        //     if (element1 != 0 && element2 != 0) break;
        // }
        // while (pointer1 < nums1.length) {
        //     if (count == element1Index) element1 = nums1[pointer1];
        //     if (count == element2Index) element2 = nums1[pointer1];
        //     pointer1++;
        //     count++;
        // }
        // while (pointer2 < nums2.length) {
        //     if (count == element1Index) element1 = nums2[pointer2];
        //     if (count == element2Index) element2 = nums2[pointer2];
        //     pointer2++;
        //     count++;
        // }
        // if (totalElement % 2 != 0) return element1;
        // else return (double)(element1 + element2) / 2;
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int totalElement = nums1.length + nums2.length;
        int totalElementOnLeft = (totalElement + 1) / 2;
        int low = 0;
        int high = nums1.length;
        int mid1 = 0;
        int mid2 = 0;
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
            mid2 = totalElementOnLeft - mid1;
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid1 < nums1.length) r1 = nums1[mid1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (mid2 < nums2.length) r2 = nums2[mid2];
            if (l1 <= r2 && l2 <= r1) {
                int element1 = Math.max(l1, l2);
                int element2 = Math.min(r2, r1);
                if (totalElement % 2 != 0) return Math.max(l1, l2);
                return (double)(element1 + element2) / 2;
            }
            else if (l2 > r1) low = mid1 + 1;
            else if (l1 > r2) high = mid1 - 1;
        }
        return 0;
    }
}
