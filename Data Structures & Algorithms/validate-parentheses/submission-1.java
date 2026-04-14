class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (this.isOpening(currChar)) {
                stack.push(currChar);
            } else if (stack.isEmpty() || !this.isClosing(currChar, stack.pop())) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isClosing(char c, char lastCharInStack) {
        return  c == ')' && lastCharInStack == '(' ||
                c == '}' && lastCharInStack == '{' ||
                c == ']' && lastCharInStack == '[';
    }
}



