class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int startIndex = 0;
        int gasInTank = 0;
        int costPaid = 0;
        int gasAvailable = 0;
        for (int i = 0; i < n; i++) {
            gasInTank += (gas[i]);
            costPaid += (cost[i]);
            gasAvailable += (gas[i] - cost[i]);
            if (gasAvailable < 0) {
                startIndex = i + 1;
                gasAvailable = 0;
            }
        }
        return costPaid > gasInTank ? -1 : startIndex;
    }
}