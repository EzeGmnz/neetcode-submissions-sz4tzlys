class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int currMax = -1;
        while (start < end) {
            int startHeight = heights[start];
            int endHeight = heights[end];
            int containerWater = (end - start) * Math.min(startHeight, endHeight);

            currMax = Math.max(currMax, containerWater);

            if (startHeight <= endHeight) {
                start++;
            } else {
                end--;
            } 
        }

        return currMax;
    }
}


// [1,6,2,5,4,7,12,6]
//  