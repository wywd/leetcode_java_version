/**
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的
三元组。 

 注意：答案中不可以包含重复的三元组。 

 

 示例 1： 

 
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
 

 示例 2： 

 
输入：nums = []
输出：[]
 

 示例 3： 

 
输入：nums = [0]
输出：[]
 

 

 提示： 

 
 0 <= nums.length <= 3000 
 -10⁵ <= nums[i] <= 10⁵ 
 
 Related Topics 数组 双指针 排序 👍 4316 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new L_15_ThreeSum().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) {  // 剪枝，减少搜索情况
            return res;
        }
        Arrays.sort(nums);  // 双指针方法更优O(n^2)复杂度
        if (nums[0] > 0 || nums[len - 1] < 0) {
            return res;
        }
        for (int i = 0; i < len - 2; i++) {  // 相当于缩小搜索范围
            if (nums[i] > 0) {  // 剪枝
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  // **去重操作**
                continue;
            }
            int target = -nums[i];
            for (int left = i + 1, right = len - 1; left < right; ) {
                if (nums[left] > target) {  // 剪枝
                    return res;
                }
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重操作
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while (right > left && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}