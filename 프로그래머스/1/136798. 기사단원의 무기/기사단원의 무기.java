class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1;i<=number;i++){
            int num=count(i);
            if(num>limit){
                answer+=power;
            }else{
                answer+=num;
            }
        }
        return answer;
    }
    
    private int count(int num){
        int count=0;
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                count++;
                if(num/i!=i){
                    count++;
                }
            }
        }
        return count;
    }
}