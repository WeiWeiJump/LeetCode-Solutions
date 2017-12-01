/**
 * Main Points: recursively to find factors, backtracking
 * Time Complexity:
 * Space Complexity:
**/
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        getFactorsHelper(n, 2, factors, combinations);
        return combinations;
    }
    private void getFactorsHelper(int n, int start, List<Integer> factors, List<List<Integer>> combinations) {
        if (n == 1 && factors.size() > 1) {
            combinations.add(new ArrayList<Integer>(factors));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                getFactorsHelper(n / i, i, factors, combinations);
                factors.remove(factors.size() - 1);
            }
        }
    }
}