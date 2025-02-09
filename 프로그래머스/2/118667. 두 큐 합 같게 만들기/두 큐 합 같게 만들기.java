import java.util.*;
//투포인터

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1=0,sum2=0,totalSum=0;
        int n=queue1.length;
        
        for(int i:queue1) sum1+=i;
        for(int i:queue2) sum2+=i;
        totalSum=sum1+sum2;
        
        if(totalSum%2!=0) return -1;
        long target= totalSum/2;
        
        int[] extend= new int[n*2];
        for (int i = 0; i < n; i++) {
        extend[i] = queue1[i];
        }
        for (int i = 0; i < n; i++) {
        extend[i + n] = queue2[i];
        }
        
        int left=0,right=n,count=0;
        while(left<2*n&&right<2*n){
            if(sum1==target) return count;
            if(sum1<target){
                sum1+=extend[right];
                right++;
            }
            else{
                sum1-=extend[left];
                left++;
            }
            count++;
        }
        return -1;
    }
}