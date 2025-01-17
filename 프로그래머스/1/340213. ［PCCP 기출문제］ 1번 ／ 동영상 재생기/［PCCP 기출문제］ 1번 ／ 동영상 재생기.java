class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int video_sec = convertMinToSec(video_len);
        int pos_sec = convertMinToSec(pos);
        int st_sec = convertMinToSec(op_start);
        int ed_sec = convertMinToSec(op_end);
        
        for(String command : commands){
            if(st_sec <= pos_sec && pos_sec < ed_sec) pos_sec = ed_sec;
            
            if(command.equals("next")) pos_sec += 10;
            else if(command.equals("prev")) pos_sec -= 10;
            
            if(pos_sec < 0) pos_sec = 0;
            if(pos_sec >= video_sec) pos_sec = video_sec;
            if(st_sec <= pos_sec && pos_sec < ed_sec) pos_sec = ed_sec;
        }
        
        answer = convertSecToMin(pos_sec);
        return answer;
    }
    public String convertSecToMin(int sec){
        int min = sec/60;
        int mod = sec%60;
        String minStr = "";
        
        if(min < 10) minStr = "0"+min+":";
        else minStr = min+":";
        
        if(mod < 10) minStr += "0"+mod;
        else minStr += mod;
        
        return minStr;
    }
    
    public int convertMinToSec(String min){
        String[] info = min.split(":");
        int totalSec = Integer.valueOf(info[0])*60 + Integer.valueOf(info[1]);
        return totalSec;
    }
}