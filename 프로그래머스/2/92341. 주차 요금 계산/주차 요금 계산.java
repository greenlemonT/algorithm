import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> parkingTime=new HashMap<>();
        Map<String,Integer> inTime=new HashMap<>();
        int limit=convertminute("23:59");
        
        for(String record:records){
            String[] temp=record.split(" ");
            int time=convertminute(temp[0]);
            String carNumber=temp[1];
            if(temp[2].equals("IN")){
                inTime.put(carNumber,time);
            }
            else{
                int totalTime=time-inTime.get(carNumber);
                parkingTime.put(carNumber,parkingTime.getOrDefault(carNumber,0)+totalTime);
                inTime.remove(carNumber);
            }
        }
        //출차되지 않은차
        for(String carNumber:inTime.keySet()){
            int totalTime2=limit-inTime.get(carNumber);
            parkingTime.put(carNumber,parkingTime.getOrDefault(carNumber,0)+totalTime2);
        }
        
        //차량번호가 작은순부터 정렬
        List<String> sorted=new ArrayList<>(parkingTime.keySet());
        Collections.sort(sorted);
        int[] answer=new int[sorted.size()];
        int index=0;
        for(String name:sorted){
            int cost=calculate(fees,parkingTime.get(name));
            answer[index++]=cost;
        }
        
        return answer;
        
    }
     private int convertminute(String time){
         String[] temp=time.split(":");
         return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
     }
    
    private int calculate(int[] fees,int time){
        int a=fees[0], b=fees[1],c=fees[2],d=fees[3];
        //기본시간이하일땐 기본요금
        if (time <= a) return b;
        return b+(int)Math.ceil((double)(time-a)/c)*d;
    }
}