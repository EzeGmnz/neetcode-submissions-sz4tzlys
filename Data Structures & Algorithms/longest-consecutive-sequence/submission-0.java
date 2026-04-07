class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Integer> maxSequenceMap = new HashMap<>();

        for (int i : nums) {
            maxSequenceMap.put(i, 0);
        }

        int maxSequence = 0;
        for (int i : nums) {
            maxSequence = Math.max(this.recursive(maxSequenceMap, i), maxSequence);
        }
        return maxSequence;
    }

    private int recursive(Map<Integer,Integer> map, int num) {
        Integer sequenceLength = map.get(num);
        if (sequenceLength == null) {
            return 0;
        }
        Integer nextNumberSequenceLength = map.get(num+1);
        if (nextNumberSequenceLength != null && nextNumberSequenceLength != 0) {
            sequenceLength = nextNumberSequenceLength + 1;
        } else {
            sequenceLength = this.recursive(map, num+1) + 1;
        }
        
        map.put(num, sequenceLength);
        return sequenceLength;
    }
}

// 2-0, 20-0, 4-2, 10-0, 3-0, 4-0, 5-1