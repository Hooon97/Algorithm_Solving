class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        String color = board[h][w];
        for(int i = 0; i<4; i++){
            int drs = h+dr[i];
            int dcs = w+dc[i];
            if(drs < 0 || drs >= board.length || dcs < 0 || dcs >= board[0].length) continue;
            if(color.equals(board[drs][dcs]))
                answer++;
        }
        return answer;
    }
}