public class Solution {
        public int solution(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            int maxLength = 0;

            int[][] dp = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                dp[i][0] = board[i][0];
                maxLength = Math.max(maxLength, dp[i][0]);
            }
            for (int j = 0; j < cols; j++) {
                dp[0][j] = board[0][j];
                maxLength = Math.max(maxLength, dp[0][j]);
            }

            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (board[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    }
                }
            }
            return maxLength * maxLength;
        }
    }
