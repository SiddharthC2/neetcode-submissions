class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> postFixStack = new ArrayDeque<>();
        int answer, num1, num2;
        for (String token: tokens) {
            switch (token) {
                case "+":
                    num1 = postFixStack.pop();
                    num2 = postFixStack.pop();
                    postFixStack.push(num2+num1);
                    break;
                case "-":
                    num1 = postFixStack.pop();
                    num2 = postFixStack.pop();
                    postFixStack.push(num2-num1);
                    break;
                case "*":
                    num1 = postFixStack.pop();
                    num2 = postFixStack.pop();
                    postFixStack.push(num2*num1);
                    break;
                case "/":
                    num1 = postFixStack.pop();
                    num2 = postFixStack.pop();
                    postFixStack.push(num2/num1);
                    break;
                default:
                    postFixStack.push(Integer.parseInt(token));
                    break;
            }
        }
        return postFixStack.peek();
    }
}
