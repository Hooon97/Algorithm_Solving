import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] < o2[1] ? -1 : 1;
            else
                return o1[0] < o2[0] ? -1 : 1;
        });
        
        int curTime = 0;
        int idx = 0;
        int count = 0;
        PriorityQueue<int[]> jobQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= curTime){
                jobQ.offer(jobs[idx++]);
            }
            
            if(jobQ.isEmpty()){
                curTime = jobs[idx][0];
            } else{
                int[] curJob = jobQ.poll();
                answer += curTime - curJob[0] + curJob[1];
                curTime += curJob[1];
                count++;
            }
            
        }
        
        return answer/jobs.length;
    }
}