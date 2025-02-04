import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String,Integer> termsMap=new HashMap<>();
        for(String term:terms){
            String[] parts=term.split(" ");
            termsMap.put(parts[0],Integer.parseInt(parts[1])*28);
        }
        
        int todayInt=convert(today);
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<privacies.length;i++){
            String[] parts=privacies[i].split(" ");
            int a=convert(parts[0]);
            String type=parts[1];
            
            int end=a+termsMap.get(type)-1;
            
            if(end<todayInt){
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
        
        private int convert(String date){
            String[] parts=date.split("\\.");
            int year=Integer.parseInt(parts[0]);
            int month=Integer.parseInt(parts[1]);
            int day=Integer.parseInt(parts[2]);
            
            return (year*12*28) +(month*28)+day;
        }
}