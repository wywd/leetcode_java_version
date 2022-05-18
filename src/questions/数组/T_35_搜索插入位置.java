package questions.数组;

// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
// 示例1
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
// 示例2
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
// 示例3
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
// 链接：https://leetcode-cn.com/problems/search-insert-position/

public class T_35_搜索插入位置 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
