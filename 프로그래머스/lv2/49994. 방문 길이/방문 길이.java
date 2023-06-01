class Solution {
    static boolean[][][] visit;
    static int r, c;
    public int solution(String dirs) {
        int answer = 0;
        visit = new boolean[11][11][4]; 
        r = 5;
        c = 5;
        for(char c : dirs.toCharArray()){
            answer += move(c);
        }
        
        return answer;
    }
    int move(char dir){
        if(dir == 'U'){
            if(c-1 < 0) return 0;
            c--;
            if(!visit[r][c+1][0]){
                visit[r][c+1][0] = true;
                visit[r][c][1] = true;
                return 1;
            }
        }
        else if(dir == 'D'){
            if(c+1 > 10) return 0;
            c++;
            if(!visit[r][c-1][1]){
                visit[r][c-1][1] = true;
                visit[r][c][0] = true;
                return 1;
            }
        }
        else if(dir == 'R'){
            if(r+1 > 10) return 0;
            r++;
            if(!visit[r-1][c][3]){
                visit[r-1][c][3] = true;
                visit[r][c][2] = true;
                return 1;
            }
        }
        else if(dir == 'L'){
            if(r-1 < 0) return 0;
            r--;
            if(!visit[r+1][c][2]){
                visit[r+1][c][2] = true;
                visit[r][c][3] = true;
                return 1;
            }
        }
        return 0;
    }
}