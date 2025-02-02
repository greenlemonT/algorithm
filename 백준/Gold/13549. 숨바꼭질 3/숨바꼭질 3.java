import java.util.*;

public class Main{
    public static int bfs(int N,int K){
        if(N==K){
            return 0;
        }
        
        Deque<int[]> dq=new ArrayDeque<>();
        boolean[] visited=new boolean[100001];
        dq.offer(new int[] {N,0}); //현재위치, 현재시간
        while(!dq.isEmpty()){
            int cur[]=dq.poll();
            int position=cur[0],time=cur[1];
            int[] newPosition={2*position,position-1,position+1};
            for(int i=0;i<3;i++){
                int nx=newPosition[i];
                if(nx<0||nx>100000){
                    continue;
                }
                if(visited[nx]){
                    continue;
                }
                if(nx==K){
                    if(i==0){
                        return time;
                    }else{
                        return time+1;
                    }
                }
                visited[nx]=true;
                
                if(i==0){
                        dq.offerFirst(new int[] {nx,time});
                    }
                else{
                        dq.offerLast(new int[] {nx,time+1});
                }
            }
  
        }return -1;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        System.out.println(bfs(N,K));
    }
}