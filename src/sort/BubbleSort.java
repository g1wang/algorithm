package sort;

/**
 * 冒泡儿
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arrays = new int[]{1,5,3,8,4,9,2,0};
        //控制当前比较的数组大小
        int a;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length-i-1; j++) {
                if (arrays[j]>arrays[j+1]){
                    a = arrays[j];
                    arrays[j] = arrays[j+1];
                    arrays[j+1] = a;
                }
            }
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }
}
