import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character,Integer> press=new HashMap<>();
        
        for(int i=0;i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                char c=keymap[i].charAt(j);
                int count=j+1;
                press.put(c,Math.min(press.getOrDefault(c,Integer.MAX_VALUE),count));
                
            }
        }
        
        int[] answer=new int[targets.length];
        
        for(int i=0;i<targets.length;i++){
            int total=0;
            for(char c:targets[i].toCharArray()){
                if(!press.containsKey(c)){
                    total=-1;
                    break;
                }
                total+=press.get(c);
            }
            answer[i]=total;
        }
        
        return answer;
}
}