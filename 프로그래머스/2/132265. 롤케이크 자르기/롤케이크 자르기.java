import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> left=new HashSet<>();
        Map<Integer,Integer> right=new HashMap<>();
        int answer=0;
        for(int a:topping){
            right.put(a,right.getOrDefault(a,0)+1);
        }
        
        for(int a:topping){
            left.add(a);
            right.put(a,right.get(a)-1);
            
            if(right.get(a)==0){
                right.remove(a);
            }
            if(left.size()==right.size()){
                answer++;
            }
        }
        return answer;
    }
}