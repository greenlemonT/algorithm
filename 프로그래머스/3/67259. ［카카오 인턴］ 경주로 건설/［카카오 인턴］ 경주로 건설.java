import java.util.*;
//bfs+다익스트라

class Solution {
    static class Node {
        int x, y, cost, dir;

        public Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }

    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1}; 
    static final int STRAIGHT = 100;
    static final int CORNER = 500;

    public int solution(int[][] board) {
        int N = board.length;
        int[][][] cost = new int[N][N][4];

        for (int[][] row : cost) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1)); // 시작점 예외 처리 (-1)
        Arrays.fill(cost[0][0], 0);

        int minCost = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int currCost = node.cost;
            int currDir = node.dir;

            if (x == N - 1 && y == N - 1) {
                minCost = Math.min(minCost, currCost);
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) {
                    continue;
                }

                int newCost = currCost + STRAIGHT;
                if (currDir != -1 && currDir != i) {
                    newCost += CORNER;
                }

                if (newCost < cost[nx][ny][i]) {
                cost[nx][ny][i] = newCost;
                q.add(new Node(nx, ny, newCost, i));
                }

            }
        }
        return minCost;
    }
}
