class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        // prefix
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                prefix[i] = prefix[i-1] * nums[i];
            } else {
                prefix[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(prefix));
        // sufix
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i < nums.length - 1) {
                suffix[i] = suffix[i + 1] * nums[i];
            } else {
                suffix[i] = nums[i];
            }
        }
        System.out.println(Arrays.toString(suffix));


        int[] out = new int[nums.length];
        // A[i] = prefix[i-1] * suffix[i+1]
        int current = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                current *= prefix[i-1];
            }
            if (i < nums.length - 1) {
                current *= suffix[i+1];
            }
            out[i] = current;
            current = 1;
        }

        return out;
    }
}  
