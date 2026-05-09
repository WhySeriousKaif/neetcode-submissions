class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int maxfreq = 0;
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'A']++;
                maxfreq = Math.max(maxfreq, freq[ch - 'A']);
                int len = j - i + 1;
                int no_of_rep = len - maxfreq;

                if (no_of_rep <= k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
}
