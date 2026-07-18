class Solution {

    private boolean isCaseMatch(Character currChar, Character stackTop) {
        // System.out.println("currChar: " + currChar + " stackTop: " + stackTop);
        if (currChar == ')' && stackTop == '(') {
            return true;
        } else if (currChar == '}' && stackTop == '{') {
            return true;
        } else if (currChar == ']' && stackTop == '[') {
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Character stackTop;
        for (char currChar: s.toCharArray()) {
            // System.out.println("currChar: " + currChar + " Stack: " + stack);
            if (!stack.isEmpty() && isCaseMatch(currChar, stack.peek())) {
                // System.out.println("popping: " + stack.peek() + " Stack: " + stack);
                stack.pop();
            } else {
                stack.push(currChar);
            }
            
        }
        return stack.isEmpty();
    }
}
