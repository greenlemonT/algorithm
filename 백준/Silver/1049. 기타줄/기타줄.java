import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();

        int minPackage=Integer.MAX_VALUE;
        int minSingle=Integer.MAX_VALUE;

        for (int i=0;i<M;i++) {
            int packagePrice=sc.nextInt();
            int singlePrice=sc.nextInt();

            minPackage=Math.min(minPackage,packagePrice);
            minSingle=Math.min(minSingle,singlePrice);
        }


        int case1=(N/6+1)*minPackage;
        int case2=(N/6)*minPackage+(N%6)* minSingle;
        int case3=N*minSingle;


        int result=Math.min(case1,Math.min(case2,case3));
        System.out.println(result);
    }
}
