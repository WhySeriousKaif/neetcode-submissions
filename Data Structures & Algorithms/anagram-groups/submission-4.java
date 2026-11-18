
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> temp = new ArrayList<>();
            if (!visited[i]) {
                temp.add(strs[i]);
                visited[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (!visited[j] && isAnagram(strs[i], strs[j])) {
                        temp.add(strs[j]);
                        visited[j] = true;
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2)
            return false;
        int[] charCounts = new int[26];
        for (int i = 0; i < l1; i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) {
            if (count != 0)
                return false;
        }

        return true;
    }
}