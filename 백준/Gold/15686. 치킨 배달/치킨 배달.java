import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N,M;
    static int[][] matrix;
    static ArrayList<int[]> house=new ArrayList<>();
    static ArrayList<int[]> chicken=new ArrayList<>();
    static ArrayList<int[]> choice=new ArrayList<>();
    static int result=Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] matrix=new int[N][N];

        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j]=Integer.parseInt(st.nextToken());
                if(matrix[i][j]==1){
                    house.add(new int[]{i,j});
                }
                if (matrix[i][j]==2){
                    chicken.add(new int[]{i,j});
                }

            }
        }
        visited=new boolean[chicken.size()];
        back(0,0);
        System.out.println(result);
}

    static void back(int depth,int start){
        if(depth==M){
            int sum=0;
            for(int[] h:house){
                int min=Integer.MAX_VALUE;
                for (int[] c: choice){
                    int d=Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]);
                    min=Math.min(d,min);
                }
                sum+=min;
            }
            result=Math.min(result,sum);
            return;
        }
        for (int i = start; i <chicken.size() ; i++) {
            if(!visited[i]){
                visited[i]=true;
                choice.add(chicken.get(i));
                back(depth+1,i+1);
                choice.remove(choice.size()-1);
                visited[i]=false;
            }
        }
    }
}