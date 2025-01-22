class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        answer = Math.max(Math.max(money[0], money[1]), money[2]);
        if(N < 4) return answer;
        // 터는 경우
        dp1[0] = money[0]; 
        dp1[1] = Math.max(money[0], money[1]);
        
        // 털지 않는 경우
        dp2[0] = 0; 
        dp2[1] = money[1]; 
        
        for(int i = 2; i<N; i++){
            // 털지 않는 경우
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
            answer = Math.max(answer, dp2[i]);
            // 터는 경우
            if(i == N-1) break;
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
            answer = Math.max(answer,dp1[i]);
        }
        
        return answer;
    }
}