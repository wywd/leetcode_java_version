/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 
 Related Topics 数组 排序 👍 1281 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new L_56_MergeIntervals().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);  // 按照左边界值从小到大的顺序排列
        List<int[]> ans = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1 ; i < intervals.length; i++) {
            if (right < intervals[i][0]) {  // 不重叠了
                ans.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {  // 存在重叠
                right = Math.max(right, intervals[i][1]);
            }
        }
        ans.add(new int[]{left, right});
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}