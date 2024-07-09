class Solution {
    public int[] solution(long begin, long last) {
        int start = (int) begin;
        int end =  (int) last;
        final int MAXIMUM = 10000000;
        int[] answer = new int[end-start+1];
        for(int num = start; num <= end; num++){
            answer[num-start] = getBlockNum(num, MAXIMUM);
        }
        
        return answer;
    }
    
    public int getBlockNum(int num, int MAX){
        if(num == 1) return 0;
        
        int max = 1;
        
        for(int i = 2; i<= Math.sqrt(num); i++){
            if(num % i == 0){
                if(num / i <= MAX) return num / i;
                if(i<=MAX) max = Math.max(max, i);
            }
        }
        
        
        return max;
    }
}