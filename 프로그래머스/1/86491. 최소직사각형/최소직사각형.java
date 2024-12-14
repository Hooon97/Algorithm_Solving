class Solution {
    public int solution(int[][] sizes) {
        
        int maxIdx = 0;
        int minIdx = 0;
        int maxValue = 0;
        int minValue = 0;
        // find maxIdx
        for(int i = 0; i<sizes.length; i++){
            int curMax = Math.max(sizes[i][0], sizes[i][1]);
            if(curMax > maxValue){
                maxIdx = i;
                maxValue = curMax;
            }
        }
        
        // find minIdx
        for(int i = 0; i<sizes.length; i++){
            int curMin = Math.min(sizes[i][0], sizes[i][1]);
            if(curMin > minValue){
                minIdx = i;
                minValue = curMin;
            }
        }
        System.out.println(maxValue + " " + minValue);
        System.out.println(maxIdx + " " + minIdx);
        return minValue * maxValue;
    }
}