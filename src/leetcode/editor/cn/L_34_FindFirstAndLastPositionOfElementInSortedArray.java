/**
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 

 如果数组中不存在目标值 target，返回 [-1, -1]。 

 进阶： 

 
 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
 

 

 示例 1： 

 
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4] 

 示例 2： 

 
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1] 

 示例 3： 

 
输入：nums = [], target = 0
输出：[-1,-1] 

 

 提示： 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums 是一个非递减数组 
 -10⁹ <= target <= 10⁹ 
 
 Related Topics 数组 二分查找 👍 1441 👎 0

*/

package leetcode.editor.cn;

public class L_34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new L_34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{2, 2}, 3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution { // time 13:45
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {  // 先寻找左边界，这里数以没有等号
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                right = mid;  // 这里要注意，不用减1
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] != target) {
            return res;
        }
        res[0] = left;
        right = nums.length;  // 和上面的区别
        // 再寻找右边界
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        res[1] = left - 1;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}