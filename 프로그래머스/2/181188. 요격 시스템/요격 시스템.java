/*
    1. 시작 - 끝 지점으로 정렬한다. (둘 다 오름차순)
    2. 끝 지점을 기준으로 발사 미사일의 개수를 카운트한다.
    3. 기존 끝 지점이 신규 시작 지점보다 같거나 작다면, 새로운 미사일을 발사한다.
*/

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });
        
        int ed = -1;
        
        for(int i = 0; i<targets.length; i++){
            int[] range = targets[i];
            if(range[0] >= ed){
                answer++;
                ed = range[1];
            }
        }
        
        return answer;
    }
}