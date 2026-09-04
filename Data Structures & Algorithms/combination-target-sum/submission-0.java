class Solution {
     List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       
       ans=new ArrayList<>();
       List<Integer>temp=new ArrayList<>();
       solve(0,nums,target,temp);
       

       return ans;

        
    }
    void  solve(int start,int[] nums,int target,List<Integer>temp){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return ;
        }
         if (start == nums.length || target < 0) {
            return;
        }
        temp.add(nums[start]);
        solve(start,nums,target-nums[start],temp);
        temp.remove(temp.size()-1);
        solve(start+1,nums,target,temp);
    }
}
