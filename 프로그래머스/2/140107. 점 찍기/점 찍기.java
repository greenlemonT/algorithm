class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dd=(long)d*d;
        
        for(int i=0;i<=d;i+=k){
            long yy=dd-(long)i*i;
            long maxY=(long)Math.sqrt(yy);
            answer+=maxY/k+1;
        }
        return answer;
    }
}