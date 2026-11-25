class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int f=nums.length/3;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        List<Integer>res=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()>f){
                res.add(entry.getKey());
            }
        }
        return res;
        
    }
}