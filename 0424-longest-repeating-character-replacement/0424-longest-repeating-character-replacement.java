class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxRepeatingChars = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        char rightChar = '\0';
        char leftChar = '\0';
        int windowSize = 0;
        int answer = 0;
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            hashMap.put(rightChar, hashMap.getOrDefault(rightChar,0) + 1);
            rightPointer++;
            
            maxRepeatingChars = Math.max(maxRepeatingChars, hashMap.get(rightChar));
            windowSize = rightPointer - leftPointer;
            
            if (windowSize - maxRepeatingChars <= k) {
                answer = Math.max(answer, windowSize);
            } else {
                leftChar = s.charAt(leftPointer);
                hashMap.put(leftChar, hashMap.getOrDefault(leftChar,0) - 1);
                leftPointer++;
                maxRepeatingChars = 0;
            }
        }
        return answer;
    }
    private int bruteForceApproach (String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int answer = 0;
        String str = "";
        while (start < n) {
            end = start;
            while (end < n) {
                str = s.substring(start, end + 1);
                if (check(str,k)) {
                    answer = Math.max(answer, str.length());
                }
                end++;
            }
            start++;
        }
        return answer;
    }
    private boolean check (String str, int k) {
        int[] freqArray = new int[26];
        int maxFreq = 0;
        int ascii = 0;
        for (int i = 0; i < str.length(); i++) {
            ascii = str.charAt(i);
            freqArray[ascii - 65]++;
            maxFreq = Math.max(maxFreq, freqArray[ascii - 65]);
        }
        return str.length() - maxFreq <= k;
    }
}


//  0 1 2 3 4 5 6
// "A A B A B B A"
// 1
    
// leftPointer = 0 rightPointer = 0
// A = 1 WindowSize = 1 => 1 - 1 <= 1 True  Answer = 1 (A)
// A = 2 WindowSize = 2 => 2 - 2 <= 1 True Answer = 2 (A)
// B = 1 WindowSize = 3 => 3 - 2 <= 1 True Answer = 3 (B)
// A = 3 WindowSize = 4 => 4 - 3 <= 1 True Answer = 4 (A)
// B = 2 WindowSize = 5 => 5 - 3 <= 1 False Answer = 4 (B) Move Left Pointer A = 2 times B = 2 

// B = 3 WindowSize = 5 - 1 => 4 - 3 <= 1 True Answer = 4 
// A = 3 WindowSize = 6 - 1 => 5 - 3 <= 1 False Move Left Pointer A = 2 times B = 3




