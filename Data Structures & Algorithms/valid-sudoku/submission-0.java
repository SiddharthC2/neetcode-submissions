class Solution {

    private boolean validateRows(char[][] board) {
        Set<Character> charSet;
        Character currChar;
        for (int i=0; i<9; i++) {
            charSet = new HashSet<>();
            for (int j=0; j<9; j++) {
                currChar = board[i][j];
                if (currChar == '.')
                    continue;
                if (charSet.contains(currChar))
                    return false;
                charSet.add(currChar);
            }
        }
        return true;
    }

    private boolean validateCols(char[][] board) {
        Set<Character> charSet;
        Character currChar;
        for (int i=0; i<9; i++) {
            charSet = new HashSet<>();
            for (int j=0; j<9; j++) {
                currChar = board[j][i];
                if (currChar == '.')
                    continue;
                if (charSet.contains(currChar))
                    return false;
                charSet.add(currChar);
            }
        }
        return true;
    }

    private boolean validateBoxs(char[][] board) {
        Set<Character> charSet;
        Character currChar;
        int rowIdx, rowLim, colIdx, colLim;
        for (int i=0; i<9; i++) {
            charSet = new HashSet<>();
            rowIdx = (i/3)*3;
            colIdx = (i%3)*3;
            rowLim = rowIdx+3;
            colLim = colIdx+3;
            for (int j=rowIdx; j<rowLim; j++) {
                for (int k=colIdx; k<colLim; k++) {
                    currChar = board[j][k];
                    if (currChar == '.')
                        continue;
                    if (charSet.contains(currChar))
                        return false;
                    charSet.add(currChar);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateCols(board) && validateBoxs(board);
    }
}
