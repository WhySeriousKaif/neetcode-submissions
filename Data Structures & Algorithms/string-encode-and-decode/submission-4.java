class Solution {

    public String encode(List<String> strs) {
        StringBuilder st=new StringBuilder();
        for(String str:strs){
            st.append(str.length()).append("#").append(str);

        }

        return st.toString();

    }

    public List<String> decode(String str) {
        List<String>res=new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int hashIndex=str.indexOf("#",i);
            int startIndex=hashIndex+1;
            int len=Integer.parseInt(str.substring(i,hashIndex));
            String word=str.substring(startIndex,startIndex+len);
            res.add(word);
            i=startIndex+len;
        }
        return res;

    }
}
