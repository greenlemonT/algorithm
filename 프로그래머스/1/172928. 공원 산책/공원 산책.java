import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int a=park.length;
        int b=park[0].length();
        int x=0,y=0;
        
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(park[i].charAt(j)=='S'){
                    x=i;
                    y=j;
                }
            }
        }
        
        Map<String,int[]> map=new HashMap<>();
        map.put("N",new int[] {-1,0});
        map.put("S", new int[]{1, 0});  
        map.put("W", new int[]{0, -1});
        map.put("E", new int[]{0, 1}); 
        
        for(String route:routes){
            String[] parts=route.split(" ");
            String dir=parts[0];
            int num=Integer.parseInt(parts[1]);
            
            int dx=map.get(dir)[0];
            int dy=map.get(dir)[1];
            
            int nx=x,ny=y;
            boolean isValid=true;
            
            for(int i=0;i<num;i++){
                nx+=dx;
                ny+=dy;
                
                if(nx<0||ny<0||nx>=a||ny>=b||park[nx].charAt(ny)=='X'){
                    isValid=false;
                    break;
                }
            
            }
            if(isValid){
                    x=nx;
                    y=ny;
                }
        }
        return new int[] {x,y};
    }
}