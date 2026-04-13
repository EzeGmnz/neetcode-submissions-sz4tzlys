class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        int start = 0;
        int end = 0;

        while (end < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[end]) {
                deque.removeLast();
            }
            deque.addLast(end);

            if (deque.getFirst() < start) {
                deque.removeFirst();
            }

            if (end >= k-1) {
                out[start] = nums[deque.getFirst()];
                start++;
            }
            end++;
        }

        return out;
    }
}
