import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int maxNum = Math.max(arrayA[0], arrayB[0]);
        int leng = arrayA.length;

        
        for(int i = 2; i<=maxNum; i++){
            int a = 0;
            int b = 0;
            boolean flagA = arrayA[leng-1]%i == 0 ? true : false;
            boolean flagB = arrayB[leng-1]%i == 0 ? true : false;
            boolean flagC = true;
            if(flagA == flagB) continue;
            
            while(a < arrayA.length){
                if(flagA != (arrayA[a]%i == 0) || flagB != (arrayB[a]%i == 0)){
                    flagC = false;
                    break;
                }
                a++;
            }
            
            if(flagC)
                answer = i;
        }
        
        return answer;
    }
}