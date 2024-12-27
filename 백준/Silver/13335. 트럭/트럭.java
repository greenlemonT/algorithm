import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int w = Integer.parseInt(st.nextToken()); 
        int l = Integer.parseInt(st.nextToken()); 

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int time = 0; 
        int bridgeWeight = 0; 
        Queue<Integer> bridge = new ArrayDeque<>(); 
        
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int index = 0; 

        while (index < n || bridgeWeight > 0) {
            time++;
            bridgeWeight -= bridge.poll();
            
            if (index < n && bridgeWeight + trucks[index] <= l) {
                bridge.add(trucks[index]);
                bridgeWeight += trucks[index];
                index++;
            } else {
                bridge.add(0);
            }
        }

        System.out.println(time);
    }
}