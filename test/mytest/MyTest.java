package mytest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
}
