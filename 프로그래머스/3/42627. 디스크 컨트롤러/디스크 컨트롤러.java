import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //작업 시작순서 기준 정렬
        Arrays.sort(jobs,(a,b) -> Integer.compare(a[0],b[0]));
        Queue<int[]> pq=new PriorityQueue<>((a,b) ->{
        if(a[1]==b[1])
            return a[0]-b[0];
        return a[1]-b[1];});
        int time=0, index=0, totaltime=0,count=0;
        int answer=0;
        while(count<jobs.length){
            while(index<jobs.length&&jobs[index][0]<=time){
                pq.offer(jobs[index++]);
            }
            if(!pq.isEmpty()){
                int[] job=pq.poll();
                time+=job[1];
                totaltime+=(time-job[0]);
                count++;
            }
            else{
                time=jobs[index][0];
            }
        }
        answer=totaltime/jobs.length;                         
        return answer;
    }
}