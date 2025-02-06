import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n=cards.length;
        boolean[] visited=new boolean[n+1];
        List<Integer> sizes=new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            int count = 0;
            int index=i;
            while(!visited[index]){
                visited[index]=true;
                index=cards[index-1];
                count++;
            }
            sizes.add(count);
        }
        
        if(sizes.size()<2){
            return 0;
        }
        Collections.sort(sizes,Collections.reverseOrder());
        return sizes.get(0)*sizes.get(1);
    }
}