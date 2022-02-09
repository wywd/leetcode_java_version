/**
请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 

 示例 1: 

 
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
 

 示例 2: 

 
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
 

 示例 3: 

 
输入: temperatures = [30,60,90]
输出: [1,1,0] 

 

 提示： 

 
 1 <= temperatures.length <= 10⁵ 
 30 <= temperatures[i] <= 100 
 
 Related Topics 栈 数组 单调栈 👍 1006 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L_739_DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new L_739_DailyTemperatures().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 单调栈：
        Deque<Integer> stack = new ArrayDeque<>(temperatures.length);
        int[] result = new int[temperatures.length];
        stack.addLast(0);
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]) {
                int last = stack.removeLast();
                result[last] = i - last;
            }
            stack.addLast(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}