//dp
//왼쪽과 위쪽에서 오는 경로수의 합
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD=1000000007;
        int[][] array=new int[m+1][n+1];
        boolean[][] pool=new boolean[m+1][n+1];
        
        for(int[] puddle: puddles){
            pool[puddle[0]][puddle[1]]=true;
        }
        
        array[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1&&j==1){
                    continue;
                }
                //웅덩이 마주치면
                if(pool[i][j]){
                    array[i][j]=0;}
                else{
                    array[i][j]=((i>1 ? array[i-1][j]:0)+(j>1 ? array[i][j-1]:0))%MOD;
                }
            }
        }
        return array[m][n];
    }
}