import java.util.*;

//dfs+백트래킹
class Solution {
    private Set<Set<String>> resultSet=new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        //제재 아이디당 가능 후보 갯수 list
        List<List<String>> candidates=new ArrayList<>();
        
        for(String banned:banned_id){
            String pattern=banned.replace("*",".");
            
            List<String> matched=new ArrayList<>();
            for(String user:user_id){
                if(user.matches(pattern)&&user.length()==banned.length()){
                    matched.add(user);
                }
            }
            candidates.add(matched);
            
        }
        Set<String> selected= new HashSet<>();
        dfs(selected,0,candidates);
        return resultSet.size();
    }
    
    //순서가 달라도 동일한 case로 두기위해 Set<Set<String>>
    private void dfs(Set<String> selected,int depth, List<List<String>> candidates){
        if(depth==candidates.size()){
            //복사본 저장(selected는 변경되기때문)
            resultSet.add(new HashSet<>(selected));
            return;
        }
        for(String candidate:candidates.get(depth)){
            if(!selected.contains(candidate)){
                selected.add(candidate);
                dfs(selected,depth+1,candidates);
                selected.remove(candidate);
            }
        }
        }
    
}