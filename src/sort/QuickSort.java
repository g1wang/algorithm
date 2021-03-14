package sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[] { 3, 1, 4, 51, 36, 47, 3,100, 9,3 };
        int low = 0;
        int high = a.length - 1;
        quickSort(a, low, high);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void swap(int[] a, int sa, int sb) {
        int c;
        c = a[sa];
        a[sa] = a[sb];
        a[sb] = c;
    }

    public static int partition(int[] a, int low, int high) {

        // 设置基准数
        int key = a[low];
        while (low < high) {
            // 从右寻找小于基准数的值
            while (low < high && a[high] >= key) {
                high--;
            }
            // 找到比key小的，交换
            swap(a, low, high);
            // 换边，从左找比key大的
            while (low < high && a[low] <= key) {
                low++;
            }
            // 找到比key大的，交换
            swap(a, low, high);

        }
        return low;

    }

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int loc = partition(a, low, high);
            quickSort(a, low, loc-1);
            quickSort(a, loc+1, high);
        }

    }

}


