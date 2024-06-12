import java.util.*;

class Solution {
    public long solution(int[] seq) {
        long answer = 0;
        long[] posPul = new long[seq.length];
        long[] negPul = new long[seq.length];
        posPul[0] = seq[0];
        negPul[0] = (-1) * seq[0];
        answer = Math.max(posPul[0], negPul[0]);
        
        int pulse = 1;
        for(int i = 1; i<seq.length; i++){
            posPul[i] = Math.max(posPul[i-1] + seq[i]*(pulse*(-1)), seq[i]*(pulse*(-1)));
            negPul[i] = Math.max(negPul[i-1] + seq[i]*pulse, seq[i]*pulse);
            pulse *= -1;
            
            answer = Math.max(answer, Math.max(posPul[i], negPul[i]));
        }
        
        
        return answer;
    }
}