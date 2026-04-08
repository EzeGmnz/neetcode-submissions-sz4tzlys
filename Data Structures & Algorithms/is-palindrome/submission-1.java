class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);

            if (!Character.isLetterOrDigit(startChar)) {
                start++;
                continue;
            } 
            if (!Character.isLetterOrDigit(endChar)) {
                end--;
                continue;
            } 
            if (Character.toLowerCase(startChar) != Character.toLowerCase(endChar)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}