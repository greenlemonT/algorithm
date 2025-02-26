import java.util.*;
//투포인터
class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemType=new HashSet<>(Arrays.asList(gems));
        int totalTypes=gemType.size();
        int[] answer=new int[2];
        Map<String,Integer> map=new HashMap<>();
        
        int left=0,right=0;
        int minLength=Integer.MAX_VALUE;
        
        while(right<gems.length){
            map.put(gems[right],map.getOrDefault(gems[right],0)+1);
            right++;
            
            while(map.size()==totalTypes){
                if(right-left<minLength){
                    minLength=right-left;
                    answer[0]=left+1;
                    answer[1]=right;
                }
                
                map.put(gems[left],map.get(gems[left])-1);
                if(map.get(gems[left])==0){
                    map.remove(gems[left]);
                }
                left++;
            }
            
        }
        return answer;
    }
}