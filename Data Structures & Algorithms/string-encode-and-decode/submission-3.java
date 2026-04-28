class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            // find '#'
            int hashIndex = str.indexOf('#', i);

            // get length
            int len = Integer.parseInt(str.substring(i, hashIndex));

            // move to start of actual string
            int start = hashIndex + 1;

            // extract string using length
            String word = str.substring(start, start + len);

            // add to result
            res.add(word);

            // move pointer forward
            i = start + len;
        }

        return res;
    }
}
