package questions.数组;

// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 注意：
//  对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//  如果 s 中存在这样的子串，我们保证它是唯一的答案。
// https://leetcode.cn/problems/minimum-window-substring/

public class T_76_最小覆盖子串 {
    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        //特殊情况排除;
        if (len1 < len2) {
            return "";
        }
        //这里先将两个字符串变为字符数组;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        //用于统计字符频率数的数组;使用数组来代替哈希表，提升性能
        int[] need = new int[128];
        int[] temp = new int[128];
        for (int i = 0; i < len2; i++) {
            need[ct[i]]++;
        }
        //记录当前的划到的窗口内 包含的子串字符种类个数;
        int count = 0;

        //父串中满足条件的串长度;索引起点;
        int min = Integer.MAX_VALUE;
        int start = 0;

        // 滑动窗口
        int left = 0;
        int right = 0;

        while (right < len1) {
            //当前的字符出现数量一样了;那么就增加父串的种类数;
            if (temp[cs[right]] < need[cs[right]]) {
                count++;
            }
            //记录当前字符出现的次数;
            temp[cs[right]]++;

            //若果在父串中已经完全找到了子串;可考虑开始优化;
            while (count == len2) {
                //若左指针对应的字符量此时已经匹配子串的量;则字符串的种类数减少;
                if (temp[cs[left]] == need[cs[left]]) {
                    count--;
                    if (min > right - left + 1) {
                        min = right - left + 1;
                        start = left;
                    }
                }
                temp[cs[left]]--;
                //左窗口缩进;
                left++;
            }
            right++;
        }
        //这里要对满足的子串长度判断;
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, start + min);
        }
    }
}
