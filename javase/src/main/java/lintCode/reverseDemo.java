package lintCode;

import array.Array;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串str和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)。
 * Java: char[] str = {'a', 'b', 'c'};
 * str = "abcdefg" offset=3
 * str = "efgabcd"
 */
public class reverseDemo {
    public static void main(String[] args) {
        char[] str ={'a','b','c','d','e','f','g'};
        String s = new String(str);
        System.out.println(s);
        String s1 = s.substring(0, str.length - 3);
        String s2 = s.substring(str.length-3,str.length);

        System.out.println(s1);
        System.out.println(s2);
        String s3 = s2+s1;
        System.out.println(s3);
        str = s3.toCharArray();
        for (char c:str ) {
            System.out.println(c);
        }
        //reverse(str,3);
    }

    public static  void reverse(char[] str,int offset) {
        int l = str.length, f = offset;
        if (l != 0 && f != 0) {
            if (f > l) {
                f = f % l;
            }
            char[] a = Arrays.copyOf(str, (l - f));
            char[] b = new char[l];
            for (int i = 0; i < l; i++) {
                if (i < f) {
                    b[i] = str[i + (l - f)];
                } else {
                    b[i] = a[i - f];
                }
            }
            str = b;
            //打印数组
            for (int i = 0; i < l; i++) {
                System.out.print(str[i]);
            }
        }
    }

    public static void reverse2(char[] str,int offset){
        if(str == null || str.length == 0){
            return;
        }
        offset= offset % str.length;
        if(offset == 0){
            return;
        }
        int i = 0;
        char tmp;
        char nextTmp = str[0];
        int prevIndex = 0;

        for(int count = 0;count < str.length; count++){
            tmp = nextTmp;
            if(i < str.length - offset){
                i = i + offset;
            }
            else {
                i = i - str.length + offset;
            }
            if(i == prevIndex){
                str[i] = tmp;
                nextTmp = str[++i];
                prevIndex++;
            } else {
                nextTmp = str[i];
                str[i] = tmp;
            }
        }
    }
}

