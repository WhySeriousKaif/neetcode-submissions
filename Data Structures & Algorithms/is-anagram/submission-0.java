class Solution {
    public boolean isAnagram(String s, String t) {
        // Brute force approach

        if (s.length() != t.length()) return false;

        StringBuilder sb2 = new StringBuilder(t);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb2.indexOf(String.valueOf(c)); // find in t

            if (index != -1) {
                sb2.deleteCharAt(index); // remove matched character
            } else {
                return false; // char not found
            }
        }

        return sb2.length() == 0; // all characters matched
    }
}