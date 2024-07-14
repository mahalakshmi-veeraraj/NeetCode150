class Solution {
    class Pair implements Comparable<Pair> {
        String str;
        int val;
        public Pair(String str) {
            this.str = str;
        }
        @Override
        public int compareTo(Pair pair) {
            return Character.compare(this.str.charAt(0), pair.str.charAt(0));
        }
    }
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        int n = formula.length();
        int i = 0;
        while (i < n) {
            char curr = formula.charAt(i);
            // System.out.println("i is "+i);
            if (curr == '(') {
                Map<String, Integer> tm = new TreeMap<>();
                tm.put("(", 1);
                stack.push(tm);
                i++;
            }
            else if (curr == ')') {
                StringBuilder digitSB = new StringBuilder();
                int j = i + 1;
                for (j = i + 1; j < n; j++) {
                    if (!isDigit(formula.charAt(j))) break;
                    digitSB.append(formula.charAt(j));
                }
                int number = digitSB.toString().isEmpty() ? 1 : Integer.valueOf(digitSB.toString());
                List<Map<String, Integer>> listTemp = new ArrayList<>();
                boolean isBreak = false;
                while (!stack.empty()) {
                    if (isBreak) break;
                    Map<String, Integer> m = stack.pop();
                    for (Map.Entry<String, Integer> entry : m.entrySet()) {
                        if (entry.getKey().equals("(")) {
                            isBreak = true;
                            break;
                        }
                        Map<String, Integer> treeM = new TreeMap<>();
                        treeM.put(entry.getKey(), entry.getValue() * number);
                        listTemp.add(treeM);
                    }
                }
                //stack.pop();
                for (int l = listTemp.size() - 1; l >= 0; l--) {
                    stack.push(listTemp.get(l));
                }
                i = j;   
            }
            else if (isUpper(curr)) {
                StringBuilder atomSB = new StringBuilder();
                atomSB.append(curr);
                int j = 0;
                for (j = i + 1; j < n; j++) {
                    if (!isLower(formula.charAt(j))) break;
                    atomSB.append(formula.charAt(j));
                }
                
                StringBuilder countSB = new StringBuilder();
                int k = 0;
                for (k = j; k < n; k++) {
                    if (!isDigit(formula.charAt(k))) break;
                    countSB.append(formula.charAt(k));
                }
                if (countSB.toString().isEmpty()) countSB.append("1");
             
                // System.out.println(atomSB.toString() +"  "+countSB.toString());
                Map<String, Integer> tm = new TreeMap<>();
                tm.put(atomSB.toString(), Integer.valueOf(countSB.toString()));
                stack.push(tm);
                
                // System.out.println("k value is "+k);
                i = k;
            }
        }
        
        Map<String, Integer> finalMap = new TreeMap<>();
        while(!stack.empty()) {
            Map<String, Integer> tm = stack.pop();
            for (Map.Entry<String, Integer> entry : tm.entrySet()) {
                if (!finalMap.containsKey(entry.getKey())) {
                    finalMap.put(entry.getKey(), entry.getValue());
                }        
                else {
                    finalMap.put(entry.getKey(), entry.getValue() + finalMap.get(entry.getKey()));
                }
            }
        }

        List<Pair> listPair = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : finalMap.entrySet()) {
            Pair pair = new Pair(entry.getKey());
            if (entry.getValue() != 1) pair.val = entry.getValue();
            listPair.add(pair);
        }
        Collections.sort(listPair);
        
        StringBuilder ansSB = new StringBuilder();
        for (Pair p : listPair) {
            ansSB.append(p.str);
            if (p.val != 0) ansSB.append(p.val);
        }
        return ansSB.toString();
    }
    private boolean isUpper(char ch) {
        int ascii = ch;
        return ascii >= 65 && ascii <= 90;
    }
    private boolean isLower(char ch) {
        int ascii = ch;
        return ascii >= 97 && ascii <= 122;
    }
    private boolean isDigit(char ch) {
        int ascii = ch;
        return ascii >= 48 && ascii <= 57;
    }
}