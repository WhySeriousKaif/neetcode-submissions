class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int[] target=new int[128];

        for(char ch:t.toCharArray()){
            target[ch]++;
        }
        int minLen=Integer.MAX_VALUE;
        String ans ="";

        for(int i=0;i<n;i++){
            int[] freq=new int[128];

            for(int j=i;j<n;j++){
                char ch=s.charAt(j);

                freq[ch]++;
                if(isValid(freq,target)){
                    int len=j-i+1;
                    if(minLen>len){
                        minLen=len;
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        return ans;
        
    }

    public boolean isValid(int[] freq,int[] target){
        for(int i=0;i<128;i++){
            if(freq[i]<target[i]){
                return false;
            }
        }

        return true;
    }
}
