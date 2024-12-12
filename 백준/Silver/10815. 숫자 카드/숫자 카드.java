import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder=new StringBuilder();

        int n=Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        Set<Integer> card=new HashSet<>();

        for (int i = 0; i < n; i++) {
            card.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int m=Integer.parseInt(bufferedReader.readLine());
        stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i <m; i++) {
            int number=Integer.parseInt(stringTokenizer.nextToken());
            if(card.contains(number)){
                stringBuilder.append("1 ");
            }
            else{
                stringBuilder.append("0 ");
            }
        }
        System.out.println(stringBuilder);
    }
}

