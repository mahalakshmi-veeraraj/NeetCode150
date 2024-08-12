class Solution {
    public String reverseWords(String s) {
        List<String> listWord = getWords(s);
        int left = 0;
        int right = listWord.size() - 1;
        while (left < right) {
            String temp = listWord.get(right);
            listWord.set(right, listWord.get(left));
            listWord.set(left, temp);
            left++;
            right--;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < listWord.size(); i++) {
            answer.append(listWord.get(i));
            if (i != listWord.size() - 1) answer.append(" ");
        }
        return answer.toString();
    }
    private List<String> getWords(String s) {
        List<String> listWord = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!sb.toString().isEmpty()) {
                    listWord.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            else sb.append(s.charAt(i));
        }
        if (!sb.toString().isEmpty()) listWord.add(sb.toString()); 
        return listWord;
    }
}