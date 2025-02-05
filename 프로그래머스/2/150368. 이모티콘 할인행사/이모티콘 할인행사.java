//완전탐색+dfs
class Solution {
    private static final int[] DISCOUNTS={10,20,30,40};
    private int maxSubscribers=0; //서비스 가입자 수
    private int maxRevenue=0; //매출액
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discounts=new int[emoticons.length];
        dfs(0,users,emoticons,discounts);
        return new int[] {maxSubscribers,maxRevenue};
    } 
    
    private void dfs(int depth,int[][] users, int[] emoticons,int[] discounts){
        if(depth==emoticons.length){
            evaluate(users,emoticons,discounts);
            return;
        }
        
        for(int discount:DISCOUNTS){
            discounts[depth]=discount;
            dfs(depth+1,users,emoticons,discounts);
        }
    }
    
    private void evaluate(int[][] users,int[] emoticons,int[] discounts){
        int subscribers=0;
        int revenue=0;
        for(int[] user: users){
            int require=user[0];
            int limit=user[1];
            int spend=0;
            for(int i=0;i<emoticons.length;i++){
                if(discounts[i]>=require){
                    spend+=emoticons[i]*(100-discounts[i])/100;
                }
            }
            
            if(spend>=limit){
                subscribers++;
            }else{
                revenue+=spend;
            }
            if(subscribers>maxSubscribers||((subscribers==maxSubscribers)&&(revenue>maxRevenue))){
                maxSubscribers=subscribers;
                maxRevenue=revenue;
            }
        }
    }
}