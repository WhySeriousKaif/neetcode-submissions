class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        // String ans = "";
        int l = prefix.length();
        int n=strs.length;
        for(int i=1;i<n;i++){
            prefix=findPrefix(strs[i],prefix);

            if (prefix.length() == 0) {
                return "";
            }
        }

        return prefix;



      
    }
  String  findPrefix(String str,String pre){
        int currLen=str.length();
        int preLen=pre.length();
        int len=Math.min(currLen,preLen);
        int idx=0;
        while(idx<len){
            if(str.charAt(idx)!=pre.charAt(idx)){
                break;
            }
            idx++;
        }
        return pre.substring(0,idx);
        
    }

}