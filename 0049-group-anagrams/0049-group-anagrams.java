class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            if (hashMap.containsKey(sortedStr)) {
                List<String> listSubAnswer = hashMap.get(sortedStr);
                listSubAnswer.add(strs[i]);
            }
            else {
                List<String> listSubAnswer = new ArrayList<>();
                listSubAnswer.add(strs[i]);
                hashMap.put(sortedStr, listSubAnswer);
            }
        }
        List<List<String>> listAnswer = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hashMap.entrySet()) {
            listAnswer.add(entry.getValue());
        }
        return listAnswer;
    }
}