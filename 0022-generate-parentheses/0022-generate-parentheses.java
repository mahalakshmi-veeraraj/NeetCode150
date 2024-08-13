class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> listAnswer = new ArrayList<>();
        StringBuilder sb = new StringBuilder("(");
        find(n, listAnswer, 1, 0, sb);
        return listAnswer;
    }
    private void find (int n, List<String> listAnswer, int open, int close, StringBuilder sb) {
        if (sb.length() == 2 * n) {
            listAnswer.add(sb.toString());
            return;
        }
        if (open < n) {
            find (n, listAnswer, open + 1, close, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            find (n, listAnswer, open, close + 1, sb.append(")"));  
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}