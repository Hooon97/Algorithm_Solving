import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int[][] dBoard = new int[N][N];
        for(int i = 0; i<N; i++)
            dBoard[i] = board[i].clone();
        
        
        Queue<Node> q = new LinkedList<>();
        board[0][0] = -1;
        if(board[1][0] != 1){
            q.add(new Node(new int[]{1, 0}, 100, 1, 0));
            board[1][0] = 100;
        }
        answer = Math.min(bfs(board, q), answer);
        
        dBoard[0][0] = -1;
        if(board[0][1] != 1){
            q.add(new Node(new int[]{0, 1}, 100, 0, 1));
            dBoard[0][1] = 100;
        }
        answer = Math.min(bfs(dBoard, q), answer);
        
        return answer;
    }
    
    public int bfs(int[][] board, Queue<Node> q){
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.r == N-1 && cur.c == N-1){
                answer = Math.min(answer, cur.cost);
            }
            
            for(int i = 0; i<4; i++){
                int drs = dr[i] + cur.r;
                int dcs = dc[i] + cur.c;
                if(drs < 0 || dcs < 0 || drs >= N || dcs >= N) continue;
                if(board[drs][dcs] == 1) continue;
                
                int nextCost;
                if(cur.preDir[0] == dr[i] && cur.preDir[1] == dc[i]) nextCost = 100;
                else nextCost = 600;
                
                if(board[drs][dcs] >= cur.cost + nextCost){
                    board[drs][dcs] = cur.cost + nextCost;
                    q.add(new Node(new int[]{dr[i], dc[i]}, board[drs][dcs], drs, dcs));
                }
                else if(board[drs][dcs] == 0){
                    board[drs][dcs] = cur.cost + nextCost;
                    q.add(new Node(new int[]{dr[i], dc[i]}, board[drs][dcs], drs, dcs));
                }
            }
        }
        return answer;
    }
}
class Node{
    int[] preDir;
    int cost;
    int r;
    int c;
    Node(int[] preDir, int cost, int r, int c){
        this.preDir = preDir;
        this.cost = cost;
        this.r = r;
        this.c = c;
    }
}