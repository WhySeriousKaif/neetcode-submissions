class Solution {
    public String multiply(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] product = new int[n + m];

        // Check for negative signs
        boolean negative = false;

        if (s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
            n--;
        }

        if (s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
            m--;
        }

        // Remove leading zeros
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");

        if (s1.isEmpty() || s2.isEmpty()) {
            return "0";
        }

        n = s1.length();
        m = s2.length();

        product = new int[n + m];

        // Multiply digit by digit
        for (int i = n - 1; i >= 0; i--) {

            int n1 = s1.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j--) {

                int n2 = s2.charAt(j) - '0';

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int pro = n1 * n2 + product[pos2];

                product[pos2] = pro % 10;
                product[pos1] += pro / 10;
            }
        }

        // Convert array to string
        StringBuilder result = new StringBuilder();

        for (int digit : product) {
            if (result.length() == 0 && digit == 0) {
                continue;
            }

            result.append(digit);
        }

        if (negative) {
            result.insert(0, '-');
        }

        return result.toString();
    }
}