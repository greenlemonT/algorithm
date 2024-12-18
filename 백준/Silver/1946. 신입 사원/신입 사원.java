import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        for(int i=0;i<N;i++){
            int M=sc.nextInt();
            int count=1;
            int work[] = new int[M+1];

            for(int j=0;j<M;j++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                work[a]=b;
            }

            int ace=work[1];

            for(int j=2;j<=M;j++){
                if(work[j]<ace){
                    ace=work[j];
                    count++;
                }
            }
            System.out.println(count);

        }
        sc.close();
    }
}