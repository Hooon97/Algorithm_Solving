import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];        
        /*
            1. 배열을 만든다.
            2. 회전시킨다.
            3. 회전 시키면서 최솟값을 구하고 저장한다.
        */
        int[][] matrix = new int[rows][columns];
        int idx = 1;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                matrix[i][j] = idx++;
            }
        }
        
        
        for(int i = 0; i<queries.length; i++){
            int[] query = queries[i];
            
            answer[i] = getMinNum(matrix, query);
        }
        
        return answer;
    }
    public int getMinNum(int[][] matrix, int[] query){
        int sR = query[0]-1;
        int eR = query[2]-1;
        int sC = query[1]-1;
        int eC = query[3]-1;
        
        int tmpNum = matrix[sR][sC];
        int minNum = tmpNum;
        for(int i = 1; i<=eC-sC; i++){
            int tmp = matrix[sR][sC+i];
            matrix[sR][sC+i] = tmpNum; 
            tmpNum = tmp;
            minNum = Math.min(tmpNum, minNum);
        }
        
        for(int i = 1; i<=eR-sR; i++){
            int tmp = matrix[sR+i][eC];
            matrix[sR+i][eC] = tmpNum;
            tmpNum = tmp;
            minNum = Math.min(tmpNum, minNum);
        }
        
        for(int i = 1; i<=eC-sC; i++){
            int tmp = matrix[eR][eC-i];
            matrix[eR][eC-i] = tmpNum; 
            tmpNum = tmp;
            minNum = Math.min(tmpNum, minNum);
        }
        
        for(int i = 1; i<=eR-sR; i++){
            int tmp = matrix[eR-i][sC];
            matrix[eR-i][sC] = tmpNum;
            tmpNum = tmp;
            minNum = Math.min(tmpNum, minNum);
        }
        return minNum;
    }
}