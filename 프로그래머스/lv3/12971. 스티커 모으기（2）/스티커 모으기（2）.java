class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int N = sticker.length;
        if(N == 1) return sticker[0];
        int[] distA = new int[N]; // 첫번째 스티커부터 뜯은 경우
        int[] distB = new int[N]; // 두번째 스티커부터 뜯은 경우
        distA[0] = sticker[0];
        distA[1] = sticker[0];
        distB[1] = sticker[1];
        
        //찢는 경우 vs 찢지 않는 경우(이전 값을 그대로 유지할 경우)
        for(int i = 2; i<N; i++){
            distA[i] = Math.max(distA[i-1], distA[i-2] + sticker[i]);
            distB[i] = Math.max(distB[i-1], distB[i-2] + sticker[i]);
        }

        return (int)Math.max(distA[N-2], distB[N-1]);
    }
}