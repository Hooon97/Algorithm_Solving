

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int maxIdx = 0;
        for(int i = 0; i<numbers.length; i++){
            if(answer < numbers[i]){
                maxIdx = i;
                answer = numbers[i];
            }
        }
        
        int tmp = 0;
        for(int i = 0; i<numbers.length; i++){
            if(maxIdx == i) continue;
            tmp = Math.max(tmp, numbers[i]);
        }
        return answer*tmp;
    }
}