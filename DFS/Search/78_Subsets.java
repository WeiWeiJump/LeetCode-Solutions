/**Name: Subsets
 * Number: 78
 * Tag: DFS/Backtracking
 * Time Complexity: O(2^n) ÿ��Ԫ���ڼ��ϻ��߲���
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
    
    // �ݹ���Ҫ��
    // 1. �ݹ�Ķ��壺�� Nums ���ҵ������� tempList ��ͷ�ĵļ��ϣ����ŵ� res
    private void DFSHelper(int[] nums, int pos, List<Integer> tempList, List<List<Integer>> res) {
        // 2. �ݹ�Ĳ��
        // deep copy
        // results.add(subset);
        res.add(new ArrayList<Integer>(tempList));
        
        for (int i = pos; i < nums.length; i++) {
             // [1] -> [1,2]
            tempList.add(nums[i]);
            // Ѱ�������� [1,2] ��ͷ�ļ��ϣ����ӵ� res��
            DFSHelper(nums, i + 1, tempList, res);
            // [1,2] -> [1]  ����
            tempList.remove(tempList.size() - 1);
        }
        // 3. �ݹ�ĳ���
        // return;
    }
}