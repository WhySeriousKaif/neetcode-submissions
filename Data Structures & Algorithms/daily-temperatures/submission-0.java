class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] result = new int[n];

        // check every day
        for (int i = 0; i < n; i++) {

            // search future days
            for (int j = i + 1; j < n; j++) {

                // warmer temperature found
                if (temperatures[j] > temperatures[i]) {

                    result[i] = j - i;

                    break;
                }
            }
        }

        return result;
    }
}