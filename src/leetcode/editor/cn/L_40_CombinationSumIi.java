/**
给你一个由候选元素组成的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 

 candidates 中的每个元素在每个组合中只能使用 一次 。 

 注意：解集不能包含重复的组合。 

 

 示例 1: 

 
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
] 

 示例 2: 

 
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
] 

 

 提示: 

 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 
 
 Related Topics 数组 回溯 👍 803 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new L_40_CombinationSumIi().new Solution();
        List<List<Integer>> res = solution.combinationSum2(new int[]{1, 1}, 1);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        helper(candidates, target, 0, 0);
        return res;
    }

    void helper(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i-1] == candidates[i]) {  // 核心点：i > startIndex
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, target, sum, i+1);
            sum -= candidates[i];
            temp.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}