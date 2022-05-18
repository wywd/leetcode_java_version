package questions.排序算法;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Sort {
    private static int debugCount = 0;  // 仅调试使用
    private static final Random RANDOM = new Random();  // 快速排序-基准元素选择

    // 冒泡排序（+两次优化）
    public static void bubbleSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int lastExchangeIndex = 0;  // 记录最后一次交换的位置
        int sortBorder = nums.length - 1;  // 无序数列的边界
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;  // 有序标记，如果某一次比较过程没有发生交换，说明已经有序
            for (int j = 0; j < sortBorder; j++) {
                debugCount++;
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            sortBorder = lastExchangeIndex;
        }
        System.out.println("冒泡排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 鸡尾酒排序（冒泡排序升级版-冒泡不对称，鸡尾酒对称）
    public static void cocktailSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int leftSortedIndex = 0;
        int rightSortedIndex = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            boolean isSorted = true;
            for (int j = leftSortedIndex; j < rightSortedIndex; j++) {
                debugCount++;
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                    rightIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            rightSortedIndex = rightIndex;
            isSorted = true;
            for (int j = rightSortedIndex - 1; j > leftSortedIndex; j--) {
                debugCount++;
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    isSorted = false;
                    leftIndex = j;
                }
            }
            if (isSorted) {
                break;
            }
            leftSortedIndex = leftIndex;
        }
        System.out.println("鸡尾酒排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 快速排序算法
    public static void quickSort(int[] nums, int mode) {
        if (nums == null) {
            return;
        }
        if (mode == 1) {
            quick_sort1(nums, 0, nums.length - 1);
        } else {
            quick_sort2(nums, 0, nums.length - 1);
        }
        System.out.println("快速排序-" + (mode == 1 ? "双边循环法" : "单边循环法") + "-比较次数：" + debugCount);
        debugCount = 0;
    }

    // 快速排序-递归-双边循环法
    private static void quick_sort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = RANDOM.nextInt(right - left + 1) + left;
        int x = nums[left];
        nums[left] = nums[index];
        nums[index] = x;
        x = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (j > i && nums[j] > x) {
                debugCount++;
                j--;
            }
            while (i < j && nums[i] <= x) {
                debugCount++;
                i++;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = x;
        quick_sort1(nums, left, i - 1);
        quick_sort1(nums, i + 1, right);
    }

    // 快速排序-递归-单边循环法
    private static void quick_sort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = RANDOM.nextInt(right - left + 1) + left;
        int x = nums[left];
        nums[left] = nums[index];
        nums[index] = x;
        x = nums[left];
        int mark = left;
        for (int i = left + 1; i <= right; i++) {
            debugCount++;
            if (nums[i] < x) {
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[left] = nums[mark];
        nums[mark] = x;
        quick_sort2(nums, left, mark - 1);
        quick_sort2(nums, mark + 1, right);
    }

    // 堆排序（升序）
    public static void heapSort(int[] nums) {
        if (nums == null) {
            return;
        }
        // 首先构建一个最大堆
        buildHeap(nums);
        //然后循环将最大元素移动到数组末尾，并用堆中最后一个叶子节点替换到根节点，然后进行下沉操作
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            downAdjust(nums, 0, i);
        }
        System.out.println("堆排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 构建堆
    private static void buildHeap(int[] nums) {
        // 从最后一个非叶子节点开始，依次做下沉操作
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            downAdjust(nums, i, nums.length);
        }
    }

    // 下沉（删除节点）
    private static void downAdjust(int[] nums, int parentIndex, int length) {
        int temp = nums[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            debugCount++;
            // 如果有右孩子且右孩子更大
            if (childIndex + 1 < length && nums[childIndex + 1] > nums[childIndex]) {
                childIndex++;
            }
            // 如果父节点小于任何一个孩子节点，则退出
            if (temp >= nums[childIndex]) {
                break;
            }
            // 无需交换，单向赋值即可
            nums[parentIndex] = nums[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        nums[parentIndex] = temp;
    }

    // 计数排序
    public static void countSort(int[] nums) {
        if (nums == null) {
            return;
        }
        // 1.得到数组最大值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            debugCount++;
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        // 2.确定数组长度
        int[] countNums = new int[max - min + 1];
        // 遍历数组填充统计数组
        for (int i = 0; i < nums.length; i++) {
            debugCount++;
            countNums[nums[i] - min]++;
        }
        // 遍历统计数组,输出结果
        int index = 0;
        for (int i = 0; i < countNums.length; i++) {
            for (int j = 0; j < countNums[i]; j++) {
                debugCount++;
                nums[index++] = i + min;
            }
        }
        System.out.println("计数排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 归并排序
    public static void mergeSort(int[] nums) {
        if (nums == null) {
            return;
        }
        merge_sort(nums, 0, nums.length - 1);
        System.out.println("归并排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 归并排序具体实现
    private static void merge_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        merge_sort(nums, left, mid);
        merge_sort(nums, mid + 1, right);

        // 第一次执行到这里说明left，right就俩元素，后面逐渐变多
        if (right == left + 1) {
            debugCount++;
            if (nums[left] > nums[right]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        } else {
            int[] temp = new int[right - left + 1];
            int index = 0;
            int lp = left;  // 左半数组下标
            int rp = mid + 1;  // 右半数组下标
            while (lp <= mid && rp <= right) {
                debugCount++;
                if (nums[lp] < nums[rp]) {
                    temp[index++] = nums[lp++];
                } else {
                    temp[index++] = nums[rp++];
                }
            }
            while (lp <= mid) {
                debugCount++;
                temp[index++] = nums[lp++];
            }
            while (rp <= right) {
                debugCount++;
                temp[index++] = nums[rp++];
            }
            // 复制到原数组
            for (int i = 0; i < temp.length; i++) {
                debugCount++;
                nums[left + i] = temp[i];
            }
        }

    }

    // 希尔排序
    public static void shellSort(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int k = nums.length / 2; k >= 1; k--) {
            boolean isSorted = true;
            for (int i = k; i < nums.length; i++) {
                debugCount++;
                if (nums[i] < nums[i - k]) {
                    int temp = nums[i];
                    nums[i] = nums[i - k];
                    nums[i - k] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println("希尔排序比较次数：" + debugCount);
        debugCount = 0;
    }

    // 桶排序
    public static void bucketSort(double[] nums) {
        if (nums == null) {
            return;
        }
        // 得到数组的最大值和最小值，并计算差值d
        double max = nums[0];
        double min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        double d = max - min;

        // 初始化桶
        int bucketNum = nums.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < nums.length; i++) {
            int index = (int) ((nums[i] - min) * (bucketNum - 1) / d);
            bucketList.get(index).add(nums[i]);
        }
        // 对每个桶的内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }
        // 输出全部元素
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double v: list) {
                nums[index++] = v;
            }
        }
    }

}
