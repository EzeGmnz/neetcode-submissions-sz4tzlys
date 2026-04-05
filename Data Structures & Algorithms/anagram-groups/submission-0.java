class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagramsMap = new HashMap();

        String key;
        for (String str : strs) {
            key = this.buildKeyForString(str);
            if (keyToAnagramsMap.get(key) == null) {
                keyToAnagramsMap.put(key, new LinkedList<>());
            }
            List<String> anagrams = keyToAnagramsMap.get(key);
            anagrams.add(str);
        }

        return new ArrayList<>(keyToAnagramsMap.values());
    }

    private String buildKeyForString(String str) {
        int[] frequencyMap = new int[26];

        // build frequency map
        for (char c : str.toCharArray()) {
            frequencyMap[c - 'a'] += 1;
        }

        // stringify the map
        StringBuilder keyBuilder = new StringBuilder();
        for(int i = 0; i < frequencyMap.length; i++) {
            keyBuilder.append(frequencyMap[i]).append((char)('a' + i));
        }
        return keyBuilder.toString();
    }
}

