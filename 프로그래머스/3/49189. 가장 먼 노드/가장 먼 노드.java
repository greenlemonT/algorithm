

import java.util.*;

public class Solution{
        public int solution(int n, int[][] vertex) {

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : vertex) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            int[] distances = new int[n + 1];
            Arrays.fill(distances, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            distances[1] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int neighbor : graph.get(current)) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[current] + 1;
                        queue.offer(neighbor);
                    }
                }
            }

            int maxDistance = Arrays.stream(distances).max().getAsInt();

            int count = 0;
            for (int distance : distances) {
                if (distance == maxDistance) {
                    count++;
                }
            }
            return count;
        }
}

