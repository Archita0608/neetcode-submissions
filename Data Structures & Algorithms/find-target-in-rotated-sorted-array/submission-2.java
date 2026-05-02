class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[r]) r=mid;
            else l=mid+1;
            }

            int pivot = l;

            int result = binarySearch(nums, target, 0, pivot - 1);
            if(result!=-1) return result;

            
        
        return binarySearch(nums, target, pivot, nums.length-1);
    }

    public int binarySearch(int[] nums, int target, int left, int right){
        while(left<=right){
            int m = (left+right)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target) left=m+1;
            else right=m-1;
        }
        return -1;
    }
}
