class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        int startNumber = numbers[start];
        int endNumber = numbers[end];
        while (start < end) {
            int sum = startNumber + endNumber;
            if (sum == target) {
                return new int[]{ start+1, end+1 };
            } else if (sum < target) {
                startNumber = numbers[++start];
            } else {
                endNumber = numbers[--end];
            }
        }
        return new int[]{};
    }
}
