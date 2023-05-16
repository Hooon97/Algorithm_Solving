class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        boolean[] visit = new boolean[1001];
        for(int i = 1; i*i<1001; i++){
            visit[i*i] = true;
        }
        
        for(int i = left; i<right+1; i++){
            if(visit[i]) answer -= i;
            else answer += i;
        }
        
        return answer;
    }
}