import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        Set<String> a = new HashSet<>();
        for (int i = 0; i < N; i++) {
            a.add(sc.nextLine());
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = sc.nextLine();
            if (a.contains(name)) {
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (String name : result) {
            System.out.println(name);
        }
    }
}