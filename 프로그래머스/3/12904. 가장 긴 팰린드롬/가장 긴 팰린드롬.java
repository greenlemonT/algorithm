//2500개 이니까 N^2 가능
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        int n=s.length();
        for(int i=0;i<n;i++){
            answer=Math.max(answer,check(s,i,i));
            answer=Math.max(answer,check(s,i,i+1));
        }
        return answer;
    }
    
    public int check(String s,int left,int right){
        int n=s.length();
        while(left>=0&&right<n&&(s.charAt(left)==s.charAt(right))){
            left--;
            right++;
        }
        return right-left-1;
    }
}