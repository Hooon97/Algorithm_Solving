class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for(int i = 1; i<triangle.length; i++){
            int preLeng = triangle[i-1].length;
            int leng = triangle[i].length;
            
            triangle[i][0] += triangle[i-1][0];
            triangle[i][leng-1] += triangle[i-1][preLeng-1];
        }
        
        for(int i = 2; i<triangle.length; i++){
            for(int j = 1; j<triangle[i].length-1; j++){
                int left = triangle[i][j] + triangle[i-1][j-1];
                int right = triangle[i][j] + triangle[i-1][j];
                triangle[i][j] = Math.max(left, right);
            }
        }
        
        int leng = triangle.length;
        for(int i = 0; i<leng; i++){
            answer = Math.max(answer, triangle[leng-1][i]);
        }
        
        return answer;
    }
}