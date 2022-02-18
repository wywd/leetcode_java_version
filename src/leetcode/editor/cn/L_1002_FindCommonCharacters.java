/**
给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。

 

 示例 1： 

 
输入：words = ["bella","label","roller"]
输出：["e","l","l"]
 

 示例 2： 

 
输入：words = ["cool","lock","cook"]
输出：["c","o"]
 

 

 提示： 

 
 1 <= words.length <= 100 
 1 <= words[i].length <= 100 
 words[i] 由小写英文字母组成 
 
 Related Topics 数组 哈希表 字符串 👍 258 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class L_1002_FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new L_1002_FindCommonCharacters().new Solution();
        String s = String.valueOf((char) ('a'+2));
        System.out.println(s);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int[][] count = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            count[i] = getCharCount(words[i]);
        }

        for (int i = 0; i < 26; i++) {
            int min = count[0][i];
            for (int j = 0; j < words.length; j++) {
                if (min == 0) {
                    break;
                } else if (count[j][i] < min) {
                    min = count[j][i];
                }
            }
            while (min-- > 0){
                list.add(String.valueOf((char) (i+'a')));
            }
        }
        return list;
    }

    public int[] getCharCount(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


}