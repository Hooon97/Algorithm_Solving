class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        for(int i = 0; i<answer.length; i++){
            long row = (left+i) / n;
            long col = (left+i) % n;
            if(row == 0 && col == 0) answer[i] = 1;
            else{
                answer[i] = (int)Math.max(row+1, col+1);
            }
        }
        
        return answer;
    }
}