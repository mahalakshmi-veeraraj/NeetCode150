class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        char leftChar = '\0';
        char rightChar = '\0';
        Map<Character, Integer> hashMap = new HashMap<>();
        boolean blnStopLeft = false;
        while (rightPointer < s.length()) {
            rightChar = s.charAt(rightPointer);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0)+1);
            if (hashMap.get(rightChar) > 1) {
                blnStopLeft = false;
                while (!blnStopLeft) {
                    leftChar = s.charAt(leftPointer);
                    leftPointer++;
                    hashMap.put(leftChar, hashMap.getOrDefault(leftChar,0)-1);
                    if (leftChar == rightChar) break;
                }
            }
            answer = Math.max(answer, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return answer;
    }
}