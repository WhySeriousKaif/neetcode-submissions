class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n;i++){
            int curr=nums[i];
            int preIdx=i-1;
            while(preIdx>=0 && nums[preIdx]>curr){
                nums[preIdx+1]=nums[preIdx];
                preIdx--;
            }
            nums[preIdx+1]=curr;
        }

        return nums;
        
    }
}