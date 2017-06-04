/**
 Name: Permutations
 Number: 46
 Tag: DFS/Search/Backtraking
 Time Complexity: O(n!)
 **/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        List<Integer> tempList = new ArrayList<>();
        search(nums, res, tempList);
        return res;
    }
    
    private void search(int[] nums, List<List<Integer>> res, List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<Integer>(tempList)); // pay attention
            return;
        }
        
        for (int i : nums) {
            if (tempList.contains(i)) {
                continue;
            }
            tempList.add(i);
            search(nums, res, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}