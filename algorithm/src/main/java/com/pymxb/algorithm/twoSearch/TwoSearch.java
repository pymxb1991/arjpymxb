package com.pymxb.algorithm.twoSearch;

public class TwoSearch {
    public static void main(String[] args) {
        int[] arrayTest = {1,2,3,4,5,6,7,8,9,10,11,12};
        int test = test(arrayTest, 4);
        System.out.println(test);
    }

    public static int test(int[] arrayTest,int temp){

        int low = arrayTest[0];
        int hight = arrayTest[arrayTest.length - 1];
        int i = 0;
        while (low <= hight) {
            int mid = (hight + low) / 2;
            int guess = arrayTest[mid];
            if (guess == temp){
                return guess;
            }
            if (guess > temp){
                hight = mid -1;
            } else {
                low = mid + 1;
            }
            i ++ ;
        }
        return i;
    }
}
