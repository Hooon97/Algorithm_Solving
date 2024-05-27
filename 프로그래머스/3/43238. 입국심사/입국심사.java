import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        /*
            1. 탐색 대상 : 심사에 걸리는 총 시간
            2. 주어진 값 : 사람 수, 심사별 시간
            ---
            1. left, right를 시간으로 두자.
            left = 0, right = n*times[최대 시간]
            
            하지만 시간이 주어졌을 때, 주어진 시간 안에 모두 가능한지 어떻게 알 수 있지?
            총 시간 / 심사 시간의 몫의 합이 최대 인원수보다 같거나 많으면 가능하다.
        */
        
        Arrays.sort(times);
        long left = 0;
        long right = (long)n * times[times.length-1];
        
        while(left <= right){
            long mid = (left+right)/2;
            long restNum = restNumber(times, n, mid);
            if(restNum > 0){
                left = mid+1;
            }else{ //음수이거나 같으면 시간이 남는 것
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
    public long restNumber(int[] times, int n, long limit){
        long sum = 0;
        for(int time : times){
            sum += limit/time;
        }

        return n-sum;
    }
}