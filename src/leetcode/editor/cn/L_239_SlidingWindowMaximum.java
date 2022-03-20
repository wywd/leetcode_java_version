/**
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 


 返回 滑动窗口中的最大值 。 

 

 示例 1： 

 
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 

 示例 2： 

 
输入：nums = [1], k = 1
输出：[1]
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 1 <= k <= nums.length 
 
 Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1411 👎 0

*/

package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

public class L_239_SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new L_239_SlidingWindowMaximum().new Solution();
        Queue<Integer> queue = new PriorityQueue<>(11, (x, y) -> y-x);
        queue.offer(1);
        queue.offer(-1);
        queue.offer(3);
        queue.offer(7);
        queue.offer(0);
        queue.offer(5);
        queue.remove(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums;
        }
        int[] res = new int[len - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(len, (x, y) -> y - x);
        for (int i = 0; i < k - 1; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k - 1; i < len; i++) {
            queue.offer(nums[i]);
            res[i - k + 1] = queue.peek();
            queue.remove(nums[i - k + 1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}