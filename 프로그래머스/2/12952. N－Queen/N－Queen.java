/*
    (0, 1) (2, 0) (3, 2) (1, 3)
    
    1. n*n 행렬에서 4개의 좌표값을 조합으로 뽑는다.
    2. 각 좌표값이 서로에게 공격이 가능한지 여부를 검사한다.
    3. 하나라도 공격이 가능하다면 0을 반환, 모두 통과하면 1을 반환.
    4. 검사 결과를 모두 더해서 반환한다.
    
    좌표값을 뽑을 때, N * N 행렬에서 퀸은 N개가 있고, 각 행에는 1개의 퀸만 존재할 수 있다.
    따라서 int[] order에서 idx는 row, 내부 값은 행으로 취급하여 순서를 구한다.
*/

import java.util.*;

class Solution {
    public int solution(int n) {
        int[] order = new int[n];
        return NQueen(order, n, 0);
    }
    public int NQueen(int[] order, int n, int idx){
        if(idx == n){
            return 1;
        }
        
        int result = 0;
        for(int i = 0; i<n; i++){
            order[idx] = i;
            if(valid(order, idx))
                result += NQueen(order, n, idx+1);
        }
        
        return result;
    }
    
    public boolean valid(int[] order, int idx){
        
        for(int i = 0; i<idx; i++){
            if(Math.abs(order[idx] - order[i]) == Math.abs(i - idx)) return false;
            if(order[idx] == order[i]) return false;    
        }
        
        return true;
    }
}