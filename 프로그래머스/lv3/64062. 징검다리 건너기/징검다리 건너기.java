class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 200000000;
        while(left <= right){
            int mid = (left+right)/2;
            if(canAcross(stones, mid, k)){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return right;
    }
    boolean canAcross(int[] stones, int mid, int k){
        int skipStone = 0;
        for(int stone : stones){
            if(stone < mid) skipStone++; //못건너감
            else{
                //건너갈 수 있음
                skipStone = 0;
            }
            if(skipStone == k) return false;
        }
        return true;
    }
}
    //효율성 13번 테케 통과x
//         int maxStone = findMax(stones, 0, k);
//         int answer = maxStone;
//         for(int i = 0; i<stones.length-k; i++){
//             int before = stones[i];
//             int next = stones[i+k];
//             if(next >= maxStone) {
//                 maxStone = next;
//             }
//             else if(before == maxStone){
//                 maxStone = findMax(stones, i+1, k);
//             }   
//             answer = Math.min(maxStone, answer);
//         }
        
//         return answer;
//     }
//     public int findMax(int[] stones, int index, int k){
//         int result = 0;
//         for(int i = index; i<index+k; i++){
//             result = Math.max(stones[i], result);
//         }
//         return result;
    
    // 효율성 전체 시간 초과
// PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i = 0; i<k; i++) maxQ.add(stones[i]);
        // int answer = maxQ.peek();
        // for(int i = 0; i<stones.length-k; i++){
        //     maxQ.remove(stones[i]);
        //     maxQ.add(stones[i+k]);
        //     answer = answer > maxQ.peek() ? maxQ.peek() : answer;
        // }