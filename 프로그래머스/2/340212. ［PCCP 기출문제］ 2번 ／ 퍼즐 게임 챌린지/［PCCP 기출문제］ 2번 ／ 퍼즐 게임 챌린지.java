class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 1;
        long sumTime = 0;
        long st = 1;
        long ed = limit;
        
        while(st<=ed){
            long mid = (st+ed)/2;
            long time = getTotalTime(diffs,times, mid);
            
            // 걸리는 시간이 limit보다 작으면, 레벨을 낮춘다.
            // 걸리는 시간이 limit보다 많으면, 레벨을 높인다.
            if(time > limit){
                st = mid+1;
            } else{
                ed = mid-1;
            }
        }
        return (int)st;
    }
    
    public long getTotalTime(int[] diffs, int[] times, long level){
        long sumTime = 0;
        for(int i = 0; i<diffs.length; i++){
            sumTime += times[i];
            if(level < diffs[i]) 
                sumTime += (diffs[i]-level)*(times[i-1]+times[i]);
        }
        return sumTime;
    }
}