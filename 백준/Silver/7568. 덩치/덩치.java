import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] stats = new int[N][2];
        int[] ranks = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stats[i][0] = Integer.parseInt(st.nextToken());
            stats[i][1] = Integer.parseInt(st.nextToken());
            ranks[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (stats[i][0] < stats[j][0] && stats[i][1] < stats[j][1]) {
                    ranks[i]++; 
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int rank : ranks) {
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}