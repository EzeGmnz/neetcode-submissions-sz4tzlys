class Solution {
    public int trap(int[] heights) {
        int[] leftMaxs = new int[heights.length];
        int[] rightMaxs = new int[heights.length];

        int currMax = 0;
        for (int i = 0; i < heights.length; i++) {
            leftMaxs[i] = currMax;
            currMax = Math.max(heights[i], currMax);
        }
        
        currMax = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            rightMaxs[i] = currMax;
            currMax = Math.max(heights[i], currMax);
        }

        int trappedWater = 0;
        for (int i = 0; i < heights.length; i++) {
            trappedWater += Math.max(Math.min(leftMaxs[i], rightMaxs[i]) - heights[i], 0);
        }
        return trappedWater;
    }
}
