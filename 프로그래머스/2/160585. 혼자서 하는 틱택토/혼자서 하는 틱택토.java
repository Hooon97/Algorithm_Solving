/*
    1. 발생할 수 있는 비정상적인 조건은 다음과 같다.
        1. O, X 둘 다 승리한 상황
        2. X의 개수가 O보다 많은 상황
        3. X와 O의 개수 차이가 1보다 큰 상황
*/

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int xCnt = 0;
        int oCnt = 0;
        
        for(int i = 0; i<3; i++){
            String line = board[i];
            for(int j = 0; j<3; j++){
                if(line.charAt(j) == 'O') oCnt++;
                else if(line.charAt(j) == 'X') xCnt++;
            }
        }

        if(oCnt < xCnt || oCnt - xCnt > 1) return 0;
        if(win(board, 'O') && oCnt == xCnt) return 0;
        if(win(board, 'X') && oCnt == xCnt + 1) return 0;
        
        else return 1;
    }
    
    public boolean win(String[] board, char ch){
         for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch
                    && board[i].charAt(1) == ch
                    && board[i].charAt(2) == ch) {
                return true;
            }
        }
        //세로 검사
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == ch
                    && board[1].charAt(i) == ch
                    && board[2].charAt(i) == ch) {
                return true;
            }
        }
        //대각선 검사
        if (board[0].charAt(0) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch
                && board[1].charAt(1) == ch
                && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }
}