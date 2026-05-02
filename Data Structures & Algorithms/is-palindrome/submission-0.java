class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // Move the left pointer until we find an alphanumeric character
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Move the right pointer until we find an alphanumeric character
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}