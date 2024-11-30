class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        boolean[] notPainted = new boolean[n+1];
        for(int i = 0; i<section.length; i++) notPainted[section[i]] = true;
        for(int i = 1; i<=n; i++){
            if(notPainted[i]){
                answer++;
                for(int j = 0; j<m && i+j<=n; j++){
                    notPainted[j+i] = false;
                }
            }
        }
        
        return answer;
    }
}