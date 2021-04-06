package sort;

/*
TOP-K
BFPRT（）:
1) n/5个group，插入排序找中位数，再从这些中位数中找中位数pivot
2) 根据pivot划分 2 parts
3）找根据part大小找k
 */
public class BFPRT {


    private static int bfprt(int[] nums, int s, int e, int k) {
        int mid = findMid(nums, s, e);
        int p = partion(nums, s, e, mid);
        //TOP m
        int m = e - p + 1;
        if (m == k) return nums[p];
        if (m > k) {
            return bfprt(nums, p + 1, e, k);
        } else return bfprt(nums, s, p - 1, k - m);

    }

    //插入排序
    private static void insertSort(int[] nums, int s, int e) {
        for (int i = s + 1; i <= e; i++) {
            if (nums[i - 1] > nums[i]) {
                int k = i;
                int tmp = nums[k];
                while (k > s && nums[k - 1] > tmp) {
                    nums[k] = nums[k - 1];
                    k--;
                }
                nums[k] = tmp;
            }
        }
    }

    //找中位数
    private static int findMid(int[] nums, int s, int e) {
        if (s == e) return s;
        int i = s;//原数组
        int j = s;//新中位数数组
        for (; i < e - 5; i += 5, j++) {
            insertSort(nums, i, i + 4);
            swap(nums, j, i + 2);
        }
        int remain = e - i + 1;
        if (remain > 0) {
            insertSort(nums, i, e);
            swap(nums, j, i + remain / 2);
        }
        return findMid(nums, s, j);
    }

    //二分
    private static int partion(int[] nums, int s, int e, int p) {
        swap(nums, s, p);
        int pivot = nums[s];
        while (s < e) {
            while (pivot <= nums[e] && s < e) {
                e--;
            }
            nums[s] = nums[e];
            while (pivot >= nums[s] && s < e) {
                s++;
            }
            nums[e] = nums[s];
        }
        nums[s] = pivot;
        return s;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 9, 2, 7, 4, 6, 1,11,33,22,55,66,99,12,13,43,54};
        //insertSort(nums, 0, nums.length - 1);
        //int p = partion(nums, 0, nums.length - 1, 4);
//        for (int i = 0; i <= p; i++) {
//            System.out.println(nums[i]);
//        }

        int k = bfprt(nums, 0, nums.length - 1, 5);
        // int mid = findMid(nums, 0, nums.length - 1);
        System.out.println(k);
    }
}
