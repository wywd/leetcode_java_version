/**
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 

 你可以按 任何顺序 返回答案。 

 

 示例 1： 

 
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
] 

 示例 2： 

 
输入：n = 1, k = 1
输出：[[1]] 

 

 提示： 

 
 1 <= n <= 20 
 1 <= k <= n 
 
 Related Topics 数组 回溯 👍 832 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L_77_Combinations {
    public static void main(String[] args) {
        Solution solution = new L_77_Combinations().new Solution();
        solution.combine(4, 2);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> group = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return res;
    }

    void backTracking(int n, int k, int startIndex) {
        if (group.size() == k) {
            res.add(new ArrayList<>(group));  // 需要拷贝一份
            return;
        }
        for (int i = startIndex; i <= n - (k - group.size()) + 1 ; i++) {
            group.addLast(i);
//            System.out.println("递归之前=> " + group);
            backTracking(n, k, i+1);
            group.removeLast();
//            System.out.println("递归之后=> " + group);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}