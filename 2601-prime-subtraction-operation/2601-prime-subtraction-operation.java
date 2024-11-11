class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }
        boolean[] sieve = new boolean[maxElement + 1];
        preparePrimeArray(sieve);
        
        int currValue = 1;
        int i = 0;
        while (i < nums.length) {
            // Store the difference needed to make nums[i] equal to currValue.
            int difference = nums[i] - currValue;

            // If difference is less than 0, then nums[i] is already less than
            // currValue. Return false in this case.
            if (difference < 0) {
                return false;
            }

            // If the difference is prime or zero, then nums[i] can be made
            // equal to currValue.
            if (sieve[difference] == true || difference == 0) {
                i++;
                currValue++;
            } else {
                // Otherwise, try for the next currValue.
                currValue++;
            }
        }
        
        return true;
    }
    private void preparePrimeArray (boolean[] primeArr) {
        int n = primeArr.length;
        for (int i = 0; i < n; i++) primeArr[i] = true;
        primeArr[1] = false;
        int k = 0;
        for (int i = 2; i * i < n; i++) {
            if (!primeArr[i]) continue;
            k = 2;
            for (int j = i * k; j < n; j = i * k) {
                primeArr[j] = false;
                k++;
            }
        }
    }
}