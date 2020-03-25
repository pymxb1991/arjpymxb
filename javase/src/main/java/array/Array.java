package array;

import java.util.ArrayList;

/**
 * 内存分析见resource 中图片分析
 */
public class Array {
    public static void main(String[] args) {
        //动态数组
        int[] array1 = new int[3];
        // 静态数组
        String[]  array2 = new String[]{"a","b","c"};

        String[] Array = { "a", "b", "c", "d", "e" };
        reverseArray1(Array);// 使用集合ArrayList实现反转
        for (int j = 0; j < Array.length; j++) {
            System.out.print(Array[j] + " ");
        }

        System.out.print("\n");
        String[] temp = reverseArray2(Array);// 直接使用数组实现反转
        for (int j = 0; j < temp.length; j++) {
            System.out.print(Array[j] + " ");
        }

    }

    /*
     * 函数：reverseArray1和reverseArray2
     * 功能：实现 数组翻转
     * 例如：{'a','b','c','d'}变成{'d','c','b','a'}
     */
    private static void reverseArray1(String[] Array) {
        ArrayList<String> array_list = new ArrayList<String>();
        for (int i = 0; i < Array.length; i++) {
            array_list.add(Array[Array.length - i - 1]);
        }
        Array = array_list.toArray(Array);
    }

    private static String[] reverseArray2(String[] Array) {
        String[] new_array = new String[Array.length];
        for (int i = 0; i < Array.length; i++) {
            // 反转后数组的第一个元素等于源数组的最后一个元素：
            new_array[i] = Array[Array.length - i - 1];
        }
        return new_array;
    }


}
