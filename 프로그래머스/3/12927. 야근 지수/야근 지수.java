//priorityqueue

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        //내림차순
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work:works){
            pq.offer(work);
        }
        
        while(n>0&&!pq.isEmpty()){
            int maxWork=pq.poll();
            if(maxWork>0){
                pq.offer(maxWork-1);
            }
            n--;
        }
        
        long tired=0;
        while(!pq.isEmpty()){
            int work=pq.poll();
            tired+=(long)work*work;
        }
        return tired;
    }
}