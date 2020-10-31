package com.seolin.question.question1000.question79;


/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * Related Topics 数组 回溯算法
 *
 * @author liangzi on 2020/10/30
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        char[] words = word.toCharArray();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == words[0]) {
                    if (dfs(board, words, visited, i, j, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, boolean[][] visited, int i, int j, int r, int c, int wordLength) {
        if (board[i][j] != words[wordLength]) {
            return false;
        } else if (wordLength == words.length - 1) {
            return true;
        }
        visited[i][j] = true;

        int[][] steps = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean result = false;

        for (int[] step : steps) {
            int nextI = step[0] + i;
            int nextJ = step[1] + j;
            if (nextI < 0 || nextJ < 0 || nextI >= r || nextJ >= c) {
                continue;
            }
            if (visited[nextI][nextJ]) {
                continue;
            }
            if (dfs(board, words, visited, nextI, nextJ, r, c, wordLength + 1)) {
                result = true;
                break;
            }

        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        System.out.println(new Solution().exist(board, word));
    }
}
