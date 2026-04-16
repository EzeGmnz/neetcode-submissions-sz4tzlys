class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String t : tokens) {
            if (this.isOperator(t)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();

                stack.push(this.doOperation(t, firstOperand, secondOperand));
            } else { // guaranteed to have a number?
                stack.push(Integer.parseInt(t));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }

    private int doOperation(String operator, int firstOperand, int secondOperand) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;  
        }
        return 0;
    }
}
