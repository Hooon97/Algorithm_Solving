class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int newBottles = (n/a)*b;
        while(newBottles > 0){
            newBottles = (n/a)*b;
            answer += newBottles;
            n = n%a + newBottles;
        }
        
        return answer;
    }
}