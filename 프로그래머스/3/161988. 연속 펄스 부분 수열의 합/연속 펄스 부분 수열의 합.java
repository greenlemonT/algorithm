class Solution {
    public long solution(int[] sequence) {
        int n=sequence.length;
        long max1=0,max2=0;
        long sum1=0,sum2=0;
        long[] pulse1=new long[n];
        long[] pulse2=new long[n];
        
        for(int i=0;i<n;i++){
            if(i%2==0){
                pulse1[i]=sequence[i];
                pulse2[i]=-sequence[i];
            }
            else{
                pulse1[i]=-sequence[i];
                pulse2[i]=sequence[i];
            }
        }
        
        for(int i=0;i<n;i++){
            sum1 = Math.max(pulse1[i], sum1 + pulse1[i]); 
            sum2 = Math.max(pulse2[i], sum2 + pulse2[i]); 
            max1 = Math.max(max1, sum1);
            max2 = Math.max(max2, sum2);
        }
        return Math.max(max1, max2);
    }
}