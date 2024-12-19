import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] a = input.toCharArray();
        Arrays.sort(a);

        StringBuilder sb = new StringBuilder(new String(a));
        sb.reverse();

        System.out.println(sb);
    }
}
