import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] count = new int[n+1];
        count[0] = 1;
        
        for(int m : money){
            for(int i = m; i<=n; i++){
                count[i] += count[i-m]%1000000007;
            }
        }
        
        return count[n];
        
    }
}