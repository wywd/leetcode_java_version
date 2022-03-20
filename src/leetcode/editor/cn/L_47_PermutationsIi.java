/**
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 

 

 示例 1： 

 
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 示例 2： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 

 提示： 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 
 Related Topics 数组 回溯 👍 917 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new L_47_PermutationsIi().new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] pathUsed = new int[21];
    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(nums);
        return res;
    }

    private void helper(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        int[] used = new int[21];
        for (int i = 0; i < nums.length; i++) {
            if (used[nums[i] + 10] == 1 || pathUsed[nums[i] + 10] == 1) {
                continue;
            }
            used[nums[i] + 10] = 1;
            path.add(nums[i]);
            pathUsed[nums[i] + 10] = 1;
            helper(nums);
            pathUsed[nums[i] + 10] = 0;
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}