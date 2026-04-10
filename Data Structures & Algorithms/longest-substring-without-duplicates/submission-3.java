class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int end = start+1;
        int longest = 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put(s.charAt(start), 1);
        while (end < s.length()) {
            if (freqMap.get(s.charAt(end)) == null || freqMap.get(s.charAt(end)) == 0) {
                longest = Math.max(longest, end - start + 1);
                freqMap.put(s.charAt(end), freqMap.getOrDefault(s.charAt(end), 0) + 1);
                end++;
                continue;
            }
            freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) - 1);
            start++;
        }
        return longest;
    }
}

// a b c a b c b b
// s e 

// {a:1,}




