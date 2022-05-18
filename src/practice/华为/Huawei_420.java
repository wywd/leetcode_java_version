package practice.华为;

import com.sun.source.tree.Tree;

import java.util.*;

public class Huawei_420 {
    public static void main(String[] args) {

    }
}

//做题，10道判断 10*2，10道单选 10*4，5道多选 5*8，总共100分。
// 按顺序做，错三个结束。给定分数，问有多少种可能的情况

class Main1 {
    public static int n;
    public static int res = 0;
    public static int[] scores = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        dfs(0, 0, 0);
        System.out.println(res);
    }

    public static void dfs(int score, int err, int startIndex) {  // 回溯的思路
        if (err >= 3) {   // 错误次数达到三次，不满足条件
            return;
        }
        if (score >= n) {
            if (score == n) {  // 如果分数达到目标值，则结果+1
                res++;
            }
            return;
        }
        for (int i = startIndex; i < 25; i++) {  // 循环每一题
            score += scores[i];
            dfs(score, err, i + 1);
            score -= scores[i];
            err++;
        }
    }
}


//将一棵根二叉树按照给定路径，替换其中一部分为另一棵子二叉树。
//        输入
//        第一行：一个数组，表示根二叉树，空节点用0表示
//        格式-> [1,1,2,0,0,4,5]
//        第二行：一个字符串，表示要替换位置所在的节点
//        格式-> /1/2
//        第三行：一个数组，表示子二叉树，空节点用0表示
//        格式-> [5,3,0]
//        输出
//        一个数组，表示替换后的根二叉树，空节点跳过
//        格式-> [1,1,5,3]
class Main2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        TreeNode A = buildTree(s1);  // 构建原始的树
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        TreeNode B = buildTree(s3);  // 构建替换的子树
        TreeNode root = replace(A, B, s2);
        List<Integer> res = levelTravel(root);
        System.out.print("[");
        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + ",");
        }
        System.out.print(res.get(res.size() - 1) + "]");
    }

    public static TreeNode buildTree(String data) {
        Queue<TreeNode> s1 = new ArrayDeque<>();
        int nowPos = 1;
        int tmp;
        tmp = data.charAt(nowPos) - '0';
        s1.offer(new TreeNode(tmp));
        TreeNode head = s1.peek();
        nowPos += 2;
        while (nowPos < data.length()) {
            tmp = data.charAt(nowPos) - '0';
            if (tmp != 0) {
                s1.peek().left = new TreeNode(tmp);
                s1.offer(s1.peek().left);
            }
            nowPos += 2;
            if (nowPos >= data.length()) break;
            tmp = data.charAt(nowPos) - '0';
            if (tmp != 0) {
                s1.peek().right = new TreeNode(tmp);
                s1.offer(s1.peek().right);
            }
            nowPos += 2;
            s1.poll();
        }
        return head;
    }

    public static TreeNode replace(TreeNode p, TreeNode q, String str) {
        TreeNode cur = p;
        TreeNode pre = cur;
        for (int i = 3; i < str.length(); i += 2) {
            pre = cur;
            if (cur.left != null && cur.left.val == str.charAt(i) - '0') {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (pre == p) {  // 替换首节点单独考虑
            return q;
        }
        if (pre.left == cur) {
            pre.left = q;
        } else {
            pre.right = q;
        }
        return p;
    }

    public static List<Integer> levelTravel(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pollFirst();
            res.add(temp.val);
            if (temp.left != null) {
                queue.offerLast(temp.left);
            }
            if (temp.right != null) {
                queue.offerLast(temp.right);
            }
        }
        return res;
    }
}
/*
#include<iostream>
#include<vector>
#include<string>
#include<sstream>

using namespace std;

int numsSize = 0, repSize = 0;

void replace(vector<int>& nums, int i, vector<int>& rep, int j) {
	if (i >= numsSize) return;
	nums[i] = rep[j];
	replace(nums, i * 2 + 1, rep, j * 2 + 1);
	replace(nums, i * 2 + 2, rep, j * 2 + 2);
}

int main() {
	// 这里采用了数组来储存二叉树结构
	vector<int> nums(1024), rep(1024);  // nums是原二叉树；rep是要替换的新的子树
	string line, item;
	// 读取第一行：[1,1,2,0,0,4,5]
	getline(cin, line);
	stringstream ss(line.substr(1));
	while (getline(ss, item, ',')) {
		nums[numsSize++] = stoi(item);
	}
	getline(cin, line);
	stringstream ss2(line.substr(3));  // 从索引3开始，因为头节点肯定匹配，直接从第二层开始寻找
	int node, idx = 0;
	while (getline(ss2, item, '/')) {  // 找到要替换的子树的头节点在数组中的索引位置idx
		node = stoi(item);
		if (nums[idx * 2 + 1] == node) {
			idx = idx * 2 + 1;
		}
		else {
			idx = idx * 2 + 2;
		}
	}
	// 读取第三行，新的子二叉树到rep数组中
	getline(cin, line);
	stringstream ss3(line.substr(1));
	while (getline(ss3, item, ',')) {
		rep[repSize++] = stoi(item);
	}

	// 主要的函数
	replace(nums, idx, rep, 0);

	cout << '[' << nums[0];
	for (int i = 1; i < nums.size(); ++i) {
		if (nums[i])
			cout << ',' << nums[i];
	}
	cout << ']' << endl;
	return 0;
}
 */

class Main3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode father;
        TreeNode(int val) {
            this.val = val;
        }
    }
    Map<Integer, TreeNode> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] fathers = new int[n];
        TreeNode[] treeNodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            treeNodes[i] = new TreeNode(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            fathers[i] = scanner.nextInt();
        }

    }



}

