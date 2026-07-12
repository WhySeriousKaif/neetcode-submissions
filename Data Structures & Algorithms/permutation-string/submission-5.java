class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency map of s1
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        int windowSize = s1.length();

        // Check every window of size s1.length()
        for (int i = 0; i <= s2.length() - windowSize; i++) {

            HashMap<Character, Integer> map2 = new HashMap<>();

            // Build frequency map for current window
            for (int j = i; j < i + windowSize; j++) {
                char ch = s2.charAt(j);
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            }

            // Compare the two maps
            if (map1.equals(map2)) {
                return true;
            }
        }

        return false;
    }
}