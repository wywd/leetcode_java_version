/**
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 

 说明： 

 
 所有数字都是正整数。 
 解集不能包含重复的组合。 
 

 示例 1: 

 输入: k = 3, n = 7
输出: [[1,2,4]]
 

 示例 2: 

 输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 
 Related Topics 数组 回溯 👍 412 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_216_CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new L_216_CombinationSumIii().new Solution();
        List<List<Integer>> res = solution.combinationSum3(9, 45);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();  // 储存最终结果
    Deque<Integer> path = new LinkedList<>();  // 储存单一结果
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1, 0);
        return res;
    }

    void helper(int k, int n, int start, int sum) {
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
//                System.out.println("成功=> " + path);
            }
            return;
        }
//        for (int i = start; i <= 9; i++) {
        for (int i = start; i <= 9 - (k - path.size()) + 1; i++) {   // 剪枝
            path.addLast(i);
            sum += i;
//            System.out.println("递归之前=> " + path);
            helper(k, n, i+1, sum);
            path.removeLast();
            if (sum == n) {  // 剪枝，如果当前路径下sum已经大于n了，那么要再次回溯
                return;
            }
            sum -= i;
//            System.out.println("递归之后=> " + path);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}