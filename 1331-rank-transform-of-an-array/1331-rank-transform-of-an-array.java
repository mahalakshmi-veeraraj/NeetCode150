class Solution {
    public int[] arrayRankTransform(int[] input) {
        Integer[] arr = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = input[i];
        }
        Set<Integer> hashSet = new TreeSet<>((a,b)->b-a);
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        int rank = hashSet.size();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer key : hashSet) {
            hashMap.put(key, rank--);
        }
        int[] answerArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answerArray[i] = hashMap.get(arr[i]);
        }
        return answerArray;
    }
}