import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        long sum = 0;
        int N = 0;

        for (int i = 1; ; i++) {
            if (sum + i > S) {
                break;
            }
            sum += i;
            N++;
        }

        System.out.println(N);
    }
}
