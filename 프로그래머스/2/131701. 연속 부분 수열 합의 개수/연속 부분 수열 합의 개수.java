import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n=elements.length;
        HashSet<Integer> set=new HashSet<>();
        
        int[] array=new int[n*2];
        
        for(int i=0;i<2*n;i++){
            array[i]=elements[i%n];
        }
        
        for(int length=1;length<=n;length++){
            for(int start=0;start<n;start++){
                int sum=0;
                for(int i=0;i<length;i++){
                    sum+=array[start+i];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}