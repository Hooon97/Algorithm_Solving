import java.util.*;

class Solution {
    /*
        1. 1~n 중 5개를 조합으로 뽑는다.
        2. 완성된 조합의 경우가 조건을 만족하는지 검사한다.
        3. 만족할때만 answer을 증가시킨다.
        
        + 조합의 depth에 따라 조건식을 검사하여 백트래킹도 가능하다.
    */
    int[][] q;
    int[] ans;
    int answer;
    public int solution(int n, int[][] q_t, int[] ans_t) {
        answer = 0;
        q = q_t;
        ans = ans_t;
        
        int[] secret = new int[5];
        comb(n, secret, 1, 0);
        
        return answer;
    }
    
    public boolean validate(Set<Integer> set, int[] q, int ans){
        int cnt = 0;
        for(int i = 0; i<q.length; i++){
            if(set.contains(q[i])) cnt++;
        }
        
        return cnt == ans;
    }
    
    public void comb(int n, int[] arr, int start, int depth){
        if(depth == 5){
            Set<Integer> arrSet = new HashSet<>();
            for(int i = 0; i<arr.length; i++) arrSet.add(arr[i]);
            
            boolean flag = true;
            for(int i = 0; i<ans.length; i++){
                if(!validate(arrSet, q[i], ans[i])){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
            
            return;
        }
        
        for(int i = start; i<=n; i++){
            arr[depth] = i;
            comb(n, arr, i+1, depth+1);
        }
    }
}