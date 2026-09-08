class Solution {
    public int reverse(int x) {
        int MIN_INT = -(1 << 31);
        int MAX_INT = (1 << 31) - 1;

        long reversed = 0;
        int n = Math.abs(x);

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        if (x < 0) {
            reversed = -reversed;
        }

        if (reversed < MIN_INT || reversed > MAX_INT) {
            return 0;
        }

        return (int) reversed;
    }
}