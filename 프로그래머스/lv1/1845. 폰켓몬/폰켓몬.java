import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> types = new HashSet<>();
        for(int i : nums) types.add(i);
        int sizeTypes = types.size();
        int leng = nums.length;
        
        if(leng/2 <= sizeTypes) answer = leng/2;
        else answer = sizeTypes;
        
        return answer;
    }
}