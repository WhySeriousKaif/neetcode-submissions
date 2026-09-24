
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        int n = strs.length;

        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {

            String temp = strs[i];

            // Convert string to character array
            char[] chars = temp.toCharArray();

            // Sort characters
            Arrays.sort(chars);

            // Convert back to String
            temp = new String(chars);

            // Add original string to its anagram group
            mp.computeIfAbsent(temp, k -> new ArrayList<>())
              .add(strs[i]);
        }

        // Add all groups to result
        for (List<String> group : mp.values()) {
            result.add(group);
        }

        return result;
    }
}