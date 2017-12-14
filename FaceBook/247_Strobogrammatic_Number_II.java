/**
 * Main Points: append new 2 char to last level's result
 * Time Complexity: T(n) = 4*T(n-2) -> T(n) = O(2^n)
 * Space Complexity: O(n)
**/
class Solution {
    public List<String> findStrobogrammatic(int n) {
        return findHelper(n, n);
    }
    private List<String> findHelper(int n, int m) {
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> res = new ArrayList<>();
        List<String> last = findHelper(n - 2, m);
        
        for (String s : last) {
            if (n != m) res.add("0" + s + "0");            
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }    
}