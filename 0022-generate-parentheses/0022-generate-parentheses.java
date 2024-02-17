class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> listAnswer = new ArrayList<>();
        genParenthesis(1, 0, "(", listAnswer, n);
        return listAnswer;
    }
    private void genParenthesis (int open, int close, String str, List<String> listAnswer, int n) {
        if (open > n) {
            return;
        }
        if (str.length() == 2 * n) {
            listAnswer.add(str);
            return;
        }
        genParenthesis(open + 1, close, str + "(", listAnswer, n);
        if (open > close)
            genParenthesis(open, close + 1, str + ")", listAnswer, n);
    }
}