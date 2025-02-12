import java.util.*;

//다중집합의 교집합, 합집합
//교집합= 전체원소 set <-> map1, set<->map2 개수중 min
//합집합=set <-> map1, set<->map2 개수중 max

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1=make(str1);
        List<String> list2=make(str2);
        
        Map<String,Integer> map1=getfrequency(list1);
        Map<String,Integer> map2=getfrequency(list2);
        
        
        Set<String> all=new HashSet<>();
        all.addAll(map1.keySet());
        all.addAll(map2.keySet());
        
        int c=0,d=0;
        for(String number:all){
            int count1=map1.getOrDefault(number,0);
            int count2=map2.getOrDefault(number,0);
            
            c+=Math.min(count1,count2);
            d+=Math.max(count1,count2);
        }
        int jack=(d==0) ? 65536: (int)Math.floor(((double)c/d)*65536);
        return jack;
    }
    
    //다중집합 만들기함수 -> List<String>으로 반환
    private List<String> make(String str){
        List<String> a=new ArrayList<>();
        str=str.toUpperCase();
        
        int n=str.length()-1;
        for(int i=0;i<n;i++){
            char first=str.charAt(i);
            char second=str.charAt(i+1);
            if(Character.isLetter(first)&&Character.isLetter(second)){
                a.add(""+first+second);
            }
        }
        return a;
    }
    
    
    //빈도수계산 -> Map<String,Integer>로 반환
    private Map<String,Integer> getfrequency(List<String> str){
        Map<String,Integer> map=new HashMap<>();
        for(String a: str){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        return map;
    }
    
}