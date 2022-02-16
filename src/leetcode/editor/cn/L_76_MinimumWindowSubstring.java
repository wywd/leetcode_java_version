/**
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 

 

 注意： 

 
 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
 

 

 示例 1： 

 
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
 

 示例 2： 

 
输入：s = "a", t = "a"
输出："a"
 

 示例 3: 

 
输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。 

 

 提示： 

 
 1 <= s.length, t.length <= 10⁵ 
 s 和 t 由英文字母组成 
 

 
进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1641 👎 0

*/

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class L_76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new L_76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        //s:父串, t:子串;
        int faLen  = s.length();
        int sonLen = t.length();
        //特殊情况排除;
        if(faLen < sonLen){
            return "";
        }
        //这里先将两个字符串变为字符数组;
        char[] FaArr  = s.toCharArray();
        char[] SonArr = t.toCharArray();
        //用于统计字符频率数的数组;
        int[] FaCount  = new int[128];
        int[] SonCount = new int[128];
        //子串固定的了,那就直接赋予;
        for(char c: SonArr){
            SonCount[c]++;
        }
        //记录当前的划到的窗口内 包含的子串字符种类个数;
        int FaDistance = 0;
        //滑动窗口;
        int left = 0;
        int right = 0;
        //父串中满足条件的串长度;
        int goodLen = Integer.MAX_VALUE;
        //父串中符合条件的索引起点;
        int begin = 0;
        while(right < faLen){
            /*if(SonCount[FaArr[right]]==0){
                right ++;
                continue;
            }*/
            //当前的字符出现数量一样了;那么就增加父串的种类数;
            if(FaCount[FaArr[right]] < SonCount[FaArr[right]]){
                FaDistance ++;
            }
            //记录当前字符出现的次数;
            FaCount[FaArr[right]]++;
            //父串先向右移动;
            right++;
            //注意;若果在父串中已经完全找到了子串;可考虑开始优化;
            while(FaDistance == sonLen){
                //这里算一下长度,同时记录符合的左窗口起点;
                if(goodLen > right-left){
                    goodLen = right-left;
                    begin = left;
                }
                /*
                if(SonCount[FaArr[left]]==0){
                    left ++;
                    continue;
                }*/
                //若左指针对应的字符量此时已经匹配子串的量;则字符串的种类数减少;
                if(FaCount[FaArr[left]] == SonCount[FaArr[left]]){
                    FaDistance --;
                }
                FaCount[FaArr[left]]--;
                //左窗口缩进;
                left++;
            }
        }
        //这里要对满足的子串长度判断;
        if(goodLen ==Integer.MAX_VALUE ){
            return "";
        }
        //截取符合的字符串;
        return s.substring(begin,begin+goodLen);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}