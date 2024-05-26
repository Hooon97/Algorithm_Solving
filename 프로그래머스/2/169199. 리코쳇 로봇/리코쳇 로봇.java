import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        String[][] nBoard = new String[board.length][board[0].length()];
        for(int i = 0; i<board.length; i++)
            nBoard[i] = board[i].split("");
        
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        int[] stP = new int[2];
        int[] edP = new int[2];
        
        for(int i = 0; i<nBoard.length; i++){
            for(int j = 0; j<nBoard[0].length; j++){
                if(nBoard[i][j].equals("R")){
                    stP[0] = i;
                    stP[1] = j;
                }
                if(nBoard[i][j].equals("G")){
                    edP[0] = i;
                    edP[1] = j;
                }
            }
        }
        
        q.offer(new Point(stP[0], stP[1], 0));
        
        // 각 point별 상하좌우 visit memory 배열
        boolean[][][] visit = new boolean[nBoard.length][nBoard[0].length][4];

        while(!q.isEmpty()){
            Point curPnt = q.poll();
            int i = curPnt.r;
            int j = curPnt.c;
            if(i == edP[0] && j == edP[1])
                return curPnt.cnt;
            if(!visit[i][j][0]){
                visit[i][j][0] = true;
                Point newPnt = moveRobot(nBoard, "U", curPnt);
                q.offer(newPnt);
            }
            if(!visit[i][j][1]){
                visit[i][j][1] = true;
                Point newPnt = moveRobot(nBoard, "D", curPnt);
                q.offer(newPnt);
            }
            if(!visit[i][j][2]){
                visit[i][j][2] = true;
                Point newPnt = moveRobot(nBoard, "L", curPnt);
                q.offer(newPnt);
            }
            if(!visit[i][j][3]){
                visit[i][j][3] = true;
                Point newPnt = moveRobot(nBoard, "R", curPnt);
                q.offer(newPnt);
            }
                
                
        }
        
        return -1;
    }
    
    public Point moveRobot(String[][] board, String dir, Point pnt){
        int r = pnt.r;
        int c = pnt.c;
        int cnt = pnt.cnt;
        switch(dir){
            case "U" :
                while(r >= 0){
                    if(r == 0 || board[r-1][c].equals("D")){
                        return new Point(r, c, cnt+1);
                    }
                    r--;
                }
                break;
            case "D" :
                while(r < board.length){
                    if(r == board.length-1 || board[r+1][c].equals("D")){
                        return new Point(r, c, cnt+1);
                    }
                    r++;
                }
                break;
            case "L" :
                while(c >= 0){
                    if(c == 0 || board[r][c-1].equals("D")){
                        return new Point(r, c, cnt+1);
                    }
                    c--;
                }
                break;
            case "R" :
                while(c < board[0].length){
                    if(c == board[0].length-1 || board[r][c+1].equals("D")){
                        return new Point(r, c, cnt+1);
                    }
                    c++;
                }
            break;
        }
        
        return new Point(r, c, cnt+1);
    }
    
    class Point{
        int r;
        int c;
        int cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}