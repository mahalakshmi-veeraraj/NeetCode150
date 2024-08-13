class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (sb.toString().equals("..")) {
                    if (!stack.empty()) stack.pop();
                }
                else if (!sb.toString().isEmpty() && !sb.toString().equals(".")) {
                   stack.push(sb.toString());
                }    
                sb = new StringBuilder();
            }
            else sb.append(path.charAt(i));
        }
        if (sb.toString().equals("..")) {
            if (!stack.empty()) stack.pop();
        }
        else if (!sb.toString().isEmpty() && !sb.toString().equals(".")) {
            stack.push(sb.toString());
        }
        StringBuilder simplifiedPath = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            simplifiedPath.append("/"+stack.get(i));
        }
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}
