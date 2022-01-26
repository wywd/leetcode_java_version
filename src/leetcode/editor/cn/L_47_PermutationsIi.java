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
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 排序，用于同一层中不重复
        used = new boolean[nums.length];
        helper(nums, used);
        return res;
    }

    void helper(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
//        boolean[] layerUsed=  new boolean[21];
        for (int i = 0; i < nums.length; i++) {
//            if (used[i] || layerUsed[nums[i] + 10]) {  // 保证同一路径下不重复 且 同一层不重复使用相同元素
//                continue;
//            }
//            layerUsed[nums[i] + 10] = true;
            if (i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                helper(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}