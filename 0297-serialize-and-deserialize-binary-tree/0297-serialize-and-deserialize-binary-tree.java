/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder strBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int queueSize = 0;
        while (!queue.isEmpty()) {
            queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode peekNode = queue.poll();
                if (peekNode != null)
                    strBuilder.append(peekNode.val+",");
                else
                    strBuilder.append("#,");
                if (peekNode != null) {
                    queue.add(peekNode.left);
                    queue.add(peekNode.right);    
                }
            }
        }
        String answerString = strBuilder.toString().substring(0, strBuilder.toString().length() - 1);
        return strBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] treeValues = data.split(",");
        int index = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(treeValues[index++]));
        queue.add(root);
        while (!queue.isEmpty() && index < treeValues.length) {
            TreeNode peekNode = queue.poll();
            TreeNode leftChildNode = treeValues[index].equals("#") ? null : new TreeNode(Integer.valueOf(treeValues[index]));
            index++;
            TreeNode rightChildNode = null;
            if (index < treeValues.length) {
                rightChildNode = treeValues[index].equals("#") ? null : new TreeNode(Integer.valueOf(treeValues[index]));
            }
            index++;
            if (leftChildNode != null) {
                peekNode.left = leftChildNode;
                queue.add(leftChildNode);
            }
            if (rightChildNode != null) {
                peekNode.right = rightChildNode;
                queue.add(rightChildNode);   
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));