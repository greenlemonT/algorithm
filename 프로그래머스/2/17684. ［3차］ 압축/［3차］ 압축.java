import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> map=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        int dicSize=27;
        for(char ch='A';ch<='Z';ch++){
            map.put(String.valueOf(ch),ch-'A'+1);
        }
        
        int index=0;
        while(index<msg.length()){ 
            StringBuilder sb=new StringBuilder();
            sb.append(msg.charAt(index));
            
            while(index<msg.length()-1&&map.containsKey(sb.toString() + msg.charAt(index + 1))){
                sb.append(msg.charAt(++index));
            }
            
            //색인번호 출력
            result.add(map.get(sb.toString()));
            
            //단어 등록
            if(index+1<msg.length()){
                map.put(sb.toString()+msg.charAt(index+1),dicSize++);
            } 
            index++;
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}