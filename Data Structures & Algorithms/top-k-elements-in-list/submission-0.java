class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // [1,2,2,3,3,3] k = 2
        Map<Integer, Integer> freqMap = this.buildFreqMap(nums);
        List<Integer>[] freqArray = this.buildFreqArray(freqMap, nums.length);

        // [n, [1], [2], [3]]
        // out [3, 0]
        int[] mostFrequentKNumbers = new int[k];
        int insertIndex = 0;
        for (int i = freqArray.length - 1; i > 0 && insertIndex < k; i--) {
            if (freqArray[i] == null) continue;
            for (int num : freqArray[i]) {
                if (insertIndex < k) mostFrequentKNumbers[insertIndex++] = num;
                else return mostFrequentKNumbers;
            }
        }
        return mostFrequentKNumbers;
    }

    private Map<Integer, Integer> buildFreqMap(int[] nums) {
        // number -> frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        return freqMap;
    }
    
    private List<Integer>[] buildFreqArray(Map<Integer, Integer> freqMap, int n) {
        // {(7, 2)}
        // out []
        List<Integer>[] freqArray = new List[n + 1];
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (freqArray[entry.getValue()] == null) {
                freqArray[entry.getValue()] = new ArrayList<>();
            }
            freqArray[entry.getValue()].add(entry.getKey());
        }
        return freqArray;
    }
}
