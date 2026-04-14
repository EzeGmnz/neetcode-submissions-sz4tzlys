class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char currChar : s.toCharArray()) {
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



