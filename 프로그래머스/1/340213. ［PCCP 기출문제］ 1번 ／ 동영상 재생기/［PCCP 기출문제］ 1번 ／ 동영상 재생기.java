//구현
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength=convert(video_len);
        int position=convert(pos);
        int start=convert(op_start);
        int end=convert(op_end);
        
        if(position>=start&&position<=end){
            position=end;
        }
        
        for(String command:commands){
            if(command.equals("prev")){
                position=Math.max(0,position-10);
            }
            else{
                position=Math.min(videoLength,position+10);
            }
            
            if(position>=start&&position<=end){
                position=end;
            }
        }
        return timeToString(position);
        
    }
    
    private int convert(String time){
        String[] parts=time.split(":");
        int minutes=Integer.parseInt(parts[0]);
        int seconds=Integer.parseInt(parts[1]);
        return minutes*60+seconds;
    }
    
    private String timeToString(int time){
        int minutes=time/60;
        int seconds=time%60;
        return String.format("%02d:%02d",minutes,seconds);
    }
}