class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0] , b[0]));
        
        int robotCount = robot.size();
        int factoryCount = factory.length;
        
        List<Integer> factoryPositions = new ArrayList<>();
        for (int i = 0; i < factoryCount; i++) {
            for (int j = 0; j < factory[i][1]; j++) {
                factoryPositions.add(factory[i][0]);
            }
        }
            
        long[][] dp = new long[robotCount][factoryPositions.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return find (robot, factoryPositions, robotCount - 1, factoryPositions.size() - 1, dp);
    }
    private long find (List<Integer> robot, List<Integer> factoryPositions, int robotIndex, int factoryIndex, long[][] dp) {
        if (robotIndex < 0) return 0;
        if (factoryIndex < 0) return (long) 1e12;
        if (dp[robotIndex][factoryIndex] != -1) return dp[robotIndex][factoryIndex];
        
        // Assign robot to the current factory.
        long assign = find (robot, factoryPositions, robotIndex - 1, factoryIndex - 1, dp) + Math.abs(robot.get(robotIndex) - factoryPositions.get(factoryIndex));
        
        // Skip the current factory assignment.
        long skip = find (robot, factoryPositions, robotIndex, factoryIndex - 1, dp);
        
        dp[robotIndex][factoryIndex] = Math.min(assign, skip);
        return dp[robotIndex][factoryIndex];
    }
}