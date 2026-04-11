
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            char charAtEnd = s2.charAt(end);

            if (freqMap.containsKey(charAtEnd)) {
                freqMap.put(charAtEnd, freqMap.get(charAtEnd) - 1);
                while (freqMap.get(charAtEnd) < 0) {
                    char startChar = s2.charAt(start);
                    freqMap.put(startChar, freqMap.get(startChar) + 1);
                    start++;
                }

                if ((end - start + 1) == s1.length()) {
                    return true;
                }
                
            } else {
                while (start < end) {
                    char startChar = s2.charAt(start);
                    freqMap.put(startChar, freqMap.get(startChar) + 1);
                    start++;
                }
                start = end + 1;
            }
        }

        return false;
    }
}