class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        int rightPointer = 0;
        int leftPointer = 0;
        char rightChar = '\0';
        char leftChar = '\0';
        int windowSize = 0;
        int maxRepeatingCharCount = 0;
        int answer = 0;
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0) + 1);
            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, hashMap.get(rightChar));
            windowSize = rightPointer - leftPointer + 1;
            if (windowSize - maxRepeatingCharCount <= k) {
                answer = Math.max(answer, windowSize);
            }
            else {
                leftChar = s.charAt(leftPointer);
                leftPointer++;
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
            }
            rightPointer++;
        }
        return answer;
    }
}