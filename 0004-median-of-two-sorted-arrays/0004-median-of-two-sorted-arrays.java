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
        int element1 = 0;
        int element2 = 0;
        int totalElement = nums1.length + nums2.length;
        int element1Index = totalElement / 2;
        int element2Index = totalElement % 2 != 0 ? element1Index : ((totalElement / 2) - 1);
        int pointer1 = 0;
        int pointer2 = 0;
        int count = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] < nums2[pointer2]) {
                if (count == element1Index) element1 = nums1[pointer1];
                if (count == element2Index) element2 = nums1[pointer1];
                pointer1++;
            }
            else {
                if (count == element1Index) element1 = nums2[pointer2];
                if (count == element2Index) element2 = nums2[pointer2];
                pointer2++;
            }
            count++;
            if (element1 != 0 && element2 != 0) break;
        }
        while (pointer1 < nums1.length) {
            if (count == element1Index) element1 = nums1[pointer1];
            if (count == element2Index) element2 = nums1[pointer1];
            pointer1++;
            count++;
        }
        while (pointer2 < nums2.length) {
            if (count == element1Index) element1 = nums2[pointer2];
            if (count == element2Index) element2 = nums2[pointer2];
            pointer2++;
            count++;
        }
        if (totalElement % 2 != 0) return element1;
        else return (double)(element1 + element2) / 2;
    }
}
