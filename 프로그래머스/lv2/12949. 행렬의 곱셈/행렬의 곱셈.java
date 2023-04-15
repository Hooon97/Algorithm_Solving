class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int row = answer.length;
        int col = answer[0].length;
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                int[] tmpArr2 = new int[arr2.length];
                
                for(int p = 0; p<arr2.length; p++){
                    tmpArr2[p] = arr2[p][j];
                }
                
                answer[i][j] = calculate(arr1[i], tmpArr2);
            }
        }
        
        return answer;
    }
    private int calculate(int[] arr1, int[] arr2){
        int result = 0;
        for(int i = 0; i<arr1.length; i++)
            result += arr1[i] * arr2[i];
        return result;
    }
}