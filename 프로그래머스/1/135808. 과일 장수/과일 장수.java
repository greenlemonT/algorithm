import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] sorted=Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted,(a,b) -> Integer.compare(b,a));
        
        for(int i=0;i+m<=sorted.length;i+=m){
            int minScore=sorted[i+m-1];
            answer+=minScore*m;
        }
        
        return answer;
    }
}