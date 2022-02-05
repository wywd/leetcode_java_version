/**
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 

 

 示例： 

 输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。
 

 

 提示： 

 
 1 <= len(A), len(B) <= 1000 
 0 <= A[i], B[i] < 100 
 
 Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 👍 608 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

public class L_718_MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new L_718_MaximumLengthOfRepeatedSubarray().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // 两个数组的太难了
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        // 含义：dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j] -> 滚动数组
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[j] = dp[j-1] + 1;
                } else {
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}