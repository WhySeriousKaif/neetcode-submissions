class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] mp = new int[26];

        // Count frequency of each task
        for (char ch : tasks) {
            mp[ch - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> max =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add frequencies to heap
        for (int i = 0; i < 26; i++) {
            if (mp[i] > 0) {
                max.add(mp[i]);
            }
        }

        int time = 0;

        while (!max.isEmpty()) {

            ArrayList<Integer> temp = new ArrayList<>();

            // One cycle has n + 1 positions
            for (int i = 0; i <= n; i++) {

                if (!max.isEmpty()) {
                    int freq = max.poll();
                    freq--;

                    if (freq > 0) {
                        temp.add(freq);
                    }

                    time++;
                } 
                else {
                    // No task available, but if there are
                    // remaining tasks in temp, this is idle time
                    if (!temp.isEmpty()) {
                        time++;
                    } else {
                        break;
                    }
                }
            }

            // Put remaining frequencies back into heap
            for (int freq : temp) {
                max.add(freq);
            }
        }

        return time;
    }
}