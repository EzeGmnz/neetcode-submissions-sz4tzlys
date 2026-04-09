class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);
        
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }    
        
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int start = i+1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    out.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (nums[start] == nums[start-1] && start < end) {
                        start++;
                    }
                }
            }
        }
        return out;
    }
}
