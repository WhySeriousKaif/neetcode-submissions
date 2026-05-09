class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // impossible case
        if (n > m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // frequency of s1
        for (int i = 0; i < n; i++) {

            freq1[s1.charAt(i) - 'a']++;

            freq2[s2.charAt(i) - 'a']++;
        }

        // check first window
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        // sliding window
        for (int i = n; i < m; i++) {

            // add new character
            freq2[s2.charAt(i) - 'a']++;

            // remove left character
            freq2[s2.charAt(i - n) - 'a']--;

            // compare frequencies
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}