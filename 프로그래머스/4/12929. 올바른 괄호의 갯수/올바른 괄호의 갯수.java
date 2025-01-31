class Solution {
    public int solution(int n) {

        int[] ans = new int[15];
        ans[0] = ans[1] = 1;
        
        for(int i = 2; i<=14; i++){
            for(int j = 1; j<=i; j++){
                ans[i] += (ans[i-j] * ans[j-1]); 
            }
        }
        
        return ans[n];
    }
}