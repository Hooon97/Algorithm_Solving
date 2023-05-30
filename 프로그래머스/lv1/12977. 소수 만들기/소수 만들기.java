class Solution {
    static int answer;
    static boolean[] primes;
    public int solution(int[] nums) {
        answer = 0;
        primes = new boolean[3001];
        getPrimes();
        
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                for(int p = j+1; p<nums.length; p++){
                    if(!primes[nums[i]+nums[j]+nums[p]]) answer++;
                }
            }
        }
        
        return answer;
    }
    void getPrimes(){
        for(int i = 2; i<primes.length; i++){
            for(int j = 2; j*i<=primes.length; j++){
                primes[i*j] = true;
            }
        }
    }
}