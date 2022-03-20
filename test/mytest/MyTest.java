package mytest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class MyTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/11/3 15:30
 **/

@Slf4j(topic = "MyTest.class")
public class MyTest {
    @Test
    public void test1() {
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            a.add(String.valueOf(i));
        }
        log.info(String.join("->", a));
    }

    @Test
    public void test2() {
        int[] inorder = new int[]{11, 9, 16, 3, 15, 20, 7};
        int[] postorder = new int[]{11, 16, 9, 15, 7, 20, 3};
        int pos = arraySearch(inorder, postorder[postorder.length - 1]);
        log.info("pos: {}", pos);
    }

    public int arraySearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) return i;
        }
        return -1;
    }

    @Test
    public void testChar() {
        int n = 2;
        char c = (char) (n + '0');
        System.out.println(c == '2');
    }

    @Test
    public void test3() {
        Pattern p = Pattern.compile("\\d{2,}");//这个2是指连续数字的最少个数
        String u = "abc435345defsfsaf564565fsabad5467755fewfadfgea";
        Matcher m = p.matcher(u);
        int i = 0;
        while (m.find()) {
            System.out.println(m.group());
            i++;
        }
        System.out.println(i);
    }

    @Test
    public void test4() {
        int[] weight = {3, 1, 4};
        int[] value = {20, 15, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int wLen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wLen + 1][bagSize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wLen; i++){
            dp[i][0] = value0;
        }

        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= wLen; i++){
            for (int j = 1; j <= bagSize; j++){
                if (j < weight[i - 1]){  // 如果第i件物品比包还要重，那么肯定就放不下了，所以有了这个分支
                    dp[i][j] = dp[i - 1][j];
                }else{
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);  // 0-1背包
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i - 1]] + value[i - 1]);  // 完全背包
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= wLen; i++){
            for (int j = 0; j <= bagSize; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    @Test
    public void test5() {
        int[] weight = {3, 1, 4};
        int[] value = {20, 15, 30};
        int bagWight = 4;
        testWeightBagProblem2(weight, value, bagWight);
    }

    // 滚动数组
    public static void testWeightBagProblem2(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            //打印dp数组
            for (int j = 0; j <= bagWeight; j++){
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }

    @Test
    public void test6() {
        int x = (int) Math.sqrt(12);
        System.out.println(x);
    }

}
