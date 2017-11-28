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
 * Main Points: 
   Instead of multiplying by depth, 
   add integers multiple times 
   (by going level by level and adding the unweighted sum to the weighted sum after each level)
   eg. [1,[4,[6]]]
   unweighted: 1 -> 1+4 -> 1+4+6
   weighted: 1 -> 1+ 1+4 -> 1 + 1+4 + 1+4+6
 * Time Complexity: O(n)
 * Space Complexity: O(n)
**/
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
              if (ni.isInteger()) {
                  unweighted += ni.getInteger();                  
              } else {
                  nextLevel.addAll(ni.getList());
              }
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }
}