class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot_index=findPivot(nums);

        int reqIdx=bSearch(nums,0,pivot_index-1,target); //leftSide of pivot index
        if(reqIdx!=-1){
            return reqIdx;
        }

        reqIdx=bSearch(nums,pivot_index,n-1,target); //right side including pivot index

        return reqIdx;


        
    }
    int findPivot(int[] arr){
        int s=0;
        int e=arr.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(arr[mid]>arr[e]){
                s=mid+1;
            }
            else{
               e=mid;
            }
        }
        return e;

    }
    int bSearch(int[] arr,int s,int e,int target){
        while(s<=e){
            int mid =s+(e-s)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) e=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}