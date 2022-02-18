/**
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b],
 nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 

 
 0 <= a, b, c, d < n 
 a、b、c 和 d 互不相同 
 nums[a] + nums[b] + nums[c] + nums[d] == target 
 

 你可以按 任意顺序 返回答案 。 

 

 示例 1： 

 
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 

 示例 2： 

 
输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]
 

 

 提示： 

 
 1 <= nums.length <= 200 
 -10⁹ <= nums[i] <= 10⁹ 
 -10⁹ <= target <= 10⁹ 
 
 Related Topics 数组 双指针 排序 👍 1116 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_18_FourSum {
    public static void main(String[] args) {
        Solution solution = new L_18_FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {  // 剪枝
            return res;
        }
        Arrays.sort(nums);
         if (nums[0] > target / 4 || nums[len - 1] < target / 4) {  // 剪枝
             return res;
         }
        for (int i = 0; i < len - 3; i++) {
             if (nums[i] > target / 4) {  // 剪枝
                 return res;
             }
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重
                continue;
            }
            int target2 = target - nums[i];
            for (int j = i + 1; j < len - 2; j++) {
                 if (nums[j] > target2 / 3) {  // 剪枝
                     break;
                 }
                if (j > i + 1 && nums[j] == nums[j - 1]) {  // 去重
                    continue;
                }
                int target3 = target2 - nums[j];
                for (int left = j + 1, right = len - 1; left < right; ) {
                    if (nums[left] > target3 / 2) {
                        break;
                    }
                    int sum = nums[left] + nums[right];
                    if (sum == target3) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target3) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}