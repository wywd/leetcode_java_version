/**
给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 

 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 

 

 示例 1： 

 
输入：nums = [4,6,7,7]
输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 

 示例 2： 

 
输入：nums = [4,4,3,2,1]
输出：[[4,4]]
 

 

 提示： 

 
 1 <= nums.length <= 15 
 -100 <= nums[i] <= 100 
 
 Related Topics 位运算 数组 哈希表 回溯 👍 385 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_491_IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new L_491_IncreasingSubsequences().new Solution();
        System.out.println(solution.findSubsequences(new int[]{4, 7, 6, 7}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0);
        return res;
    }

    // 同一递归函数下面是同一层的
    // 同一个循环i下面的是同一路径的
    void helper(int[] nums, int startIndex) {
        if (path.size() >= 2) {  // 长度至少为2才可以算成一个序列
            res.add(new ArrayList<>(path));
        }
        int[] uset = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.peekLast() > nums[i]) {  // 这里的if是保证同一路径是递增顺序
                continue;
            }
            if (uset[nums[i] + 100] == 1) {  // 这里的if表示同一层中元素不可重复
                continue;
            }
//            if (i > startIndex && nums[i] == nums[i-1]) {  // 这个是错误的！
//                continue;
//            }
            uset[nums[i] + 100] = 1;
            path.add(nums[i]);
            helper(nums, i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}