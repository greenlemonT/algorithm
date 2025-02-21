//투포인터
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int aindex=0;
        int bindex=0;
        int score=0;
        
        while(bindex<B.length){
            if(B[bindex]>A[aindex]){
                score++;
                aindex++;
            }
            bindex++;
        }
        return score;
    }
}