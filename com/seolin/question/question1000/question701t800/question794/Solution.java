package com.seolin.question.question1000.question701t800.question794;

/**
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * //
 * // 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * //
 * // 以下是井字游戏的规则：
 * //
 * //
 * // 玩家轮流将字符放入空位（' '）中。
 * // 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * // 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * // 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * // 当所有位置非空时，也算为游戏结束。
 * // 如果游戏结束，玩家不允许再放置字符。
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：board = ["O  ","   ","   "]
 * //输出：false
 * //解释：玩家 1 总是放字符 "X" 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：board = ["XOX"," X ","   "]
 * //输出：false
 * //解释：玩家应该轮流放字符。
 * //
 * // 示例 3：
 * //
 * //
 * //输入：board = ["XXX","   ","OOO"]
 * //输出：false
 * //
 * //
 * // Example 4:
 * //
 * //
 * //输入：board = ["XOX","O O","XOX"]
 * //输出：true
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // board.length == 3
 * // board[i].length == 3
 * // board[i][j] 为 'X'、'O' 或 ' '
 * //
 * // Related Topics 数组 字符串 👍 79 👎 0
 *
 * @author chenkangkang
 * @date 2021/12/9 4:31PM
 **/

public class Solution {
    public boolean validTicTacToe(String[] board) {
        //情况1 ： x 先手 所以X数量一定大于或者等于O的数量，并且两者差值不大于1
        //情况2：如果是X 赢了，则X数量大于O的数量，且X数量与O数量之差不大于一
        //情况3：如果是O赢了了，则O数量等于X数量
        //情况4: O与X不能同事赢
        char[][] cs = new char[3][3];
        //统计O与X数量，并且放到c中
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    x++;
                }
                if (c == 'O') {
                    o++;
                }
                cs[i][j] = c;
            }
        }
        boolean a = check(cs, 'X'), b = check(cs, 'O');
        if (x > o + 1) return false;
        if (a && x < o) return false;
        if (b && x != o) return false;
        if (a && b) return false;
        return true;
    }

    private boolean check(char[][] cs, char o) {
        for (int i = 0; i < 3; i++) {
            if (cs[i][0] == o && cs[i][1] == o && cs[i][2] == o) return true;
            if (cs[0][i] == o && cs[1][i] == o && cs[2][i] == o) return true;
        }
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) a &= cs[i][j] == o;
                if (i + j == 2) b &= cs[i][j] == o;
            }
        }
        return a || b;
    }


//    public boolean validTicTacToe(String[] board) {
//        char[][] cs = new char[3][3];
//        int x = 0, o = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                char c = board[i].charAt(j);
//                if (c == 'X') x++;
//                else if (c == 'O') o++;
//                cs[i][j] = c;
//            }
//        }
//        boolean a = check(cs, 'X'), b = check(cs, 'O');
//        if (o > x || x - o > 1) return false;
//        if (a && x <= o) return false;
//        if (b && o != x) return false;
//        if (a && b) return false;
//        return true;
//    }
//
//    //校验
//    boolean check(char[][] cs, char c) {
//        for (int i = 0; i < 3; i++) {
//            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
//            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
//        }
//        boolean a = true, b = true;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (i == j) a &= cs[i][j] == c;
//                if (i + j == 2) b &= cs[i][j] == c;
//            }
//        }
//        return a || b;
//    }
}
