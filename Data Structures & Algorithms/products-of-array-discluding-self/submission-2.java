class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[nums.length];
        Arrays.fill(res,1);
        int pre=1,post=1;

        for(int i=0;i<n;i++){
            res[i]=pre;
            pre=nums[i]*pre;

        }
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*post;
            post=post*nums[i];

        }
        return res;
        
         
    }
}  
