import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        if(board.length < 2 || board[0].length < 2) return 1;
        
        int ans = 0;
        
        for(int i = 1; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                if(board[i][j] != 0){
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int dig = board[i-1][j-1];
                    board[i][j] = Math.min(up, Math.min(left, dig))+1;
                }
                ans = ans < board[i][j] ? board[i][j] : ans;
            }
        }
        
        return ans*ans;
    }
}