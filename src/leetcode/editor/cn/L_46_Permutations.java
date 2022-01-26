/**
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 

 

 示例 1： 

 
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 示例 2： 

 
输入：nums = [0,1]
输出：[[0,1],[1,0]]
 

 示例 3： 

 
输入：nums = [1]
输出：[[1]]
 

 

 提示： 

 
 1 <= nums.length <= 6 
 -10 <= nums[i] <= 10 
 nums 中的所有整数 互不相同 
 
 Related Topics 数组 回溯 👍 1738 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_46_Permutations {
    public static void main(String[] args) {
        Solution solution = new L_46_Permutations().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        helper(nums, used);
        return res;
    }

    void helper(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {  // 每一层不用收缩范围，因为是排列
            if (used[i] == 1) {  // 但是每次递归的路径得保证不能重复使用同一个元素
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            helper(nums, used);
            path.removeLast();
            used[i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}