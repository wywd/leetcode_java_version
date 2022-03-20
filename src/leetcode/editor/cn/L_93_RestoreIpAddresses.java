/**
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 

 
 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 
"192.168@1.1" 是 无效 IP 地址。 
 

 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删
除 s 中的任何数字。你可以按 任何 顺序返回答案。 

 

 示例 1： 

 
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
 

 示例 2： 

 
输入：s = "0000"
输出：["0.0.0.0"]
 

 示例 3： 

 
输入：s = "1111"
输出：["1.1.1.1"]
 

 示例 4： 

 
输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
 

 示例 5： 

 
输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

 

 提示： 

 
 0 <= s.length <= 20 
 s 仅由数字组成 
 
 Related Topics 字符串 回溯 👍 773 👎 0

*/

package leetcode.editor.cn;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L_93_RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new L_93_RestoreIpAddresses().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    Deque<String> temp = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(s, 0);
        return res;
    }

    void helper(String s, int startIndex) {  // k代表分割次数
        if (temp.size() == 4) {
            if (startIndex == s.length()) {
                res.add(String.join(".", temp));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i+1);
            if (Integer.parseInt(sub) > 255 || sub.startsWith("0") && sub.length() > 1) {
                return;
            } else {
                temp.add(sub);
                helper(s, i+1);
                temp.removeLast();
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)


}