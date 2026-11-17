class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        String ans = "";
        int l = first.length();

        for (int i = 0; i < l; i++) {
            boolean match = true;

            for (int j = 1; j < strs.length; j++) {
                String currStr = strs[j];
                int curLen = currStr.length();

                // The remaining strings do not need to be as long as the first string.

                // They only need to contain characters at the index we're currently checking.
                if (curLen <= i || first.charAt(i) != currStr.charAt(i)) {
                    match = false;
                    break;
                }
            }

            if (match == false) {
                break;
            }

            ans += first.charAt(i);
        }
        //The prefix collected before the first mismatch is your answer.

        return ans;
    }
}