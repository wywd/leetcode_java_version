/**
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 

 

 示例 1： 

 
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。 

 示例 2： 

 
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 

 

 提示： 

 
 1 <= nums.length <= 200 
 1 <= nums[i] <= 100 
 
 Related Topics 数组 动态规划 👍 1113 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new L_416_PartitionEqualSubsetSum().new Solution();
        System.out.println(solution.canPartition(new int[]{2, 2, 1, 1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int mid = sum / 2;  // 包的大小就是最后切分的一个子集元素和
        int[] dp = new int[mid+1];  // 现在计算数组中的元素可否刚好填满容量为mid的这个包

        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < nums.length; i++) {
            for (int j = mid; j >= nums[i]; j--) {  // j >= nums[i]这个条件保证下面公式[]索引正确
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
                if (dp[mid] == mid) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}