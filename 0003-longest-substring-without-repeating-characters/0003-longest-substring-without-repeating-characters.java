class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        if (n <= 1) return n;
        int left = 0;
        int right = 0;
        char rightChar = '\0';
        char leftChar = '\0';
        int answer = 0;
        while (right < n) {
            rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0)+1);
            if (hashMap.get(rightChar) > 1) {
                while (left < right) {
                    leftChar = s.charAt(left);
                    hashMap.put(leftChar, hashMap.getOrDefault(leftChar,0)-1);
                    left++;
                    if (right - left + 1 > answer) {
                        answer = right - left + 1;
                    }
                    if (rightChar == leftChar) {
                        break;
                    }   
                }
            }
            right++;
        }
        answer = Math.max(answer, right - left);
        return answer;
    }
}