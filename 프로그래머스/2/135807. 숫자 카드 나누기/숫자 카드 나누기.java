
public class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a=calculate(arrayA);
        int b=calculate(arrayB);
        
        int maxA=isValid(a,arrayB) ? a:0;
        int maxB=isValid(b,arrayA) ? b:0;
        
        return Math.max(maxA,maxB);

    }
    private int calculate(int[] array){
        int gcd=array[0];
        for(int num:array){
            gcd=gcd(gcd,num);
            if(gcd==1) break;
        }
        return gcd;
    }
    
    //최소공약수 구하기
    private int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    private boolean isValid(int gcd,int[] array){
        for(int num: array){
            if(num%gcd==0){
                return false;
            }
        }
        return true;
    }
}


