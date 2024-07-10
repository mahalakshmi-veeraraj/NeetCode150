class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> listAnswer = new ArrayList<>();
        find(listAnswer, new ArrayList<>(), s, 0);
        return listAnswer;
    }
    private void find (List<String> listAnswer, List<String> listSubAnswer, String s, int index) {        
        int dotCount = getDotCount(listSubAnswer);
        if (dotCount >= 3) {
            if (dotCount == 3 && index < s.length()) {
                if (isValidIPNumber(s.substring(index))) {
                    String ans = convert(listSubAnswer) + s.substring(index);
                    if (!isHasTrailingZeros(s.substring(index))) listAnswer.add(ans);    
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isValidIPNumber(sb.toString()) && !isHasTrailingZeros(sb.toString())) {
                listSubAnswer.add(sb.toString());
                listSubAnswer.add(".");
                find (listAnswer, listSubAnswer, s, i + 1);
                listSubAnswer.remove(listSubAnswer.size() - 1);
                listSubAnswer.remove(listSubAnswer.size() - 1);
            }
        }
    }
    private boolean isValidIPNumber (String s) {
        try {
            int num = Integer.valueOf(s);
            return num >= 0 && num <= 255;
        }catch(NumberFormatException e) {
            return false;
        }
    }
    private int getDotCount (List<String> list) {
        int dotCount = 0;
        for (String s : list) {
            if (s.equals(".")) dotCount++;
        }
        return dotCount;
    }       
    private String convert (List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);
        return sb.toString();
    }
    private boolean check (String s) {
        String[] splittedArr = s.split(".");
        for (int i = 0; i < splittedArr.length; i++) {
            String s1 = splittedArr[i];
            if (isHasTrailingZeros(s1)) return false;         
        }
        return true;
    }
    private boolean isHasTrailingZeros(String s) {
        int zerosCount = 0;
        int nonZerosCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (nonZerosCount == 0 && s.length() != 1) return true;
                zerosCount++;
            }
            else {
                nonZerosCount++;
            }
        }
        return false;
    }
}