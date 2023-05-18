import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> result = new Stack<>();
        int answer = 0;
        
        for(int m : moves){
            for(int i = 0; i<board.length; i++){
                if(board[i][m-1] != 0){
                    if(!result.isEmpty() && result.peek() == board[i][m-1]){
                        answer += 2;
                        result.pop();
                        board[i][m-1] = 0;
                    }
                    else{
                        result.push(board[i][m-1]);
                        board[i][m-1] = 0;
                    }
                    break;
                }
            }
        }
        
        while(!result.isEmpty()){
            int cur = result.pop();
            if(!result.isEmpty() && result.peek() == cur){
                answer++;
                result.pop();
            }
        }
        
        return answer;
    }
}