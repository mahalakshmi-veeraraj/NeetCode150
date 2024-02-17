class Solution {
    public String minWindow(String s, String t) {
        
        
        Map<Character, Integer> freqMap_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            freqMap_t.put(t.charAt(i), freqMap_t.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character, Integer> freqMap_s = new HashMap<>();
    
        int leftPointer = 0;
        int rightPointer = 0;
        char leftChar = '\0';
        char rightChar = '\0';
        int leftIndex = -1;
        int rightIndex = -1;
        int answer = s.length();
        boolean blnStopLeft = false;
        
        while (rightPointer < s.length()) {
            rightChar = s.charAt(rightPointer);
            freqMap_s.put(rightChar, freqMap_s.getOrDefault(rightChar,0)+1);
            rightPointer++;
            
            if (check(freqMap_t, freqMap_s)) {
                blnStopLeft = false;
                while (!blnStopLeft && leftPointer <= rightPointer) {
                    if (rightPointer - leftPointer  <= answer) {
                        answer = rightPointer - leftPointer;
                        leftIndex = leftPointer;
                        rightIndex = rightPointer;
                    }
                    
                    leftChar = s.charAt(leftPointer);
                    freqMap_s.put(leftChar, freqMap_s.getOrDefault(leftChar,0)-1);
                    leftPointer++;
                    blnStopLeft = !check(freqMap_t, freqMap_s);
                }
            }
        }
        if (leftIndex == -1 || rightIndex == -1) return "";
        return s.substring(leftIndex, rightIndex);
    }
    private boolean check (Map<Character, Integer> freqMap_t, Map<Character, Integer> freqMap_s) {
        for (Map.Entry<Character, Integer> entry : freqMap_t.entrySet()) {
            if (!freqMap_s.containsKey(entry.getKey())) return false;
            if ( freqMap_s.get(entry.getKey()) < freqMap_t.get(entry.getKey()) )  return false;
        }
        return true;
    }
}

