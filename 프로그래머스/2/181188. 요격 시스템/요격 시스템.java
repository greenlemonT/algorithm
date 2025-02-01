import java.util.*;

//감시카메라 문제와 동일
class Solution {
    public int solution(int[][] targets) {
    
        Arrays.sort(targets,(a,b)-> Integer.compare(a[1],b[1]));
        int answer = 0;
        double last=Integer.MIN_VALUE;
        for(int[] target: targets){
            int start=target[0];
            int end=target[1];
            if(last<start){
                answer++;
                last=end-0.5;
            }
        }
        
        return answer;
    }
}