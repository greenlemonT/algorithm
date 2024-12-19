import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        String[][] students=new String[N][4];
        for (int i = 0; i < N; i++) {
            students[i][0]=sc.next();
            students[i][1]=sc.next();
            students[i][2]=sc.next();
            students[i][3]=sc.next();
        }

        Arrays.sort(students, (a, b) -> {
            int koreanA = Integer.parseInt(a[1]);
            int koreanB = Integer.parseInt(b[1]);
            int englishA = Integer.parseInt(a[2]);
            int englishB = Integer.parseInt(b[2]);
            int mathA = Integer.parseInt(a[3]);
            int mathB = Integer.parseInt(b[3]);

            if (koreanA != koreanB) return koreanB - koreanA;
            if (englishA != englishB) return englishA - englishB;
            if (mathA != mathB) return mathB - mathA;
            return a[0].compareTo(b[0]);
        });

        for (int i = 0; i < N; i++) {
            System.out.println(students[i][0]);
        }
    }
}