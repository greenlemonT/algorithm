import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }
        
        for(String name: callings){
            int curIndex=map.get(name);
            if (curIndex==0){
                continue;
            }
            int prevIndex=curIndex-1;
            String name2=players[prevIndex];
            
            //swap
            players[prevIndex]=name;
            players[curIndex]=name2;
            
            map.put(name,prevIndex);
            map.put(name2,curIndex);
            
        }
        return players;
    }
}