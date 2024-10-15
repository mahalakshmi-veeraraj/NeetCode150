class Solution {
    // Optimized Approach using Two Pointer technique.
    public long minimumSteps(String s) {
        int leftPointer = 0;
        int rightPointer = 0;
        long answer = 0;
        int n = s.length();
        char currentCharacter = '\0';
        while (rightPointer < n) {
            currentCharacter = s.charAt(rightPointer);
            if (currentCharacter == '0') {
                answer += (rightPointer - leftPointer);
                leftPointer++;
            }
            rightPointer++;
        }  
        return answer;
    }
    // Brute Force Approach - Got Time Limit Exceeded Exception
    // public long minimumSteps(String s) {
    //     StringBuilder sb = new StringBuilder(s);
    //     int n = s.length();
    //     long answer = 0;
    //     char currentCharacter = '\0';
    //     while (!isAllBalckBallsMovedToTheRight(sb.toString())) {
    //         for (int i = 0; i < n; i++) {
    //             currentCharacter = sb.toString().charAt(i);
    //             if (currentCharacter == '1' && i < n - 1 && sb.toString().charAt(i + 1) == '0') {
    //                 // perform swapping
    //                 answer++;
    //                 sb.setCharAt(i, '0');
    //                 sb.setCharAt(i + 1, '1');
    //             }
    //         }
    //     }    
    //     return answer;
    // }
    // private boolean isAllBalckBallsMovedToTheRight(String s) {
    //     int n = s.length();
    //     for (int i = 0; i < n - 1; i++) {
    //         if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') return false;
    //     }
    //     return true;
    // }
}

