class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[256];

        int start = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            freqMap[s.charAt(end)] += 1;
            maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end)]);

            // we want to make the window valid, length of window - maxFreq < k
            while ((end - start + 1) - maxFrequency > k) { 
                freqMap[s.charAt(start)] -= 1;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}


