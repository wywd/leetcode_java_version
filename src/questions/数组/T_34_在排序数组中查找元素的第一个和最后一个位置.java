package questions.数组;

// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
// 示例1
// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
// 示例2
// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
// 示例3
// 输入：nums = [], target = 0
// 输出：[-1,-1]
// 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/


public class T_34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        // 空数组情况
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length;
        // 寻找开始位置
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // 不存在的情况
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = left;
        left = 0;
        right = nums.length;
        // 寻找结束位置
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
