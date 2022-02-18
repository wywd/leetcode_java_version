/**
给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 

 

 示例 1： 

 
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
 

 示例 2： 

 
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
 

 

 提示： 

 
 1 <= nums1.length, nums2.length <= 1000 
 0 <= nums1[i], nums2[i] <= 1000 
 
 Related Topics 数组 哈希表 双指针 二分查找 排序 👍 490 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new L_349_IntersectionOfTwoArrays().new Solution();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        for (int v: set) {
            System.out.println(v);
        }
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] book = new boolean[1010];
        for (int num : nums1) {
            book[num] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (book[num]) {
                list.add(num);
                book[num] = false;
            }
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (int num : list) {
            res[idx++] = num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}