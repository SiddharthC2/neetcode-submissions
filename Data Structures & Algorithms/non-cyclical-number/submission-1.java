class Solution {
    public boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private boolean isHappy(int n, final Set<Integer> visited) {
        if (n == 1) return true;
        if (visited.contains(n)) return false;
        visited.add(n);
        int squareSum = 0, curr;
        while (n > 0) {
            curr = n%10;
            squareSum += (curr*curr);
            n = n/10;
        }
        return isHappy(squareSum, visited);

    }
}
