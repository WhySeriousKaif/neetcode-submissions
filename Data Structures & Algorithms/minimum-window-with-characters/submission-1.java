class Solution {

    public String minWindow(String s, String t) {

        int[] target = new int[128];

        // frequency of t
        for (char ch : t.toCharArray()) {
            target[ch]++;
        }

        int required = t.length();

        int L = 0;

        int minLen = Integer.MAX_VALUE;

        int start = 0;

        for (int R = 0; R < s.length(); R++) {

            char rightChar = s.charAt(R);

            // useful character found
            if (target[rightChar] > 0) {
                required--;
            }

            // decrease frequency
            target[rightChar]--;

            // valid window
            while (required == 0) {

                int windowLen = R - L + 1;

                // update answer
                if (windowLen < minLen) {

                    minLen = windowLen;

                    start = L;
                }

                char leftChar = s.charAt(L);

                // remove left character
                target[leftChar]++;

                // window becomes invalid
                if (target[leftChar] > 0) {
                    required++;
                }

                L++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}