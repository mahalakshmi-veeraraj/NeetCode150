class Solution {
    class Pair implements Comparable<Pair> {
        int startTime;
        int endTime;
        public Pair(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public int compareTo (Pair pair) {
            
            return this.startTime - pair.startTime;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Pair> listPair = new ArrayList<>();
        for (int row = 0; row < intervals.length; row++) {
            listPair.add(new Pair(intervals[row][0], intervals[row][1]));
        }
        Collections.sort(listPair);
        int startTime = listPair.get(0).startTime;
        int endTime = listPair.get(0).endTime;
        List<Pair> listAnswer = new ArrayList<>();
        for (int i = 1; i < listPair.size(); i++) {
            Pair currPair = listPair.get(i);
            if (currPair.startTime <= endTime) {
                startTime = Math.min(startTime, currPair.startTime);
                endTime = Math.max(endTime, currPair.endTime);
            }
            else {
                listAnswer.add(new Pair(startTime, endTime));
                startTime = currPair.startTime;
                endTime = currPair.endTime;
            }
        }
        listAnswer.add(new Pair(startTime, endTime));
        int[][] answerArray = new int[listAnswer.size()][2];
        for (int i = 0; i < listAnswer.size(); i++) {
            answerArray[i][0] = listAnswer.get(i).startTime;
            answerArray[i][1] = listAnswer.get(i).endTime;
        }
        return answerArray;
    }
}