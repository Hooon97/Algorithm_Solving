class Solution {
    public int solution(int n) {
        int answer = 0;
        final int DIV = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        
        for(int i = 6; i<=n; i+=2){
            dp[i] = dp[i-2]*dp[2]+2;
            for(int j = i-4; j>=2; j-=2){
                dp[i] += dp[j]*2;
            }
            dp[i] %= DIV;
        }
        
        return (int)dp[n];
    }
}