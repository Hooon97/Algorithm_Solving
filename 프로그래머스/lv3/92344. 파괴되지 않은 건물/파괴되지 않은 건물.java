import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] attack = new int[board.length+1][board[0].length+1];
        
        // type, r1, c1, r2, c2, degree
        for(int i = 0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int deg = skill[i][5];
            switch(type){
                case 1 :
                    attack[r1][c1] += deg*(-1);
                    attack[r2+1][c1] += deg;
                    attack[r1][c2+1] += deg;
                    attack[r2+1][c2+1] += deg*(-1);
                    break;
                case 2 : 
                    attack[r1][c1] += deg;
                    attack[r2+1][c1] += deg*(-1);
                    attack[r1][c2+1] += deg*(-1);
                    attack[r2+1][c2+1] += deg;
                    break;
            }
        }
        
        for(int i = 0; i<board.length; i++){
            for(int j = 1; j<board[0].length; j++){
                attack[i][j] += attack[i][j-1];
            }
        }
        
        for(int j = 0; j<board[0].length; j++){
            for(int i = 1; i<board.length; i++){
                attack[i][j] += attack[i-1][j];
            }
        }
        
        int answer = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] + attack[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}