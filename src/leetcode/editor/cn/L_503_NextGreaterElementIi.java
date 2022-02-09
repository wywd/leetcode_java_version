/**
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个
比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 

 示例 1: 

 
输入: [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 

 注意: 输入数组的长度不会超过 10000。 
 Related Topics 栈 数组 单调栈 👍 556 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class L_503_NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new L_503_NextGreaterElementIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(len);
        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * len; i++) {  // 两遍相当于循环了
            int idx = i % len;
            while (!stack.isEmpty() && nums[stack.getLast()] < nums[idx]) {
                res[stack.removeLast()] = nums[idx];
            }
            if (i < len) {
                stack.addLast(i);
            }
            if (stack.isEmpty()) {
                break;
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}