class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        long[] sumCnt = new long[360001];
        long maxSum = 0;
        int maxIdx = 0;
        for(String log : logs){
            String[] cur = log.split("-");
            sumCnt[convertStrToTime(cur[0])]++;
            sumCnt[convertStrToTime(cur[1])]--;
        }
        
        for(int i = 1; i<=360000; i++)
            sumCnt[i] += sumCnt[i-1];
        
        int advTime = convertStrToTime(adv_time);
        int playTime = convertStrToTime(play_time);
        long curCnt = 0;
        maxSum = sumCnt[advTime] - sumCnt[0];
        for(int i = 0; i<=playTime-advTime; i++){
            curCnt += sumCnt[advTime+i] - sumCnt[i];
            if(curCnt > maxSum){
                maxSum = curCnt;
                maxIdx = i+1;
            }
        }
                
        return convertTimeToStr(maxIdx);
    }
    
    public int convertStrToTime(String str){
        String[] times = str.split(":");
        return Integer.valueOf(times[0])*3600
                + Integer.valueOf(times[1])*60
                + Integer.valueOf(times[2]);
    }
    
    public String convertTimeToStr(int time){
        return String.format("%02d:%02d:%02d", time/3600, time%3600/60, time%60);
    }
}