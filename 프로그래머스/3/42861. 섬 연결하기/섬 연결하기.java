import java.util.*;
//크루스칼 알고리즘
//find,union

class Solution {
    private int[] parent;
    
    private int find(int x){
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
        
        private void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX!=rootY) parent[rootY]=rootX;
        }
        
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs,(a,b)-> Integer.compare(a[2],b[2]));
        
        parent=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        int totalCost=0;
        int count=0;
        
        for(int [] cost:costs){
            int a=cost[0];
            int b=cost[1];
            int c=cost[2];
            
            if(find(a)!=find(b)){
                union(a,b);
                totalCost+=c;
                count++;
                
                if(count==n) break;
            }
        }
        return totalCost;
    }
}