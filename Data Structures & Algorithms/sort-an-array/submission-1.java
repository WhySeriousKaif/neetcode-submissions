class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int smIdx=i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[smIdx]){
                    smIdx=j;
                }
            }
            swap(i,smIdx,nums);
        }
        return nums;
    }
    void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }    
}