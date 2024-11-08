class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<List<Integer>> listAnswer = new ArrayList<>();
        
        int breakIndex = -1;
        for (int i = 0; i < n; i++) {
            if (intervals[i][1] < newInterval[0]) {
                List<Integer> listSubAnswer = new ArrayList<>();
                listSubAnswer.add(intervals[i][0]);
                listSubAnswer.add(intervals[i][1]);
                listAnswer.add(listSubAnswer);
            } 
            else {
                breakIndex = i;
                break;
            }
        }
        
        if (breakIndex == -1) {
            List<Integer> listSubAnswer = new ArrayList<>();
            listSubAnswer.add(newInterval[0]);
            listSubAnswer.add(newInterval[1]);
            listAnswer.add(listSubAnswer);
            return getAnswerArray(listAnswer);
        }
        
        int startInterval = newInterval[0];
        int endInterval = newInterval[1];
        for (int i = breakIndex; i < n; i++) {
            if (intervals[i][0] <= endInterval) {
                startInterval = Math.min(startInterval, intervals[i][0]);
                endInterval = Math.max(endInterval, intervals[i][1]);
            }
            else {
                List<Integer> listSubAnswer = new ArrayList<>();
                listSubAnswer.add(startInterval);
                listSubAnswer.add(endInterval);
                listAnswer.add(listSubAnswer);
                startInterval = intervals[i][0];
                endInterval = intervals[i][1];
            }
        }
        List<Integer> listSubAnswer = new ArrayList<>();
        listSubAnswer.add(startInterval);
        listSubAnswer.add(endInterval);
        listAnswer.add(listSubAnswer);
        
        return getAnswerArray(listAnswer);
    }
    private int[][] getAnswerArray (List<List<Integer>> listAnswer) {
        int[][] answerArray = new int[listAnswer.size()][2];
        for (int i = 0; i < listAnswer.size(); i++) {
            answerArray[i][0] = listAnswer.get(i).get(0);
            answerArray[i][1] = listAnswer.get(i).get(1);
        }
        return answerArray;
    }
}