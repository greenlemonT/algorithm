//플로이드워셜 알고리즘

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][]graph =new boolean[n+1][n+1];
        
        for(int[] result:results){
            int winner=result[0];
            int loser=result[1];
            graph[winner][loser]=true;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][k]&&graph[k][j]){
                        graph[i][j]=true;
                    }
                }
            }
        }
        
        int answer=0;
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]||graph[j][i]){
                    count++;
                }
            }
            if(count==n-1){
                answer++;
            }
        }
        return answer;
    }
}