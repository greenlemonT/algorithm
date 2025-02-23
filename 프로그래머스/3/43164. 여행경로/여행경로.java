import java.util.*;

//dfs+dp
class Solution {
    
    private Map<String,PriorityQueue<String>> graph=new HashMap<>();
    private List<String> route=new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        for(String[] ticket:tickets){
            graph.putIfAbsent(ticket[0],new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("ICN");
        
        //List<String> -> String[]
        return route.toArray(new String[0]);   
    }
    
    private void dfs(String airport){
        PriorityQueue<String> destinations=graph.get(airport);
        while(destinations!=null && !destinations.isEmpty()){
            dfs(destinations.poll());
        }
        //역순으로 저장
        route.add(0,airport);
    }
    
}