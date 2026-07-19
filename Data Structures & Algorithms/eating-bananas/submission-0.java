class Solution {
    boolean canEatBananas(int[] piles,int mid,int h){
        int actualHour=0;
        for(int x: piles){
            actualHour+=x/mid;
            if(x%mid!=0){
                actualHour++;
            }
        }
        return actualHour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            if(max<piles[i]) max=piles[i];

        }
        r=max;
       while(l<r){
        int mid=l+(r-l)/2;
          if(canEatBananas(piles,mid,h)){
             r=mid;

          }
          else{
            l=mid+1;
          }
       }
       return r;
        
    }
}