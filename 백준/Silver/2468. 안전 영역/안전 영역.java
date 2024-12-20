import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static int max;
    static int count;
    static StringTokenizer st;
    static int answer=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(matrix[i][j], max);
            }
        }

        for (int h = 1; h <= max; h++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (matrix[i][j] > h && !visited[i][j]) {
                        count++;
                        dfs(i, j, h);
                    }
                }
            }
            answer=Math.max(answer,count);
        }
        System.out.println(answer);
    }

        static void dfs(int x,int y,int h){
            visited[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int nx=x+dx[i];
                int ny=y+dy[i];
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && !visited[nx][ny] && matrix[nx][ny] > h) {
                    dfs(nx, ny, h);
                }

            }
        }
}
