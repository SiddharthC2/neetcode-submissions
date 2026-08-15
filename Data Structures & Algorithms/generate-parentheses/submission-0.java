class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> validParentheses = new ArrayList<>();
        generateParenthesis(0, 0, n, new StringBuilder(), validParentheses);
        return validParentheses;
    }

    private void generateParenthesis(
        final int opencount,
        final int closecount,
        final int total,
        final StringBuilder validParenthesis,
        final List<String> validParentheses
    ) {
        // System.out.println(opencount+", "+closecount+", "+total+", "+validParenthesis.toString());
        if ((2 * total) - opencount - closecount == 0) {
            validParentheses.add(validParenthesis.toString());
            return;
        }
        if (opencount < total) {
            validParenthesis.append("(");
            generateParenthesis(opencount+1, closecount, total, validParenthesis, validParentheses);
            validParenthesis.deleteCharAt(validParenthesis.length()-1);
        }
        if (closecount < opencount) {
            validParenthesis.append(")");
            generateParenthesis(opencount, closecount+1, total, validParenthesis, validParentheses);
            validParenthesis.deleteCharAt(validParenthesis.length()-1);
        }
    }
}
