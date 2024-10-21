class Solution {
    int answer = 0;
    public int maxUniqueSplit(String s) {
        find (s, new HashSet<>());
        return answer;
    }
    private void find (String s, Set<String> hashSet) {
        // Base case.
        if (s.trim().isEmpty()) {
            answer = Math.max(answer, hashSet.size());
            return;
        }
        
        // Recurrence Relation.
        StringBuilder sb;
        for (int i = 1; i <= s.length(); i++) {
            sb = new StringBuilder();
            sb.append(s.substring(0, i));
            if (hashSet.contains(sb.toString())) continue;
            
            String objectBeingAdded = sb.toString();
            hashSet.add(objectBeingAdded);
            find(s.substring(i), hashSet);
            hashSet.remove(objectBeingAdded);
        }
    }
}