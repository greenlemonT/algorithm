class Solution {
    public String solution(String s) {
        StringBuilder sb=new StringBuilder();
        boolean first=true;
        for(char c:s.toCharArray()){
            if(c==' '){
                sb.append(c);
                first=true;
            }
            else if(first){
                sb.append(Character.toUpperCase(c));
                first=false;
            }
            else{
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}