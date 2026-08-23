public class Codec {

    void dfs(TreeNode curr, StringBuilder st) {
        if (curr == null) {
            st.append("*,");
            return;
        }

        st.append(curr.val).append(",");

        dfs(curr.left, st);
        dfs(curr.right, st);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder st = new StringBuilder();
        dfs(root, st);
        return st.toString();
    }

    int idx;

    TreeNode build(String[] arr) {
        if (arr[idx].equals("*")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        idx++;

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        idx = 0;

        return build(arr);
    }
}