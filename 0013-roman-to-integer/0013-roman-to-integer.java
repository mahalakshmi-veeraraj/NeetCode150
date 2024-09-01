class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int answer = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int currentValue = hashMap.get(s.charAt(i));
            int nextValue = hashMap.get(s.charAt(i + 1));
            
            if (currentValue >= nextValue) {
                answer += currentValue;
            }
            else {
                answer -= currentValue;
            }
        }
        answer += hashMap.get(s.charAt(s.length() - 1));
        return answer;
    }
}
