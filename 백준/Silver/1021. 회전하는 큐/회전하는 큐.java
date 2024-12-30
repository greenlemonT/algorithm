import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int target : targets) {
            int targetIndex = deque.indexOf(target);
            int halfIndex = deque.size() / 2;

            if (targetIndex <= halfIndex) {
                for (int i = 0; i < targetIndex; i++) {
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            } else {
                for (int i = 0; i < deque.size() - targetIndex; i++) {
                    deque.addFirst(deque.pollLast());
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);
    }
}
