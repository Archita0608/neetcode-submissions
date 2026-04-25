class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return false;

     Set<Integer> map = new HashSet<>();
    for (int num : nums){
        if (map.contains(num))
            return true;
    map.add(num);
    }

    return false;
    }

   
}