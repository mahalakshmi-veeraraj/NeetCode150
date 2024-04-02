class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> hashMap_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap_t.put(t.charAt(i), hashMap_t.getOrDefault(t.charAt(i),0)+1);
        }
        
        Map<Character, Integer> hashMap_s = new HashMap<>();
        int leftPointer = 0;
        int rightPointer = 0;
        int answer = s.length() + 1;
        int n = s.length(); 
        char rightChar = '\0';
        char leftChar = '\0';
        boolean blnStopMoveLeft = false;
        int leftIndex = -1;
        int rightIndex = -1;
        while (rightPointer < n) {
            rightChar = s.charAt(rightPointer);
            hashMap_s.put(rightChar, hashMap_s.getOrDefault(rightChar,0)+1);
            if (checkMap(hashMap_t, hashMap_s)) {
                blnStopMoveLeft = false;
                while (!blnStopMoveLeft && leftPointer <= rightPointer) {
                    if (rightPointer - leftPointer + 1 < answer) {
                        answer = rightPointer - leftPointer + 1;
                        leftIndex = leftPointer;
                        rightIndex = rightPointer;
                    }
                    leftChar = s.charAt(leftPointer);
                    leftPointer++;
                    hashMap_s.put(leftChar, hashMap_s.get(leftChar) - 1);
                    blnStopMoveLeft = !checkMap(hashMap_t, hashMap_s);
                }
            }
            rightPointer++;
        }
        
        if (leftIndex == -1) return "";
        return s.substring(leftIndex, rightIndex + 1);
    }
    private boolean checkMap (Map<Character, Integer> hashMap_t, Map<Character, Integer> hashMap_s) {
        for (Map.Entry<Character, Integer> entry : hashMap_t.entrySet()) {
            if (!hashMap_s.containsKey(entry.getKey())) return false;
            if (hashMap_s.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }
}