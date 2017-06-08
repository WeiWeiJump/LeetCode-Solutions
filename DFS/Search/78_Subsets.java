/**Name: Subsets
 * Number: 78
 * Tag: DFS/Backtracking
 * Time Complexity: O(2^n) 每个元素在集合或者不在
**/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        List<Integer> tempList = new ArrayList<>();
        DFSHelper(nums, 0, tempList, res);
        return res;
    }
    
    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 tempList 开头的的集合，并放到 res
    private void DFSHelper(int[] nums, int pos, List<Integer> tempList, List<List<Integer>> res) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        res.add(new ArrayList<Integer>(tempList));
        
        for (int i = pos; i < nums.length; i++) {
             // [1] -> [1,2]
            tempList.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 res里
            DFSHelper(nums, i + 1, tempList, res);
            // [1,2] -> [1]  回溯
            tempList.remove(tempList.size() - 1);
        }
        // 3. 递归的出口
        // return;
    }
}