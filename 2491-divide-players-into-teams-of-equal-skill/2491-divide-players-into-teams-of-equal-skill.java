class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int nDivBy2 = n / 2;
        int sum = 0;
        List<List<Integer>> listPair = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sum += skill[i];
            hashMap.put(skill[i], hashMap.getOrDefault(skill[i],0)+1);
        }
        int k = sum / nDivBy2;
        for (int i = 0; i < n; i++) {
            if (!hashMap.containsKey(skill[i])) continue;
            hashMap.put(skill[i], hashMap.get(skill[i])-1);
            if (hashMap.get(skill[i]) == 0) hashMap.remove(skill[i]);
            int neededValue = k - skill[i];
            if (hashMap.containsKey(neededValue)) {
                List<Integer> listSubPair = new ArrayList<>();
                listSubPair.add(skill[i]);
                listSubPair.add(neededValue);
                listPair.add(listSubPair);
                hashMap.put(neededValue, hashMap.get(neededValue) - 1);
                if (hashMap.get(neededValue) == 0) hashMap.remove(neededValue);
            }
            else {
                return -1;
            }
        }
        long answer = 0;
        for (List<Integer> val : listPair) {
            answer += (val.get(0) * val.get(1));
        }
        return answer;
    }
}
