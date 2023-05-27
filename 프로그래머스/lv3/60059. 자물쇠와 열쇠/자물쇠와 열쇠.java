import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        if(compareKeyAndLock(key, lock)) 
            return true;
        
        for(int i = 0; i<3; i++){
            key = rotate(key);
            if(compareKeyAndLock(key, lock)) 
                return true;
        }
        
        return false;
    }
    public boolean compareKeyAndLock(int[][] key, int[][] lock){
        int n = key.length;
        int m = lock.length;
        int[][] map = new int[2*m+n-2][2*m+n-2];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                map[i+m-1][j+m-1] = key[i][j];
            }
        }
        
        for(int i= 0; i<m+n-1; i++){
            for(int j = 0; j<m+n-1; j++){
                if(isMatch(i,j, map, lock)) 
                    return true;
            }
        }
        
        return false;
    }
    public boolean isMatch(int p, int q, int[][] map, int[][] lock){
        int m = lock.length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<m; j++){
                if(map[i+p][j+q] + lock[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    
    
    public int[][] rotate(int[][] key){
        int n = key.length;
        int[][] result = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                result[j][n-1-i] = key[i][j];
            }
        }

        return result;
    }
}