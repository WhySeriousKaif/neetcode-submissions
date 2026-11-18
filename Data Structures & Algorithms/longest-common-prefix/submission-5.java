class Solution {
    class TreeNode {
        TreeNode[] children;
        boolean isEnd;
        TreeNode() {
            children = new TreeNode[26];
            isEnd = false;
        }
    }
    TreeNode root = new TreeNode();
    public void insert(String word) {
        TreeNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TreeNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        for (String str : strs) {
            insert(str);
        }
        TreeNode curr = root;
        while (curr.isEnd == false) {
            int count = 0;
            int nextIndex = -1;

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                    nextIndex = i;
                }
            }
            if (count != 1) {
                break;
            }
            ans += (char) ('a' + nextIndex);
            curr = curr.children[nextIndex];
        }

        return ans;
    }
}