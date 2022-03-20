/**
给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 

 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 

 
 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
 

 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 

 

 示例 1： 

 
输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
输出：["JFK","MUC","LHR","SFO","SJC"]
 

 示例 2： 

 
输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
"SFO"]]
输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
 

 

 提示： 

 
 1 <= tickets.length <= 300 
 tickets[i].length == 2 
 fromi.length == 3 
 toi.length == 3 
 fromi 和 toi 由大写英文字母组成 
 fromi != toi 
 
 Related Topics 深度优先搜索 图 欧拉回路 👍 509 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class L_332_ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new L_332_ReconstructItinerary().new Solution();
        List<List<String>> tickets = new ArrayList<>(){
            {
                add(new ArrayList<>() {{add("EZE"); add("AXA");}});
                add(new ArrayList<>() {{add("TIA"); add("ANU");}});
                add(new ArrayList<>() {{add("ANU"); add("JFK");}});
                add(new ArrayList<>() {{add("JFK"); add("ANU");}});
                add(new ArrayList<>() {{add("ANU"); add("EZE");}});
                add(new ArrayList<>() {{add("TIA"); add("ANU");}});
                add(new ArrayList<>() {{add("AXA"); add("TIA");}});
                add(new ArrayList<>() {{add("TIA"); add("JFK");}});
                add(new ArrayList<>() {{add("ANU"); add("TIA");}});
                add(new ArrayList<>() {{add("JFK"); add("TIA");}});
            }
        };
        List<String> res = solution.findItinerary(tickets);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    Map<String, TreeMap<String, Boolean>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            map.get(from).put(to, false);
        }
        res.add("JFK");
        helper(tickets, "JFK");
        return res;
    }

    boolean helper(List<List<String>> tickets, String from) {
        if (res.size() == tickets.size() + 1) {  // 找到了最有行程
            return true;
        }
        TreeMap<String, Boolean> tree = map.get(from);
        if (tree == null || tree.isEmpty()) {  // 不存在from为出发点的路程
            return false;
        }
        for (String to: tree.keySet()) {
            if (tree.get(to)) { // 表示当前车票已经被用了
                continue;
            }
            res.add(to);
            tree.put(to, true);
            if (helper(tickets, to)) {  // 如果找到最优的就返回true
                return true;
            }
            // 否则回溯
            res.remove(res.size() - 1);
            tree.put(to, false);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}