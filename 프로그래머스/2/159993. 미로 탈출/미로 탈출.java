import java.util.*;

//bfs
class Solution {
    public int solution(String[] maps) {
        int n=maps.length,m=maps[0].length();
        int[] start=new int[2], lever=new int[2], end=new int[2];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c=maps[i].charAt(j);
                if(c=='S') start=new int[] {i,j};
                else if(c=='L') lever=new int[] {i,j};
                else if(c=='E') end=new int[] {i,j};
            }
        }
        
        int toLever=bfs(maps,start,lever);
        if(toLever==-1) return -1;
        int toEnd=bfs(maps,lever,end);
        if(toEnd==-1) return -1;
        
        return toLever+toEnd;
        
    }
    private int bfs(String[] maps, int[] start, int[] end){
        int n=maps.length;
        int m=maps[0].length();
        boolean[][] visited= new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        
        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        
        q.offer(new int[] {start[0],start[1],0});
        visited[start[0]][start[1]]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int x=cur[0],y=cur[1],dist=cur[2];
            
            if(x==end[0]&&y==end[1]) return dist;
            
            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                
                if(nx>=0&&ny>=0&&nx<n&&ny<m&&maps[nx].charAt(ny)!='X'&&!visited[nx][ny]){
                    visited[nx][ny]=true;
                    q.offer(new int[] {nx,ny,dist+1});
                }
            }
        }
        return -1;
    }
}