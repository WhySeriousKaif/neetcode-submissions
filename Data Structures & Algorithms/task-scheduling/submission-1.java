class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequencies
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int maxFreq = freq[25];

        // Number of gaps between the most frequent tasks
        int gaps = maxFreq - 1;

        // Maximum possible idle slots
        int idleSlots = n * gaps;

        // Fill idle slots using other tasks
        for (int i = 24; i >= 0; i--) {

            idleSlots -= Math.min(freq[i], gaps);

            if (idleSlots <= 0) {
                return tasks.length;
            }
        }

        // Remaining idle slots have to be actual idle time
        return tasks.length + idleSlots;
    }
}