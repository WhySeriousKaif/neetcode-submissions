class Solution {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency of t
        for (char ch : t.toCharArray()) {

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int required = t.length();

        int L = 0;

        int minLen = Integer.MAX_VALUE;

        int start = 0;

        for (int R = 0; R < s.length(); R++) {

            char rightChar = s.charAt(R);

            // useful character
            if (map.containsKey(rightChar)) {

                if (map.get(rightChar) > 0) {
                    required--;
                }

                map.put(rightChar, map.get(rightChar) - 1);
            }

            // valid window
            while (required == 0) {

                int windowLen = R - L + 1;

                // update minimum answer
                if (windowLen < minLen) {

                    minLen = windowLen;

                    start = L;
                }

                char leftChar = s.charAt(L);

                // shrink window
                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    // window becomes invalid
                    if (map.get(leftChar) > 0) {
                        required++;
                    }
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