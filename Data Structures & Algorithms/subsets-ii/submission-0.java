class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset){
        res.add(new ArrayList<>(subset));

        for(int i = idx; i<nums.length; i++){
            if(i>idx && nums[i] == nums[i-1]){
                continue;
            }

            subset.add(nums[i]);
            backtrack(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }
}
