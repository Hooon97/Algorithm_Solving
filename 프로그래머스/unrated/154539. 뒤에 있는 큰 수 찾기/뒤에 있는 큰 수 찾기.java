import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> notFoundNums = new Stack<>();
        for(int i = 0; i<numbers.length; i++){
            while(!notFoundNums.isEmpty() && 
                  numbers[notFoundNums.peek()] < numbers[i]){
                answer[notFoundNums.pop()] = numbers[i];
            }

            notFoundNums.add(i);
            
        }
        
        while(!notFoundNums.isEmpty())
            answer[notFoundNums.pop()] = -1;
        answer[numbers.length-1] = -1;
        return answer;
    }
}