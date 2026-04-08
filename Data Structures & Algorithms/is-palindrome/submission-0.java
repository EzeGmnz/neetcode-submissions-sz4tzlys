class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        s = s.toLowerCase();
        int end = s.length() - 1;

        Character startChar = null;
        Character endChar = null;
        while (start < end) {
            startChar = s.charAt(start);
            if (!this.shouldIncludeCharacter(startChar)) {
                start++;
                continue;
            }
            endChar = s.charAt(end);
            if (!this.shouldIncludeCharacter(endChar)) {
                end--;
                continue; 
            }
            if (startChar != endChar) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean shouldIncludeCharacter(Character c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

// a b c b a
//   s   e





