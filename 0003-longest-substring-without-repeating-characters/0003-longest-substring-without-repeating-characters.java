class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int n = s.length();
        int leftPointer = 0;
        int rightPointer = 0;
        char leftChar = '\0';
        char rightChar = '\0';
        int answer = 0;
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0) + 1);
            if (hashMap.get(rightChar) > 1) {
                while (leftPointer < rightPointer) {
                    leftChar = s.charAt(leftPointer);
                    leftPointer++;
                    answer = Math.max(answer, rightPointer - leftPointer + 1);
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    if (leftChar == rightChar) {
                        break;
                    }
                }    
            }
            rightPointer++;
        }
        answer = Math.max(answer, rightPointer - leftPointer);
        return answer;
    }
}