import java.util.*;

class Solution {
    /*
        1. m x n 배열을 0,0부터 순회하며, m-1, n-1까지 순회한다.
        2. 순회를 마친 지점은 -1로 변환한다.
        3. 영역의 개수를 저장하는 cnt 변수와, 최대 영역 크기를 저장하는 max 변수를 선언한다.
        4. bfs한다.
        단, m은 열, n은 행이다.
    */
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(picture[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, BFS(i, j, picture));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int BFS(int r, int c, int[][] map){
        int area = 1;
        int m = map.length;
        int n = map[0].length;
        int number = map[r][c];
        
        int[] dr = new int[]{0, 0, -1, 1};   
        int[] dc = new int[]{1, -1, 0, 0};
        Node node = new Node(r, c);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map[r][c] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0; i<4; i++){
                int drs = dr[i] + cur.r;
                int dcs = dc[i] + cur.c;
                if(drs < 0 || drs >= m || dcs < 0 || dcs >= n) continue;
                if(map[drs][dcs] == 0 || map[drs][dcs] != number) continue;
                map[drs][dcs] = 0;
                area++;
                q.add(new Node(drs, dcs));
            }
        }
        
        return area;
    }
    
    class Node{
        int r;
        int c;
        
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}