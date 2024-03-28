class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> hashMap = new HashMap<>();
        int left = 0; 
        int right = 0;
        char rightChar = '\0';
        char leftChar = '\0';
        int maxRepeatingChars = Integer.MIN_VALUE;
        int windowSize = 0;
        int answer = Integer.MIN_VALUE;
        while (right < n) {
            rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0)+1);
            right++;
            maxRepeatingChars = Math.max(maxRepeatingChars, hashMap.get(rightChar));
            windowSize = right - left;
            if (windowSize - maxRepeatingChars <= k) {
                answer = Math.max(answer, windowSize);
            }
            else {
                leftChar = s.charAt(left);
                hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                left++;
            }
        }
        return answer;
    }
}