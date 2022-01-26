/**
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 

 

 示例： 

 
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 

 

 提示： 

 
 S的长度在[1, 500]之间。 
 S只包含小写字母 'a' 到 'z' 。 
 
 Related Topics 贪心 哈希表 双指针 字符串 👍 644 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L_763_PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new L_763_PartitionLabels().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] location = new int[26];  // 26个字母，统计字符串中每个字符出现最后的位置
        int len = s.length();
        for (int i = 0; i < len; i++) {
            location[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < len; i++) {
            right = Math.max(right, location[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}