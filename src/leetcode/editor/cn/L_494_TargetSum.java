/**
给你一个整数数组 nums 和一个整数 target 。 

 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 

 
 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
 

 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 

 

 示例 1： 

 
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
 

 示例 2： 

 
输入：nums = [1], target = 1
输出：1
 

 

 提示： 

 
 1 <= nums.length <= 20 
 0 <= nums[i] <= 1000 
 0 <= sum(nums[i]) <= 1000 
 -1000 <= target <= 1000 
 
 Related Topics 数组 动态规划 回溯 👍 1023 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_494_TargetSum {
    public static void main(String[] args) {
        Solution solution = new L_494_TargetSum().new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{2, 5, 8, 1, 7, 4}, 3));
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    int res = 0;
//    int path = 0;
//    List<Integer> pathList = new ArrayList<>();
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (target < -sum || target > sum) {  // 超过了0个+到全部是+的取值范围
            return 0;
        }

        sum += target;
        if (sum % 2 == 1) {
            return 0;
        }
        sum = sum / 2 - target;  // 问题转换成：需要从集合中选择元素使其和为sum，有多少种取法？最开始想到的是回溯法

        int[] dp = new int[sum+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];

//        Arrays.sort(nums);
//        helper(nums, sum, 0);
//        return res;
    }

//    void helper(int[] nums, int sum, int startIndex) {
//        if (path == sum) {
////            System.out.println("==>" + pathList);
//            res++;
//        }
//        if (startIndex == nums.length || path > sum) {
//            return;
//        }
//        for (int i = startIndex; i < nums.length; i++) {
//            path += nums[i];
////            pathList.add(nums[i]);
//            helper(nums, sum, i+1);
////            pathList.remove(pathList.size()-1);
//            path -= nums[i];
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


}