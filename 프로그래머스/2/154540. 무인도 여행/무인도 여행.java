
import java.util.*;


    public class Solution {
        private static final int[] dx = {-1, 1, 0, 0};
        private static final int[] dy = {0, 0, -1, 1};


        public int[] solution(String[] maps) {
            int rows = maps.length;
            int cols = maps[0].length();
            boolean[][] visited = new boolean[rows][cols];
            List<Integer> answer = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                        answer.add(bfs(maps, visited, i, j));
                    }
                }
            }

            if (answer.isEmpty()) {
                return new int[]{-1};
            }
            Collections.sort(answer);

            int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
            return result;
        }

        private int bfs(String[] maps, boolean[][] visited, int startX, int startY) {
            int rows = maps.length;
            int cols = maps[0].length();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startX, startY});
            visited[startX][startY] = true;

            int sum = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                sum += maps[x].charAt(y) - '0';

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }

            }
            return sum;
        }
    }



