class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // int min1 = Integer.MAX_VALUE;
        // int min2 = Integer.MAX_VALUE;
        Map<Integer, Integer> hashMap = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     min1 = Math.min(min1, arr[i]);
        //     hashMap.put(arr[i], i);
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     if (arr[i] == min1) continue;
        //     min2 = Math.min(min2, arr[i]);
        // }
        int minAbsDiff = Integer.MAX_VALUE;
        // for (int i = 0; i < arr.length; i++) {
        //     hashMap.put(arr[i],i);
        //     for (int j = i + 1; j < arr.length; j++) {
        //         minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i] - arr[j]));
        //     }
        // }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i + 1] - arr[i]));
            hashMap.put(arr[i], i);
        }
        Set<List<Integer>> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
           int neededValue = arr[i] - minAbsDiff;
           if (hashMap.containsKey(neededValue)) {
               List<Integer> listSubAnswer = new ArrayList<>();
               listSubAnswer.add(arr[i]);
               listSubAnswer.add(neededValue);
               Collections.sort(listSubAnswer);
               hashSet.add(listSubAnswer);
           }
        }
        List<List<Integer>> listAnswer = new ArrayList<>();
        for (List<Integer> list : hashSet) {
            listAnswer.add(list);
        }
        listAnswer.sort((list1, list2) -> {
    int minLength = Math.min(list1.size(), list2.size());
    for (int i = 0; i < minLength; i++) {
        int comparison = Integer.compare(list1.get(i), list2.get(i));
        if (comparison != 0) {
            return comparison;
        }
    }
    return Integer.compare(list1.size(), list2.size());
});

        return listAnswer;
    }
}
