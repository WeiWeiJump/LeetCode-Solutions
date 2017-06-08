/**Name: Subsets2
 * Number: 90
 * Tag: DFS/Backtracking
 * Root: Subsets
 * Time Complexity: O(2^n)
**/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums); // you need to put numbers of the same value together
        DFSHelper(nums, 0, res, tempList);
        return res;
    }
    private void DFSHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tempList) {
        res.add(new ArrayList<Integer>(tempList));
        
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) { //if nums[i] is not the first number of that value
                continue;
            }
            tempList.add(nums[i]);
            DFSHelper(nums, i + 1, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}