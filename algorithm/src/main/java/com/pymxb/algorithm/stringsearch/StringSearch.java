package com.pymxb.algorithm.stringsearch;

public class StringSearch {
    public static void main(String[] args) {

        String a = "abcabcaabcabcd";
        String b = "abcabcd";
        int search = search(a.split(""), b.split(""));
        System.out.println(search);
    }

   public static   int search(String[] pat,String[] txt){
        int M = pat.length;
        int N = txt.length;
        for (int i= 0 ;i < N-M ; i++){
            int j;
            for (j=0;j<M;j++){
                if(pat[j] != txt[i+j]){
                    break;
                }
            }
            //pat  全都匹配完了
            if(j==M) return  i;
        }
        //txt 中不存在pat
        return -1;
    }
}
