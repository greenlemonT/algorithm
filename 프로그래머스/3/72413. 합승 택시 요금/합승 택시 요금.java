import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        final int INF=2000001;
        int[][] dist=new int[n+1][n+1];
        
        for(int i=1;i<=n;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i]=0;
        }
        
        for(int[] fare:fares){
            int c=fare[0],d=fare[1],f=fare[2];
            dist[c][d]=f;
            dist[d][c]=f;
        }
        
        //모든 노드간 최단거리 계산
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=0;j<=n;j++){
                    if(dist[i][k]!=INF&&dist[k][j]!=INF){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        
        int minCost=INF;
        for(int k=1;k<=n;k++){
            int cost=dist[s][k]+dist[k][a]+dist[k][b];
            minCost=Math.min(minCost,cost);
        }
        
        return minCost;
    }
}