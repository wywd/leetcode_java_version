package questions.排序算法;

import org.junit.Test;

import java.util.*;

public class SortTest {

    @Test
    public void sortTest() {
//        int[] nums = {5, 8, 6, 3, 9, 2, 1, 7};
        double[] nums = {5, 8, 6, 3, 9, 2, 1, 7};
//        int[] nums = {8, 2, 3, 4, 5, 6, 7, 1};
//        int[] nums = {5, 8, 6, 3, 9, 2, 1, 7, 3, 4, 7, 9, 23, 1, 45, 645, 234, 34, 0, -2, 4, 7, 43, 24, 178, 179, 180, 201, 1};
//        Sort.bubbleSort(nums);  // 冒泡排序
//        Sort.cocktailSort(nums);  // 鸡尾酒排序
//        Sort.quickSort(nums, 1); // 快速排序
//        Sort.heapSort(nums);  // 堆排序
//        Sort.countSort(nums); // 计数排序
//        Sort.mergeSort(nums); // 归并排序
//        Sort.shellSort(nums);  // 希尔排序
        Sort.bucketSort(nums);  // 桶排序
        System.out.println(Arrays.toString(nums));
    }
}
