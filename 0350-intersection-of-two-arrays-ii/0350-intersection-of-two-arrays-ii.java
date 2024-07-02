class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> listIntersection = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] == nums2[pointer2]) {
                listIntersection.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
            else if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            }
            else {
                pointer2++;
            }
        }
        int[] answer = new int[listIntersection.size()];
        for (int i = 0; i < listIntersection.size(); i++) {
            answer[i] = listIntersection.get(i);
        }
        return answer;
    }
}