//dp써야함
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer=0;
        Arrays.sort(money);
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int coin:money){
            for(int i=coin;i<=n;i++){
                dp[i]=dp[i]+dp[i-coin];
            }
        }
        return dp[n];
        
    }
}