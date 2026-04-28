

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        String[] sortedArr = new String[n];

        // Step 1: Create sorted version of each string
        for (int i = 0; i < n; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sortedArr[i] = new String(chars);
        }
  
        // Step 2: Keep track of visited strings
        boolean[] visited = new boolean[n];
        List<List<String>> result = new ArrayList<>();

        // Step 3: Compare each with all others
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                visited[i] = true;

                for (int j = i + 1; j < n; j++) {
                    if (!visited[j] && sortedArr[i].equals(sortedArr[j])) {
                        group.add(strs[j]);
                        visited[j] = true;
                    }
                }
                result.add(group);
            }
        }

        return result;
    }
}