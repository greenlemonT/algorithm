import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNumber = br.readLine();

        int[] count = new int[10];

        for (char c : roomNumber.toCharArray()) {
            count[c - '0']++;
        }

        int sixNineCount = count[6] + count[9];
        count[6] = count[9] = (sixNineCount + 1) / 2;

        int maxSet = 0;
        for (int i = 0; i < 10; i++) {
            maxSet = Math.max(maxSet, count[i]);
        }

        System.out.println(maxSet);
    }
}

