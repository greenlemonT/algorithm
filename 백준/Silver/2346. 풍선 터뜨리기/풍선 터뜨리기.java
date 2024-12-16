import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] papers = new int[n];

        for (int i = 0; i < n; i++) {
            papers[i] = sc.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        while (!deque.isEmpty()) {
            int currentIndex = deque.pollFirst(); // 터뜨릴 풍선 번호
            System.out.print(currentIndex + " ");
            if (deque.isEmpty()) break;
            int move = papers[currentIndex - 1]; // 해당 풍선에 적힌 숫자
            int size = deque.size();

            if (move > 0) {
                int optimizedMove = (move - 1) % size;
                for (int i = 0; i < optimizedMove; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                int optimizedMove = (-move) % size;
                for (int i = 0; i < optimizedMove; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
    }
}
