class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2; 
            sb.append(String.valueOf(i).repeat(count));
        }
        
        return sb.toString() + "0" + sb.reverse().toString();
    }
}
