import java.util.*;

class Solution {
    public int solution(int[] number) {
        int[] num = new int[3];
        return findComb(number, num, 0, 0);
    }
    
    public int findComb(int[] number, int[] nums, int idx, int depth){
        if(depth == 3){
            int sum = 0;
            for(int n : nums) sum += n;
            return sum == 0 ? 1 : 0;
        }
        if(idx >= number.length) return 0;
        
        nums[depth] = number[idx];
        return findComb(number, nums, idx+1, depth+1) + findComb(number, nums, idx+1, depth);
    }
    
    
}