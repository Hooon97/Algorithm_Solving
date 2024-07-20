import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int a : arr){
            if(a % divisor == 0) list.add(a);
        }
        
        int[] answer;
        if(list.size() != 0)
            answer = new int[list.size()];
        else{
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        for(int i = 0; i<answer.length; i++)
            answer[i] = list.get(i);
        Arrays.sort(answer); 
        return answer;
    }
}