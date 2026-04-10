class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0;
        int longest = 0;

        int[] charsInString = new int[256];
        Arrays.fill(charsInString, -1);
        for (int end = 0; end < s.length(); end++) {
            if (charsInString[s.charAt(end)] != -1) {
                start = Math.max(start, charsInString[s.charAt(end)] + 1);
            }
            charsInString[s.charAt(end)] = end;
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
