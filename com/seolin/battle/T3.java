package com.seolin.battle;

/**
 * @author chenkangkang
 * @date 2022/5/8 10:15 AM
 **/
public class T3 {
    double c = Math.pow(10, 9) + 7;

    double ans = 0;

    public static void main(String[] args) {
        System.out.println(new T3().countTexts(""));
    }

    public int countTexts(String pressedKeys) {
//        int ans = 2082876103;
        dfs(36, 0);
        System.out.println(c);
        return (int) (ans % c);
    }

    private void dfs(int n, int i) {
        if (i == n) {
            ans++;
            return;
        }
        if (i + 1 <= n) {
            dfs(n, i + 1);
        }
        if (i + 2 <= n) {
            dfs(n, i + 2);
        }
        if (i + 3 <= n) {
            dfs(n, i + 3);
        }
    }
}
