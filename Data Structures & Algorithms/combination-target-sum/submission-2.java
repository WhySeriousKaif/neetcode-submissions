class Solution {
    List<List<Integer>> ans;
    HashSet<List<Integer>> set;
    int n;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        n=nums.length;
        set=new HashSet<>();
        ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();

        solve(nums,target,0,temp);
        return ans;
        

    }

   public void solve(int[] nums, int target,int i,List<Integer>temp){
    if(target==0){
       if(!set.contains(temp)){
        set.add(temp);
        ans.add(new ArrayList<>(temp));
       }
        return;
    }

    if(i==n || target<0) return ;
    
     
     temp.add(nums[i]);
     solve(nums,target-nums[i],i+1,temp);

     solve(nums,target-nums[i],i,temp);
     temp.remove(temp.size()-1);
     solve(nums,target,i+1,temp);

   }
}
