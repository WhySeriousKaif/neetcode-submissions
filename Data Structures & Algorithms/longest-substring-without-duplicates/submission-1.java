class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxLength=1;
        for(int i=0;i<s.length();i++){
            int len=1;
            HashSet<Character>set=new HashSet<>();
            set.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                    len++;
                    maxLength=Math.max(maxLength,len);
                }
                else{
                    break;
                }



            }
        }
        return maxLength;
        
    }
}
