import java.util.*;

class Solution{
    public int solution(int[] scoville, int K) {
        Queue<Integer> pq=new PriorityQueue<>();
        for(int num:scoville){
            pq.offer(num);
        }
        int count=0;
        while(pq.size()>1&&pq.peek()<K){
            int a=pq.poll();
            int b=pq.poll();
            int c=a+(b*2);
            pq.offer(c);
            count++;
        }
        //하나 남았는데 k보다 작을때
        if(pq.peek()<K) return -1;
        return count;
    }
}