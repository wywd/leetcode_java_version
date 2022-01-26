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
                add(new ArrayList<>() {{add("JFK"); add("KUL");}});
                add(new ArrayList<>() {{add("JFK"); add("NRT");}});
                add(new ArrayList<>() {{add("NRT"); add("JFK");}});
            }
        };
        List<String> res = solution.findItinerary(tickets);
        System.out.println(res);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {  // 利用回溯的思想去解决这个问题，不过我们的递归函数不再是void而是boolean，因为我们只需要找到一条最优行程
    List<String> res = new ArrayList<>();  // TreeMap可以保持key是升序的
    Map<String, TreeMap<String, Integer>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //比如: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> treeMap = map.get(from);
            treeMap.put(to, treeMap.getOrDefault(to, 0) + 1);
        }
        res.add("JFK");
        helper(tickets);
        return res;
    }

    boolean helper(List<List<String>> tickets) {
        if (res.size() == tickets.size() + 1) {  // 表示找到了最优行程
            return true;
        }
        TreeMap<String, Integer> tos = map.get(res.get(res.size()-1));
        if (tos == null || tos.isEmpty()) return false;
        for (String str: tos.keySet()) {
            if (tos.get(str) == 0) continue;  // 表示当前车票已经使用了

            // 加入了res，需要把这个车票数目-1
            res.add(str);
            tos.put(str, tos.get(str) - 1);

            if (helper(tickets)) return true;  // 如果找到了行程直接返回True，因为我们只需要找一个最优解

            // 否则回溯
            res.remove(res.size()-1);
            tos.put(str, tos.get(str) + 1);
        }

        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


}