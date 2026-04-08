class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int startNumber = numbers[start];
            int endNumber = numbers[end];

            int sum = startNumber + endNumber;
            if (sum == target) {
                return new int[]{start+1, end+1};
            }
            if (sum < target) {
                start++;
                continue;
            }
            end--;
        }
        return new int[]{};
    }
}
