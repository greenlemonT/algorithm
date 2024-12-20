import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] check;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team(0, 0);
        System.out.println(min);
    }

    static void team(int depth, int start) {
        if (depth == N / 2) {
            difference();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                team(depth + 1, i + 1);
                check[i] = false;
            }
        }
    }

    static void difference() {
        int a = 0, b = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i] && check[j]) {
                    a += S[i][j];
                } else if (!check[i] && !check[j]) {
                    b += S[i][j];
                }
            }
        }

        int diff = Math.abs(a - b);
        min = Math.min(min, diff);
    }
}
