class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = freqMap.size();
        int outStart = 0;
        int outLength = Integer.MAX_VALUE;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char charAtEnd = s.charAt(end);
            windowMap.put(charAtEnd, windowMap.getOrDefault(charAtEnd, 0) + 1);

            if (freqMap.containsKey(charAtEnd) && windowMap.get(charAtEnd) == freqMap.get(charAtEnd)) {
                have++;
            }

            while (have == need) {
                if (end - start + 1 < outLength) {
                    outLength = end - start + 1;
                    outStart = start;
                }

                char charAtStart = s.charAt(start);
                windowMap.put(charAtStart, windowMap.get(charAtStart) - 1);
                if (freqMap.containsKey(charAtStart) && windowMap.get(charAtStart) < freqMap.get(charAtStart)) {
                    have--;
                }
                start++;
            }
        }

        return outLength == Integer.MAX_VALUE ? "" : s.substring(outStart, outStart + outLength);    }
}
