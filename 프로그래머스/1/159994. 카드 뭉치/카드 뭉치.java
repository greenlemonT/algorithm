class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int a=0,b=0;
        for(String word:goal){
            if(a<cards1.length&&cards1[a].equals(word)){
                a++;}
            else if(b<cards2.length&&cards2[b].equals(word)){
                b++;}
            else{
                return "No";
            }
        }
        return "Yes";
    }
}