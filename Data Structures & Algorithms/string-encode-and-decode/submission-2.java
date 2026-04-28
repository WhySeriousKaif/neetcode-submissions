class Solution {
    public String encode(List<String> strs) {
        // neet code love you
        // "4,4,4,3,#neetcodeloveyou"
        //
        if (strs.isEmpty())
            return "";
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            int len = str.length();
            res.append(len);
            res.append(",");
        }
        // delimiter
        res.append("#");

        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
    public List<String> decode(String str) {
        if(str.length()==0) return new ArrayList<>();
        List<String>res=new ArrayList<>();
        List<Integer>sizes=new ArrayList<>();

        int i=0;
        while(str.charAt(i)!='#'){
            StringBuilder curr=new StringBuilder();
            while(str.charAt(i)!=','){
                curr.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(curr.toString()));
            i++;
        }
        i++;
        for(int size:sizes){
            res.add(str.substring(i,i+size));
            i+=size;
        }
        return res;
    }
}
