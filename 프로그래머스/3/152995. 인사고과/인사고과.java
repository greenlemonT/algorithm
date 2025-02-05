import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] w=scores[0];
        int wSum=w[0]+w[1];
        
        
        for (int[] score : scores) {
            if (score[0] > w[0] && score[1] > w[1]) {
                return -1;
            }
        }   
        
        //a는 내림차순, b는 오름차순
        Arrays.sort(scores,(a,b)->
            {
                if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
                return Integer.compare(b[0],a[0]);
            });
        
        List<int[]> member=new ArrayList<>();
        int maxB=0;
        for(int[] score:scores){
           if(score[1]>=maxB){
               member.add(score);
               maxB=score[1];
           }
        }
        
        Collections.sort(member,(a,b) -> Integer.compare((b[0]+b[1]),(a[0]+a[1])));
        
        int rank=1;
        int prevSum=-1;
        int sameRankCount=0;
        
        for(int i=0;i<member.size();i++){
            int sum=member.get(i)[0]+member.get(i)[1];
            
            if(sum!=prevSum){
                rank+=sameRankCount;
                sameRankCount=1;
            }else{
                sameRankCount++;
            }
            
            if(sum==wSum){
                return rank;
            }
            
            prevSum=sum;
        }
        return -1;
    }
}