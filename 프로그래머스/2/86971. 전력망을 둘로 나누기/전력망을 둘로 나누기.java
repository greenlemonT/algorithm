import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int min;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];
        min = Integer.MAX_VALUE;

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 각 간선을 제거하며 탐색
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 간선 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            // DFS 탐색
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(1, visited); // 임의의 시작점에서 탐색

            // 결과 갱신
            int diff = Math.abs(cnt - (n - cnt));
            min = Math.min(min, diff);

            // 간선 복원
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }

    static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for (int next : graph[v]) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }
}
