
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int[][] points=new int[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0]=scanner.nextInt();
            points[i][1]=scanner.nextInt();
        }

        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(a[1],b[1]);
            }
            else{
                return Integer.compare(a[0],b[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(points[i][0]+" "+points[i][1]);

        }
    }
}