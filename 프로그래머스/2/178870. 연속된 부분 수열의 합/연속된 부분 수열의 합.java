class Solution {
    public int[] solution(int[] sequence, int k) {
        int left=0,right=0;
        int sum=sequence[0];
        int minLen=Integer.MAX_VALUE;
        int[] answer=new int[] {-1,-1};
        
        while(right<sequence.length){
            if(sum==k){
                int len=right-left+1;
                if(len<minLen){
                    minLen=len;
                    answer[0]=left;
                    answer[1]=right;
                }
            }
            //0이 있을수도있으니까 앞에 0 제외시키기 (부등호들어가야함)
            if(sum>=k){
                sum-=sequence[left];
                left++;
            }
            else{
                right++;
                if(right<sequence.length){
                    sum+=sequence[right];
                }
            }
        }
        return answer;
        
        
    }
}