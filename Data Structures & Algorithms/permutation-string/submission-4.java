class Solution {

    public boolean checkInclusion(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        if (n > m) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // frequency of s1
        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        int L = 0;

        for (int R = 0; R < m; R++) {

            // add current character
            freq2[s2.charAt(R) - 'a']++;

            // maintain window size
            if (R - L + 1 > n) {

                freq2[s2.charAt(L) - 'a']--;

                L++;
            }

            // compare when window size becomes n
            if (R - L + 1 == n) {

                if (Arrays.equals(freq1, freq2)) {
                    return true;
                }
            }
        }

        return false;
    }
}