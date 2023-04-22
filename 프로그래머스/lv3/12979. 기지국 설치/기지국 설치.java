class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int loc = 1;
        int i = 0;
        
        while(loc<=n){
            if(i < stations.length && stations[i] - w <= loc){
                loc = stations[i] + w + 1;
                i++;
            }
            else{
                answer++;
                loc += 2*w+1;
            }
        }

        return answer;
    }
}