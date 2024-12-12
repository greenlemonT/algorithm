import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        int[] array2 = new int[n];
        HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            array[i] = array2[i] = scanner.nextInt();
        }

        Arrays.sort(array2);

        int rank = 0;

        for (int value : array2) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int value : array) {
            stringBuilder.append(rankMap.get(value)).append(" ");
        }
        System.out.println(stringBuilder);
    }
}