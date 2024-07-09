class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        char leftChar = '\0';
        char rightChar = '\0';
        int answer = 0;
        while (right < n) {
            rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar, 0) + 1);
            answer = Math.max(answer, right - left);
            if (hashMap.get(rightChar) > 1) {
                while (left < right) {
                    leftChar = s.charAt(left);
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    if (hashMap.get(leftChar) == 0) hashMap.remove(leftChar);
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