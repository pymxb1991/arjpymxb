package lintCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDemo {
    public static void main(String[] args) {
        //List<Integer> narcissisticNumbers = getNarcissisticNumbers(999);
        int x = 2;
        int y = 3;
        String[] ipArray = {"192.168.1.1","192.118.2.1","192.168.1.1"};
        String s = highestFrequency(ipArray);
        System.out.println(s);
    }
    public static List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> test = new ArrayList<Integer>();
        if(n>100){
            for (int i=100;i<n;i++){
                int a1 = i/100;
                int a2 = (i%100)/10;
                int a3 = i%10;
                int a4 = a1*100 + a2*10 + a3;
                int a13 = a1*a1*a1;
                int a23 = a2*a2*a2;
                int a33 = a3*a3*a3;
                int a5 = a13+a23+a33;
                if(a4 == a5){
                    test.add(n);
                }else{
                    continue;
                }

            }

        }
        return test;
    }
    public static String highestFrequency(String[] ipLines) {
        // Write your code here
        Map<String,Integer> ipMap = new HashMap<String,Integer>();
        if(ipLines.length <= 0) return null;
        for(int i=0; i<ipLines.length; i++){
            Integer val = ipMap.get(ipLines[i]);
            if(val != null && val > 0){
                ipMap.put(ipLines[i], val+1);
            }else{
                ipMap.put(ipLines[i], 1);
            }
        }
        Integer max=0;
        String  maxIp =null;
        for(Map.Entry<String,Integer> entry:ipMap.entrySet()){
            String ipStr = entry.getKey();
            Integer ipVal = entry.getValue();
            if(ipVal > max){
                max=ipVal;
                maxIp = ipStr;
            }
        }
        return maxIp;
    }
}
