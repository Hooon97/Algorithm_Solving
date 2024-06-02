class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int len = s.length();
        char[] sArr = s.toCharArray();
        
        int[][] dp = new int[len][len];
        for(int i = 0; i<len; i++){
            dp[i][i] = 1;
        }
        
        for(int i = 0; i<len-1; i++){
            if(sArr[i] == sArr[i+1]){
                dp[i][i+1] = 1;
                answer = 2;
            }
        }
        
        for(int p = 3; p<= len; p++){
            for(int i = 0; i<= len-p; i++){
                int j = i+p-1;
                if(sArr[i] == sArr[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    answer = Math.max(answer, p);
                }
            }
        }
        

        return answer;
    }
}