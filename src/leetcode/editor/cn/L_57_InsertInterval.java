/**
给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 

 

 示例 1： 

 
输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
 

 示例 2： 

 
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 

 示例 3： 

 
输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]
 

 示例 4： 

 
输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]
 

 示例 5： 

 
输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]
 

 

 提示： 

 
 0 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
 intervals 根据 intervals[i][0] 按 升序 排列 
 newInterval.length == 2 
 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
 
 Related Topics 数组 👍 573 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L_57_InsertInterval {
    public static void main(String[] args) {
        Solution solution = new L_57_InsertInterval().new Solution();
        int[][] intervals = new int[][] {
                {1, 5}
        };
        int[][] ans = solution.insert(intervals, new int[]{0, 0});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int cur = -1;
        int use = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                cur = i;
                break;
            }
            if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                use = 1;
                int left = Math.min(intervals[i][0], newInterval[0]);  // 确定区间左边界
                while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                    i++;
                }
                if (i == intervals.length) {
                    int right = Math.max(newInterval[1], intervals[intervals.length - 1][1]);
                    res.add(new int[]{left, right});
                    break;
                } else {
                    if (i == 0) {
                        int right = Math.max(newInterval[1], intervals[i][1]);
                        res.add(new int[]{left, right});
                    } else {
                        int right = Math.max(newInterval[1], intervals[i - 1][1]);
                        res.add(new int[]{left, right});
                        cur = i;
                        break;
                    }
                }
            }
        }
        if (use == -1) {
            res.add(newInterval);
        }
        if (cur >= 0) {
            for (int i = cur; i < intervals.length; i++) {
                res.add(intervals[i]);
            }
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}