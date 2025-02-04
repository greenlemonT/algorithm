class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end=0;
        
        for(int cur:section){
            if(cur>end){
                answer++;
                end=cur+m-1;
            }
        }
        return answer;
    }
}