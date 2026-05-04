class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ws = 0, i = 0, n = s.length();
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character,Integer>map=new HashMap<>() ;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        while (i < n) {
            char ch = s.charAt(i);
            // if (set.contains(ch)) {
            if(map.containsKey(ch) && map.get(ch)>=ws){

                ws=map.get(ch)+1;

            }
                // while (ws < i && set.contains(ch)) {
                //     set.remove(s.charAt(ws));
                //     ws++;
                // }
            // }
            // set.add(ch);
            map.put(ch,i);
            maxLen = Math.max(maxLen, i - ws + 1);
            i++;
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
