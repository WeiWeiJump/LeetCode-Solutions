/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/**
 * Main Points: DFS
 * Time Complexity: O(n), n is the number of elements in the list
 * Space Complexity: O(k), k is the max depth of the list
**/
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        return depthHelper(nestedList, 1);
    }
    private int depthHelper(List<NestedInteger> nestedList, int depth) {
        int depth = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                depth += ni.getInteger() * depth;
            } else {
                depth += depthHelper(nestedList, depth + 1);
            }
        }
        return depth;
    }
}