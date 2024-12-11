import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number=scanner.nextLine();
        scanner.close();

        char[] num=number.toCharArray();
        Arrays.sort(num);

        StringBuilder result=new StringBuilder(new String(num));
        result.reverse();
        System.out.println(result);

    }
}