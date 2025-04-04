import java.util.*;

class Solution {
    int[][][] map;
    int N;
    int cnt;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        cnt = 0;
        N = n;
        map = new int[n+3][n+3][2]; // 0: 기둥, 1: 보
        
        for(int[] frame : build_frame){
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            int div = frame[2];
            
            if(frame[3] == 1) { // 설치
                if(Buildable(x, y, div)){
                    cnt++;
                    map[x][y][div] = 1;   
                }
            } else { // 삭제
                // 삭제를 시도한 후 전체 구조물을 점검
                map[x][y][div] = 0;
                if(!Deletable()){
                    map[x][y][div] = 1; // 삭제가 불가능하면 원복
                } else {
                    cnt--;
                }
            }
        }
        
        answer = collectFrames();
        return answer;
    }
    
    public int[][] collectFrames(){
        int[][] answer = new int[cnt][3];
        int idx = 0;
        for(int i = 0; i < N+2; i++){
            for(int j = 0; j < N+2; j++){
                for(int p = 0; p < 2; p++){
                    if(map[i][j][p] == 1){
                        answer[idx][0] = i - 1;
                        answer[idx][1] = j - 1;
                        answer[idx][2] = p;
                        idx++;
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean Buildable(int x, int y, int div){
        if(div == 0 && condPil(x, y)){
            return true;
        } else if(div == 1 && condBar(x, y)){
            return true;
        }
        return false;
    }
    
    // 전체 구조물을 대상으로 삭제 후 유효성 검증
    public boolean Deletable(){
        for(int i = 1; i <= N+1; i++){
            for(int j = 1; j <= N+1; j++){
                if(map[i][j][0] == 1 && !condPil(i, j)){
                    return false;
                }
                if(map[i][j][1] == 1 && !condBar(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    // 기둥 설치 조건 확인
    public boolean condPil(int x, int y){
        // 바닥 위거나 보의 한쪽 끝 또는 다른 기둥 위에 있어야 함
        if(y == 1){
            return true;
        } else if(map[x][y][1] == 1 || map[x-1][y][1] == 1){
            return true;
        } else if(map[x][y-1][0] == 1){
            return true;
        }
        return false;
    }
    
    // 보 설치 조건 확인
    public boolean condBar(int x, int y){
        // 한쪽 끝이 기둥 위에 있거나 양쪽이 다른 보와 동시에 연결되어 있어야 함
        if(map[x][y-1][0] == 1 || map[x+1][y-1][0] == 1){
            return true;
        } else if(map[x-1][y][1] == 1 && map[x+1][y][1] == 1){
            return true;
        }
        return false;
    }
}
