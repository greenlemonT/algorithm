import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count=0;
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String string = sc.nextLine();
            if(isGroupWord(string)){
                count++;
            }
        }

        System.out.println(count);

    }
    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26];
        char lastChar = '\0';

        for (char c : word.toCharArray()) {
            if (visited[c - 'a'] && c != lastChar) {
                return false;
            }
            visited[c - 'a'] = true;
            lastChar = c;
        }

        return true;
    }
}
