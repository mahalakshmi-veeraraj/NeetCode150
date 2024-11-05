class Solution {
    public int minChanges(String s) {
        int answer = 0;
        int n = s.length();
        for (int i = 0; i < n; i+=2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                answer++;
            }
        }
        return answer;
    }
}
