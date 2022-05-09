package com.seolin.battle;

/**
 * @author chenkangkang
 * @date 2022/5/8 10:15 AM
 **/
public class T1 {
    public static void main(String[] args) {
        String num = "6777133339";
//        String num = "42352338";
//        String num = "2300019";
        System.out.println(new T1().largestGoodInteger(num));
    }

    public String largestGoodInteger(String num) {
        int n = num.length();
        int c = -1;
        String ans = "";
        for (int i = 0; i < n - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (c < (int) num.charAt(i)) {
                    c = num.charAt(i);
                    ans = num.substring(i, i + 3);
                }
            }
        }
        return ans;
    }
}
