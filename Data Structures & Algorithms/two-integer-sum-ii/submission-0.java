class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int n=numbers.length;
        int j=n-1;
        while(i<j){
            int sum=numbers[i]+numbers[j];
            if(sum==target) return new int[]{i+1,j+1};
            else if(target>sum) i++;
            else j--;
        }
        return new int[]{0,0};
        
    }
}
