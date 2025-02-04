import java.util.*;

//bfs, 그래프
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] road: roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] dist=new int[n+1];
        Arrays.fill(dist,-1);
        
        //destination을 시작점으로 노드간 거리 저장
        bfs(destination,graph,dist);
        
        int[] answer= new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
    
    private void bfs(int start,List<List<Integer>> graph,int[] dist){
        Queue<Integer> q= new LinkedList<>();
        q.offer(start);
        dist[start]=0;
        
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(int next:graph.get(cur)){
                if(dist[next]==-1){
                    dist[next]=dist[cur]+1;
                    q.offer(next);
                }
            }
        }
    }
}