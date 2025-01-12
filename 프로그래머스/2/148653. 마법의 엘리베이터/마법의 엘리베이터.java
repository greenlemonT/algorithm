class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0){
            int a= storey%10;
            int b=storey/10;
            if(a>5|| a==5 && b %10 >=5){
                answer+=(10-a);
                storey=(storey/10)+1;
            }else{
                answer+=a;
                storey/=10;
            }
        }
        return answer;
    }
}