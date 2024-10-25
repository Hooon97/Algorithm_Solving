import java.util.*;

class Solution {
    /*
        second를 key로 갖는 Map을 만든다.
        lines를 순회하며 key를 포함할 때 마다 1씩 증가시킨다.
        증가시킬 땐 최댓값을 기억해둔다.
    */
    Map<Long, Integer> cntMap;
    public int solution(String[] lines) {
        int answer = 1;
        int n = lines.length;
        cntMap = new HashMap<>();
        long[][] timeZone = new long[lines.length][2];
        int idx = 0;
        for(String line : lines){
            long minimum = getMinimum(line.substring(11).split(" "));
            long maximum = getMaximum(line.substring(11));
            timeZone[idx][0] = minimum;
            timeZone[idx][1] = maximum;
            idx++;
        }
        
        for(int i = 0; i<n; i++){
            long st = timeZone[i][1] + 999;
            int cnt = 1;
            for(int j = i+1; j<n; j++){
                if(st >= timeZone[j][0]) cnt++;
            }
            answer = Math.max(cnt, answer);
        }
        
        for(long[] time : timeZone) System.out.println(Arrays.toString(time));
        
        return answer;
    }
    public long getMinimum(String[] range){
        String[] times = range[0].split(":");
        long minSec = 0;
        minSec += doHourToSec(times[0]);
        minSec += doMinToSec(times[1]);
        minSec += doSecToSec(times[2]);
        minSec -= doSecToSec(range[1].substring(0, range[1].length()-1))-1;
        
        return minSec;
    }
    public long getMaximum(String end){
        String[] times = end.split(":");
        long maxSec = 0;
        maxSec += doHourToSec(times[0]);
        maxSec += doMinToSec(times[1]);
        maxSec += doSecToSec(times[2].split(" ")[0]);
        
        return maxSec;   
    }
    
    public long doHourToSec(String hour){
        return Integer.valueOf(hour)*60*60*1000;
    }
    
    public long doMinToSec(String min){
        return Integer.valueOf(min)*60*1000;
    }
    
    public long doSecToSec(String second){
        if(second.contains(".")){
            String[] time = second.split("\\.");
            return Integer.valueOf(time[0])*1000 + Integer.valueOf(time[1]);
        } else{
            return Integer.valueOf(second)*1000;
        }
    }
}