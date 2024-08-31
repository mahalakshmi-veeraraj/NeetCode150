class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        char leftChar = '\0';
        char rightChar = '\0';
        int answer = 0;
        while (right < s.length()) {
            rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar, 0) + 1);
            if (hashMap.get(rightChar) > 1) {
                while (left < right) {
                    answer = Math.max(answer, right - left);
                    leftChar = s.charAt(left);
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    left++;
                    if (leftChar == rightChar) break;
                }
            }
            right++;
        }
        answer = Math.max(answer, right - left);
        return answer;
    }
}