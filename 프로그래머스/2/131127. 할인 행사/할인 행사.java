import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n=discount.length;
        Map<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<want.length;i++){
            map.put(want[i],number[i]);
        }
        
        Map<String,Integer> product=new HashMap<>();
        for(int i=0;i<10;i++){
            product.put(discount[i],product.getOrDefault(discount[i],0)+1);
        }
        if(product.equals(map)){
            answer++;
        }
        for(int i=10;i<n;i++){
            String remove=discount[i-10];
            product.put(remove,product.get(remove)-1);
            if(product.get(remove)==0){
                product.remove(remove);
            }
            String add=discount[i];
            product.put(add,product.getOrDefault(add,0)+1);
            if(product.equals(map)){
                answer++;
            }
        }
        return answer;
    }
}