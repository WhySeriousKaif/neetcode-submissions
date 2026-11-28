class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=1;i<=n;i++){
            boolean found=false;
            // for(int j=0;j<n;j++){
            //     if(nums[j]==i){
            //         found=true;
            //     }
            // }
            if(set.contains(i)){
                found=true;
            }
            if(!found){
                return i;
            }
        }
        return n+1;
        
    }
}