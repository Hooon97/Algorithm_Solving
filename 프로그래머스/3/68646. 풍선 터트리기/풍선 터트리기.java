import java.util.*;

class Solution {
    public int solution(int[] a) {
        /*
            1. 살아남는게 불가능하려면, 다음과 같은 조건을 만족해야한다.
                - 양 옆의 최솟값이 자기보다 작은 경우가 하나 이하여야 한다.
                - 만약 양 옆의 최솟값이 둘 다 자신보다 작은 경우, 둘 중 하나만 터트릴 수 있기 때문이다.
                - 홀수만 존재하거나 내가 최솟값이라면, 1개는 터트리면 되고 최솟값인 경우는 다른 애들이 터짐
        */
        if(a.length < 3) return a.length;
        int answer = 2;
        int leng = a.length;
        int[] leftMin = new int[leng];
        int[] rightMin = new int[leng];
        
        leftMin[0] = a[0];
        for(int i = 1; i<leng; i++){
            leftMin[i] = Math.min(leftMin[i-1], a[i]);
        }
        
        rightMin[leng-1] = a[leng-1];
        for(int i = 1; i<leng; i++){
            rightMin[leng-i-1] = Math.min(rightMin[leng-i], a[leng-i-1]);
        }
        
        for(int i = 1; i<leng-1; i++){
            if(a[i] > leftMin[i-1] && a[i] > rightMin[i+1]) continue;
            answer++;
        }
        
        return answer;
    }
}