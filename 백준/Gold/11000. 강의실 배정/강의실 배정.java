import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures,(a,b)->{
            if(a[1]==a[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],a[1]);
        });

        //종료시간
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] lecture : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lecture[0]) {
                pq.poll();
            }
            pq.add(lecture[1]);
        }

        System.out.println(pq.size());
    }
}
