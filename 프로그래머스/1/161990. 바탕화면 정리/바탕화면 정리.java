class Solution {
    public int[] solution(String[] wallpaper) {
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
        int c=Integer.MIN_VALUE,d=Integer.MIN_VALUE;
        
        int rows=wallpaper.length;
        int cols=wallpaper[0].length();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(wallpaper[i].charAt(j)=='#'){
                    a=Math.min(a,i);
                    b=Math.min(b,j);
                    c=Math.max(c,i);
                    d=Math.max(d,j);
                }
            }
        }
        return new int[] {a,b,c+1,d+1};
    }
}