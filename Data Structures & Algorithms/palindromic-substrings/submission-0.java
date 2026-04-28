class Solution {
    public int countSubstrings(String s) {

        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s,i,j)){
                    count++;
                }
            }
        }

        return count;
        
    }
    boolean solve(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}