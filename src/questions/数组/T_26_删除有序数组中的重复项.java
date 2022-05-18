package questions.数组;

//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
// 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
//示例 1：
//        输入：nums = [1,1,2]
//        输出：2, nums = [1,2,_]
//        解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。
//        不需要考虑数组中超出新长度后面的元素。


public class T_26_删除有序数组中的重复项 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int size = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                i++;
            }
            nums[cur++] = nums[i];
            size++;
        }
        return size;
    }
}
