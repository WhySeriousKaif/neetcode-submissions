class Solution {
    public boolean isAnagram(String s, String t) {
        int l1=s.length();
        int l2=t.length();
        if(l1!=l2) return false;
        int[] charCounts=new int[26];
        for(int i=0;i<l1;i++){
            charCounts[s.charAt(i)-'a']++;
            charCounts[t.charAt(i)-'a']--;
        }
        for(int count:charCounts){
            if(count!=0) return false;
        }

        return true;


    }
}
