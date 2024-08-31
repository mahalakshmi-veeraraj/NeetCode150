class Solution {
    String[] belowTen = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] belowHundred = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        return find(num, new StringBuilder());
    }
    private String find (int num, StringBuilder sb) {
        if (num < 10) return belowTen[num];
        else if (num < 20) return belowTwenty[num % 10];
        else if (num < 100) return belowHundred[num / 10] + (num % 10 != 0 ? " "+belowTen[num % 10]:"");
        else if (num < 1000) return belowTen[num / 100] +" Hundred"+(num % 100 != 0 ? " "+find(num % 100, sb):"");
        else if (num < 1000000) return find(num / 1000, sb) + " Thousand"+(num % 1000 != 0 ? " "+find(num % 1000, sb):"");
        else if (num < 1000000000) return find(num / 1000000, sb) + " Million" + (num % 1000000 != 0 ? " "+find(num % 1000000, sb):"");
        else return find(num / 1000000000, sb) +" Billion"+(num % 1000000000 != 0 ? " "+find(num % 1000000000, sb):"");
    }
}

