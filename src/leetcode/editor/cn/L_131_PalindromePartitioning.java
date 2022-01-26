/**
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 

 回文串 是正着读和反着读都一样的字符串。 

 

 示例 1： 

 
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
 

 示例 2： 

 
输入：s = "a"
输出：[["a"]]
 

 

 提示： 

 
 1 <= s.length <= 16 
 s 仅由小写英文字母组成 
 
 Related Topics 字符串 动态规划 回溯 👍 959 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_131_PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new L_131_PalindromePartitioning().new Solution();
        System.out.println(solution.check("ab", 0, 1));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res = new ArrayList<>();
    Deque<String> temp = new LinkedList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0);
        return res;
    }

    void helper(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (i - startIndex == 0 || check(s, startIndex, i)) {  // 当前分割有效
                String subStr = s.substring(startIndex, i+1);
                 temp.add(subStr);
            } else {
                continue;
            }
            helper(s, i + 1);
            temp.removeLast();
        }
    }

    boolean check(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}