class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        
        for(int i=0; i<schedules.length; i++){
            for(int j = 0; j<7; j++){
                /*
                    s ; 1 => 1, 2, 3, 4, 5, 6, 7 : 6,7
                    s ; 2 => 2, 3, 4, 5, 6, 7, 8 : 6,7
                    s ; 3 => 3, 4, 5, 6, 7, 8, 9 : 6,7
                    ...
                    s ; 6 => 6, 7, 8, 9, 10, 11, 12 : 6,7
                    s ; 7 => 7, 8, 9, 10, 11, 12, 13 : 7, 13
                */
                int date = j+startday;
                if(date == 6 || date == 7 || date == 13) continue;
                int limit = getLimit(schedules[i]);
                if(timelogs[i][j] > limit){
                    answer--;
                    break;
                }
            }
        }
        
        
        return answer;
    }
    
    public int getLimit(int time){
        int hour = time/100;
        int min = time%100;
        int limitTime = hour*60 + min + 10;
        int limitHour = limitTime/60;
        int limitMin = limitTime%60;
        
        return limitHour*100 + limitMin;
    }
}