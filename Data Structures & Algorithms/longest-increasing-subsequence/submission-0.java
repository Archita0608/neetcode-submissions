class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> tails = new ArrayList<>();

        for (int x : nums){
            if (tails.isEmpty() || x > tails.get(tails.size() - 1)){
                tails.add(x);
            }

            else{
                int left = 0, right = tails.size() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails.get(mid) < x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        tails.set(left, x);
    }
    
    }
    return tails.size();
  }
}

