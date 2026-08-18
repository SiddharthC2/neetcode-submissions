class Solution {

    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> solutions = new ArrayList<>();
        final boolean[] lockedCol = new boolean[n];
        final boolean[] lockedDiagF = new boolean[n*2-1];
        final boolean[] lockedDiagB = new boolean[n*2-1];
        final String[] rowStrings = getRowStrings(n);
        nQueens(n, 0, new ArrayList<>(), solutions, lockedCol, lockedDiagF, lockedDiagB, rowStrings);
        return solutions;
    }

    private void nQueens(
        final int n,
        final int row,
        final List<String> currlist,
        final List<List<String>> solutions,
        final boolean[] lockedCol,
        final boolean[] lockedDiagF,
        final boolean[] lockedDiagB,
        final String[] rowStrings
    ) {
        if (row == n) {
            solutions.add(new ArrayList<>(currlist));
            return;
        }
        for (int col=0; col<n; col++) {
            if (lockedCol[col] || lockedDiagF[row+col] || lockedDiagB[n-1-row+col]) continue;
            lockedCol[col] = true;
            lockedDiagF[row+col] = true;
            lockedDiagB[n-1-row+col] = true;
            currlist.add(rowStrings[col]);
            nQueens(n, row+1, currlist, solutions, lockedCol, lockedDiagF, lockedDiagB, rowStrings);
            currlist.remove(currlist.size()-1);
            lockedCol[col] = false;
            lockedDiagF[row+col] = false;
            lockedDiagB[n-1-row+col] = false;
        }
    }

    private String[] getRowStrings(
        final int n
    ) {
        final String[] rowStrings = new String[n];
        for (int i=0; i<n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (i==j) stringBuilder.append('Q');
                else stringBuilder.append('.');
            }
            rowStrings[i] = stringBuilder.toString();
        }
        return rowStrings;
    }
}
