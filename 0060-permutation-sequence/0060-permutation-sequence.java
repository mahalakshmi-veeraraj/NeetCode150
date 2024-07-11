class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> listNumber = new ArrayList<>();
        for (int i = 1; i <= n; i++) listNumber.add(i);
        int count = 0;
        int tempN = n;
        int tempK = k - 1;
        StringBuilder sb = new StringBuilder();
        while (count < n) {
            int fact = fact(tempN); 
            if (tempN != 0) {
                sb.append(listNumber.get(tempK / (fact / tempN)));
                listNumber.remove(tempK / (fact / tempN));
                tempK = tempK % (fact / tempN);
                tempN--;   
            }
            count++;
        }
        return sb.toString();
    }
    public int fact (int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        System.out.println("Factorial value is "+fact);
        return fact;
    }
}