/**
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 

 

 

 示例 1： 

 
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 示例 2： 

 
输入：digits = ""
输出：[]
 

 示例 3： 

 
输入：digits = "2"
输出：["a","b","c"]
 

 

 提示： 

 
 0 <= digits.length <= 4 
 digits[i] 是范围 ['2', '9'] 的一个数字。 
 
 Related Topics 哈希表 字符串 回溯 👍 1686 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new L_17_LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> res = solution.letterCombinations("23");
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

//class Solution {
//    List<String> res = new ArrayList<>();
//    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
//    StringBuilder path = new StringBuilder();
//    String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    public List<String> letterCombinations(String digits) {
//        if (digits == null || digits.length() == 0 ) {
//            return res;
//        }
//        helper(digits, 0);
//        return res;
//    }
//
//    void helper(String digits, int index) {
//        //遍历全部一次记录一次得到的字符串
//        if (index == digits.length()) {
//            res.add(path.toString());
//            return;
//        }
//
//        String str = numString[digits.charAt(index) - '0'];
//        for (int i = 0; i < str.length(); i++) {
//            path.append(str.charAt(i));
//            helper(digits, index + 1);
//            path.deleteCharAt(path.length() - 1);
//        }
//    }
//
//}

class Solution {  // 广度优先搜索方法
    HashMap<Character, String> numMap = new HashMap<>(){  // 双括号匿名初始化方式（谨慎使用）
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Deque<String> queue = new LinkedList<>();
        int index = 0;
        String str = numMap.get(digits.charAt(index));
        for (int i = 0; i < str.length(); i++) {
            queue.offerLast(str.charAt(i) + "");
        }
        index++;
        while (index < digits.length()) {
            int size = queue.size();
            str = numMap.get(digits.charAt(index));
            for (int i = 0; i < size; i++) {
                String curStr = queue.pollFirst();
                for (int j = 0; j < str.length(); j++) {
                    queue.offerLast(curStr + str.charAt(j));
                }
            }
            index++;
        }
        System.out.println(queue);
        res = (List<String>) queue;
        return res;
    }

}


//leetcode submit region end(Prohibit modification and deletion)


}