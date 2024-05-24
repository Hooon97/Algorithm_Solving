import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (int[] o1, int[] o2) -> {
            if(o1[col-1] == o2[col-1]){
                return o2[0] < o1[0] ? -1 : 1;
            }
            else{
                return o1[col-1] < o2[col-1] ? -1 : 1;
            }
        });
        
        int leng = row_end - row_begin+1;
        List<Integer> sArr = new ArrayList<>();
        for(int i = row_begin-1; i<=row_end-1; i++){
            int S = 0;
            for(int d : data[i])
                S += d%(i+1);
            sArr.add(S);
        }
        
        for(int S : sArr){
            Integer.toBinaryString(answer);
            Integer.toBinaryString(S);
            
            answer = answer ^ S;
        }
        
        return answer;
    }
}