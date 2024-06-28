class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        /*
            1. 나한테 진 사람들한테 진 사람보다는 강함
            2. 나를 이긴 사람들한테 이긴 사람보다는 약함
            3. 나를 이긴 사람, 진 사람의 카운트가 n-1개일 때 순위를 알 수 있음
        */
        int[][] record = new int[n+1][n+1];
        
        for(int[] result : results){
            int winner = result[0];
            int looser = result[1];
            record[winner][looser] = 1;
            record[looser][winner] = -1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k<=n; k++){
                    // i가 j를 이기고 j가 k를 이겼다면
                    if(record[i][j] == 1 && record[j][k] == 1){
                        record[i][k] = 1;
                        record[k][i] = -1;
                    } else if(record[i][j] == -1 && record[k][i] == -1){
                        //i가 j보다 약하고 k가 i보다 약하다면
                        record[j][k] = 1;
                        record[k][j] = -1;
                    }
                        
                }
            }
        }
        
        for(int i = 1; i<=n; i++){
            int recordCount = 0;
            for(int j = 1; j<=n; j++){
                if(record[i][j] == 0) recordCount++;
            }
            if(recordCount == 1) answer++;
        }
        
        return answer;
    }
}