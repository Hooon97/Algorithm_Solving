class Solution {
    static int one,zero;
    public int[] solution(int[][] arr) {
        zero = one = 0;
        
        qTree(arr, 0, 0, 0);
        
        int[] answer = {zero,one};
        return answer;
    }
    public void qTree(int[][] arr, int x, int y, int d){
        int leng = arr.length/(int)Math.pow(2,d);
        if(leng == 1){
            if(arr[x][y] == 1){
                one++;
                return;
            }
            else{
                zero++;
                return;
            }
        }
        
        boolean checkNextTree = false;
        int first = arr[x][y];
        loop : for(int i = x; i<x+leng; i++){
            for(int j = y; j<y+leng; j++){
                if(first != arr[i][j]){
                    checkNextTree = true;
                    break loop;
                }
            }
        }
        
        if(!checkNextTree){
            if(first == 1) one++;
            else zero++;
            return;
        }
        else{
            qTree(arr, x, y, d+1);
            qTree(arr, x+leng/2, y, d+1);
            qTree(arr, x, y+leng/2, d+1);
            qTree(arr, x+leng/2, y+leng/2, d+1);
        }
        
    }
}