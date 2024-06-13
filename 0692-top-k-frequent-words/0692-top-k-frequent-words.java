class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            hashMap.put(words[i], hashMap.getOrDefault(words[i], 0) + 1);
        }
        List<String> listAnswer = 
            hashMap
            .entrySet()
            .stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        return listAnswer;
    }
}