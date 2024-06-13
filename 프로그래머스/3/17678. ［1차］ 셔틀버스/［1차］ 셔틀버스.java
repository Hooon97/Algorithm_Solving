import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        /*
            1. n행 int형 배열을 선언하여, 각 버스마다 탑승할 크루의 숫자를 기록한다.
            2. n번째 버스에 자리가 있다면, 버스가 떠나는 시간에 맞춰 도착한다.
                2-1 자리가 없다면, 가장 늦게 오는 사람보다 1분 빨리 도착한다.
        */
        
        int[] crews = convertTimeTable(timetable);
        Arrays.sort(crews);
        Queue<Integer> wait = new LinkedList<>();
        for(int crew : crews)
            wait.add(crew);
        
        int time = 9 * 60; // 9시부터 시작
        int count = 0;
        while(count < n){
            if(count != 0) time += t;
            int crewCount = 0;
            while(wait.size() != 0 && crewCount < m){
                if(wait.peek() > time) break;
                if(count == n-1 && crewCount == m-1){ //막차 + 자리없음
                    return convertTimeToString(wait.poll()-1);
                }
                wait.poll();
                crewCount++;
            }
            count++;
        }
        

        return convertTimeToString(time);
    }
    
    public String convertTimeToString(int time){
        return String.format("%02d:%02d", time/60, time%60);
    }
    
    public int[] convertTimeTable(String[] info){
        int[] newInfo = new int[info.length];
        for(int i = 0; i<info.length; i++){
            String[] hourAndMin = info[i].split(":");
            newInfo[i] = Integer.parseInt(hourAndMin[0])*60 
                + Integer.parseInt(hourAndMin[1]);
        }
        
        return newInfo;
    }
}