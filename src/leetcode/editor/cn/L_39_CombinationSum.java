/**
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所
有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 

 candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 

 

 示例 1： 

 
输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。 

 示例 2： 

 
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]] 

 示例 3： 

 
输入: candidates = [2], target = 1
输出: []
 

 示例 4： 

 
输入: candidates = [1], target = 1
输出: [[1]]
 

 示例 5： 

 
输入: candidates = [1], target = 2
输出: [[1,1]]
 

 

 提示： 

 
 1 <= candidates.length <= 30 
 1 <= candidates[i] <= 200 
 candidate 中的每个元素都 互不相同 
 1 <= target <= 500 
 
 Related Topics 数组 回溯 👍 1717 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new L_39_CombinationSum().new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{2,7,6,3,5,1}, 9);
        System.out.println(res);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0);
        return res;
    }

    void helper(int[] candidates, int target, int sum, int startIndex) {
//        if (sum > target) {
//            return;
//        }
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < candidates.length && candidates[i] + sum <= target; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, target, sum, i);  // 这里的i表示下一次只能从自身开始，因为不考虑顺序，需要收缩范围
            sum -= candidates[i];
            temp.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}