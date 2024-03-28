class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        
        if (s.trim().isEmpty()) {
            if (n == 0)
                return n;
            else
                return 1;
        }
        
        Map<Character, Integer> hashMap = new HashMap<>();
        
        
        int left = 0;
        int right = 0;
        char leftChar = s.charAt(left);
        char rightChar = '\0';
        
        int answer = 1;
        
        while (right < n) {
            rightChar = s.charAt(right);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0)+1);
            
            if (hashMap.get(rightChar) > 1) {
                while (left <= right) {
                    leftChar = s.charAt(left);
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    left++;
                    answer = Math.max(answer, right - left + 1);
                    if (leftChar == rightChar) {
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
