import java.util.*;

/*
    1. BFS를 구현한다.
    2. 단, 현재 카운트가 k이면서 위치가 r,c인 경우만 도착한 것으로 판단한다.
    3. Answer List는 정렬 후 첫번째 값을 반환한다.
    4. Answer List가 없으면 "impossible"을 반환한다.
    
    --
    
    1. 진짜 문제 신박하게 냈다~
*/
class Solution {
    int[] dr;
    int[] dc;
    char[] dir;
    List<String> ansList;
    char[] ans;
    
    int row, col;
    int stRow, stCol;
    int edRow, edCol;
    int count;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dif = Math.abs(x-r)+Math.abs(y-c);
        if(dif > k || (Math.abs(k-dif)%2 == 1)) return "impossible";
        
        row = n;
        col = m;
        stRow = x;
        stCol = y;
        edRow = r;
        edCol = c;
        count = k;
        ansList = new ArrayList<>();
        
        dr = new int[] {1, 0, 0, -1};
        dc = new int[] {0, -1, 1, 0};
        dir = new char[] {'d', 'l', 'r', 'u'};
        ans = new char[k];
        dfs(x, y, 0);
        
        if(ansList.size() == 0)
            return "impossible";
        else return ansList.get(0);
    }
    public void dfs(int r, int c, int cnt){
        if(ansList.size() > 0) return;
        if(cnt == count && r == edRow && c == edCol){
            ansList.add(new String(ans));
            return;
        } else if(cnt == count) return;
        int dif = Math.abs(r-edRow)+Math.abs(c-edCol);
        if(dif > count-cnt) return;
        
        
        for(int i = 0; i<4; i++){
            int drs = dr[i]+r;
            int dcs = dc[i]+c;
            if(drs <= 0 || drs > row || dcs <= 0 || dcs > col) continue;
            ans[cnt] = dir[i];
            dfs(drs, dcs, cnt+1);
        }
        
        return;
    }
}