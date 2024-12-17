import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Set<String> a = new HashSet<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String sub = s.substring(i, j);
                a.add(sub);
            }
        }

        System.out.println(a.size());
    }
}
