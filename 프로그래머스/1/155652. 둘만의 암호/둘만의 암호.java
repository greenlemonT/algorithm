import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> skipSet=new HashSet<>();
        for(char c: skip.toCharArray()){
            skipSet.add(c);
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(char c:s.toCharArray()){
            char a=c;
            int count=0;
            while(count<index){
                a=(char)(a+1);
                if(a>'z'){
                    a='a';
                }
                if(!skipSet.contains(a)){
                    count++;
                }
            }
            sb.append(a);
        }
        return sb.toString();
    }
}