class Solution {
    public int evalRPN(String[] tokens) {
        return dfs(new ArrayList<>(Arrays.asList(tokens)));
    }

    private int dfs(List<String> tokens) {
        String token = tokens.remove(tokens.size()-1);

        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        Integer right = dfs(tokens);
        Integer left = dfs(tokens);

        switch(token) {
            case "+":
                return left+right;
            case "-":
                return left-right;
            case "*":
                return left*right;
            case "/":
                return left/right;
        }
        return 0;
    }
}
