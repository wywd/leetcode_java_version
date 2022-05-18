package questions.数组;


// https://leetcode-cn.com/problems/fruit-into-baskets/

public class T_904_水果成篮 {

    public int totalFruit(int[] tree) {
        int kind1, kind2;
        int maxTreeSize = 0;
        int left = 0;
        int right = 0;
        kind1 = tree[right++];
        while (right < tree.length && tree[right] == kind1){
            right++;
        }
        if (right == tree.length || right == tree.length - 1) {
            return tree.length;
        }
        kind2 = tree[right++];
        // 这里采用的是从右往左移动left，
        while (right < tree.length){
            // 这里要先判断一下下一棵树是不是新的树的种类
            if (tree[right] != kind1 && tree[right] != kind2) {
                if (maxTreeSize < right - left) {
                    maxTreeSize = right - left;
                }
                left = right - 1;
                while (tree[left - 1] == tree[right - 1]) {
                    left--;
                }
                kind1 = tree[left];
                kind2 = tree[right];
            } else {
                right++;
            }
        }
        if (maxTreeSize < right - left) {
            return right - left;
        }
        return maxTreeSize;
    }
    public int totalFruit2(int[] fruits) {
        if (fruits.length < 3) {
            return fruits.length;
        }
        int res = 0;
        int bucket1;
        int bucket2;
        int count1 = 0;
        int count2 = 0;
        int left = 0;
        int right = 0;

        // 初始阶段
        bucket1 = fruits[0];
        while (right < fruits.length && fruits[right] == bucket1) {
            count1++;
            right++;
        }
        if (right == fruits.length) {
            return count1;
        }
        bucket2 = fruits[right];
        while (right < fruits.length && fruits[right] == bucket2) {
            count2++;
            right++;
        }
        if (right == fruits.length) {
            return count1 + count2;
        }
        res = count1 + count2;

        // 这里采用的是left从左往右滑动，直到一个篮子为空
        while (right < fruits.length) {
            if (fruits[right] == bucket1) {
                count1++;
            } else if (fruits[right] == bucket2) {
                count2++;
            } else {
                while (count1 > 0 && count2 > 0) {
                    if (fruits[left] == bucket1) {
                        count1--;
                    } else {
                        count2--;
                    }
                    left++;
                }
                if (count1 == 0) {
                    bucket1 = fruits[right];
                    count1 = 1;
                } else {
                    bucket2 = fruits[right];
                    count2 = 1;
                }
            }
            right++;
            res = Math.max(res, count1 + count2);
        }
        return res;
    }
}
