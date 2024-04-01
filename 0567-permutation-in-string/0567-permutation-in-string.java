class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        Map<Character, Integer> hashMap_s1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            hashMap_s1.put(s1.charAt(i), hashMap_s1.getOrDefault(s1.charAt(i),0) + 1);
        }
        
        Map<Character, Integer> hashMap_s2 = new HashMap<>();
        int windowSize = s1.length();
        int totalWindows = s2.length() - windowSize;
        for (int i = 0; i < windowSize; i++) {
            hashMap_s2.put(s2.charAt(i), hashMap_s2.getOrDefault(s2.charAt(i),0) + 1);
        }
        if (checkMap(hashMap_s1, hashMap_s2)) return true;
        char inElement = '\0';
        char outElement = '\0';
        for (int i = 1; i <= totalWindows; i++) {
            inElement = s2.charAt(i + windowSize - 1);
            outElement = s2.charAt(i - 1);
            hashMap_s2.put(inElement, hashMap_s2.getOrDefault(inElement, 0) + 1);
            hashMap_s2.put(outElement, hashMap_s2.get(outElement) - 1);
            if (checkMap(hashMap_s1, hashMap_s2)) return true;
        } 
        return false;
    }
    private boolean checkMap (Map<Character, Integer> hashMap_s1, Map<Character, Integer> hashMap_s2) {
        for (Map.Entry<Character, Integer> entry : hashMap_s1.entrySet()) {
            if (!hashMap_s2.containsKey(entry.getKey())) return false;
            if (hashMap_s2.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }
}