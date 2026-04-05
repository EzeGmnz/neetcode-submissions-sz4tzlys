class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numToIndexMap = new HashMap<>(); // O(n) space

        for (int i = 0; i < nums.length; i++) { // O(n)
            if (!numToIndexMap.containsKey(nums[i])) {
                numToIndexMap.put(nums[i], new ArrayList<>());
            }
            List<Integer> list = numToIndexMap.get(nums[i]);
            list.add(i);
        }

        for (int i = 0; i < nums.length; i++) { // O(n)

            List<Integer> indexMatchList = numToIndexMap.get(target - nums[i]);
            if (indexMatchList != null) { // list of indexes that match
                int index = 0;
                boolean found = false;
                while (!found && index < indexMatchList.size()) {
                    if (indexMatchList.get(index) != i) {
                        found = true;
                    } else {
                        index++;    
                    }
                }

                if (!found) {
                    continue;
                }

                if(indexMatchList.get(index) < i) return new int[]{indexMatchList.get(index), i};
                return new int[]{i, indexMatchList.get(index)};
            }
        }
        return new int[]{};
    }
}

// loop for each item in nums, check if we have another one that adds up

// build a hash map that has number -> index, 
// then we loop through the array checking for existance of j = target - i
// O(n) space, O(n) time

// sort the array, in place -> O(1), then do a two index approach
// O(nlogn) + O(n) -> O(nlogn)


