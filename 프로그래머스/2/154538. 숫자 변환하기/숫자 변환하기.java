import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x==y) return 0;
        boolean[] visited=new boolean[1000001];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[] {x,0});
        visited[x]=true;
        
        while(!q.isEmpty()){
            int cur[]= q.poll();
            int position=cur[0];
            int time=cur[1];
            int[] newPosition= new int[]{position*3,position*2,position+n};
        
            for(int i=0;i<3;i++){
                int nx=newPosition[i];
                if(nx==y){
                    return time+1;
                }
                if(nx>y||visited[nx]){
                    continue;
                }
                

                visited[nx]=true;
                q.offer(new int[] {nx,time+1});
            }
    
        }
        return -1;
    }
}