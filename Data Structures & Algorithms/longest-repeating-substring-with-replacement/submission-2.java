class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[] freq=new int[26];
        int maxLen=0;
        int L=0;
        int maxFreq=0;
        for(int R=0;R<n;R++){

            char ch=s.charAt(R);

            freq[ch-'A']++;
            maxFreq=Math.max(maxFreq, freq[ch-'A']);

            int windowSize=R-L+1;
            int rep=windowSize-maxFreq;
            if(rep>k){
                freq[s.charAt(L)-'A']--;
                L++;
                windowSize=R-L+1;
                rep=windowSize-maxFreq;

            }
            maxLen=Math.max(maxLen,windowSize);

        }
        return maxLen;
        
    }
}
