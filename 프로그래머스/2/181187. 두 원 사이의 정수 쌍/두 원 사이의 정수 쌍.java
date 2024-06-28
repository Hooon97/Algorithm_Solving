class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        /*
            1. 각 원의 사분면 내의 점의 개수를 구한 뒤 빼준다.
            2. 반지름의 길이 차이 + 1에 네 배를 곱하여 더해준다.
        */
        
        long region = getRegionDiff(Math.max(r1, r2), Math.min(r1, r2))*4;
        
        return region + (Math.abs(r1-r2)+1)*4;
    }
    public long getRegionDiff(int r1, int r2){
        long result = 0;
        
        long fR = 0;
        long sR = 0;
        
        for(int i = 1; i < r1; i++)
            fR += Math.floor(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
        for(int i = 1; i < r2; i++){
            double cnt = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            if(cnt == Math.floor(cnt)) sR -= 1;
            sR += Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
        }
            
        result = Math.abs(fR-sR);
        
        return result; 
    }
}