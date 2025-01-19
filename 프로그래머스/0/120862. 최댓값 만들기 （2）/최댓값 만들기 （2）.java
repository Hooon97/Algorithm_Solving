import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int N = numbers.length;
        Arrays.sort(numbers);
        answer = Math.max(numbers[0]*numbers[1],
                            numbers[N-2]*numbers[N-1]);
        
        return answer;
    }
}