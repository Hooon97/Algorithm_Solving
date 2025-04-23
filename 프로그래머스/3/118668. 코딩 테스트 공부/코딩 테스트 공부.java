class Solution {
    int maxAlp, maxCop;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        maxAlp = 0;
        maxCop = 0;
        
        for(int[] problem : problems){
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        if(maxAlp <= alp && maxCop <= cop) return answer;
        if(maxAlp < alp) alp = maxAlp;
        if(maxCop < cop) cop = maxCop;
        
        // row : alp, col : cop;
        int[][] cntMap = new int[maxAlp+1][maxCop+1];
        for(int i = 0; i<=maxAlp; i++){
            for(int j = 0; j<=maxCop; j++){
                cntMap[i][j] = 10000;
            }
        }
        
        cntMap[alp][cop] = 0;
        
        for(int i = 0; i<=maxAlp; i++){
            for(int j = 0; j<=maxCop; j++){
                int nextA = i+1;
                int nextC = j+1;
                if(nextA > maxAlp) nextA = maxAlp;
                if(nextC > maxCop) nextC = maxCop;
                cntMap[i][nextC] = Math.min( cntMap[i][j]+1, cntMap[i][nextC] );
                cntMap[nextA][j] = Math.min( cntMap[i][j]+1, cntMap[nextA][j] );
                
                for(int[] p : problems){
                    if(p[0] > i || p[1] > j) continue;
                    nextA = i+p[2];
                    nextC = j+p[3];
                    if(nextA > maxAlp) nextA = maxAlp;
                    if(nextC > maxCop) nextC = maxCop;
                    cntMap[nextA][nextC] = Math.min(cntMap[nextA][nextC], cntMap[i][j]+p[4]);
                }
            }
        }
        
        return cntMap[maxAlp][maxCop];
    }
}