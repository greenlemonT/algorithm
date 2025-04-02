import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n=enroll.length;
        int[] profit=new int[n];
        int[] parent=new int[n];
        Map<String,Integer> map=new HashMap<>();
        
        //이름 -> 인덱스
        for(int i=0;i<n;i++){
            map.put(enroll[i],i);
        }
        
        //추천인
        for(int i=0;i<n;i++){
            if(referral[i].equals("-")){
                parent[i]=-1;
            }else{
                parent[i]=map.get(referral[i]);
            }
        }
        
        for(int i=0;i<seller.length;i++){
            String name=seller[i];
            int money=amount[i]*100;
            int curr=map.get(name);
            
            //curr!=-1조건 !!
            while (curr != -1 && money > 0){
                int bonus=money/10;
                profit[curr]+=money-bonus;
                money=bonus;
                curr=parent[curr];
            }
        }
        return profit;
    }
}