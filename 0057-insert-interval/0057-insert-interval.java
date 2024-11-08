class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // listInterval preparing part.
        List<List<Integer>> listInterval = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> listSubInterval = new ArrayList<>();
            listSubInterval.add(intervals[i][0]);
            listSubInterval.add(intervals[i][1]);
            listInterval.add(listSubInterval);
        }
        List<Integer> listSubInterval = new ArrayList<>();
        listSubInterval.add(newInterval[0]);
        listSubInterval.add(newInterval[1]);
        listInterval.add(listSubInterval);
        Collections.sort(listInterval, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        
        // listAnswer preparing part.
        List<List<Integer>> listAnswer = new ArrayList<>();
        int startInterval = listInterval.get(0).get(0);
        int endInterval = listInterval.get(0).get(1);
        for (int i = 0; i < listInterval.size(); i++) {
            if (listInterval.get(i).get(0) <= endInterval) {
                startInterval = Math.min(startInterval, listInterval.get(i).get(0));
                endInterval = Math.max(endInterval, listInterval.get(i).get(1));
            }
            else {
                List<Integer> listSubAnswer = new ArrayList<>();
                listSubAnswer.add(startInterval);
                listSubAnswer.add(endInterval);
                listAnswer.add(listSubAnswer);
                startInterval = listInterval.get(i).get(0);
                endInterval = listInterval.get(i).get(1);
            }
        }
        List<Integer> listSubAnswer = new ArrayList<>();
        listSubAnswer.add(startInterval);
        listSubAnswer.add(endInterval);
        listAnswer.add(listSubAnswer);
        
        // answerArray preparing part.
        int[][] answerArray = new int[listAnswer.size()][2];
        for (int i = 0; i < listAnswer.size(); i++) {
            answerArray[i][0] = listAnswer.get(i).get(0);
            answerArray[i][1] = listAnswer.get(i).get(1);
        }
        return answerArray;
    }
}