import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        ArrayList<int[]> A = new ArrayList<>();
        int sum = sequence[0];
        int left = 0;
        int right = 0;
        
        while(left <= right && right < sequence.length){
            if(sum == k){
                A.add(new int[]{left, right});
                sum -= sequence[left++];
            }
            else if(sum < k){
                if(right+1 >= sequence.length) break;
                sum += sequence[++right];
            }
            else{
                sum -= sequence[left++];
            }
        }
        
        Collections.sort(A, (o1,o2) -> {
            if(o1[1]-o1[0] == o2[1] - o2[0]){
                return o1[0] - o2[0];
            }
            if(o1[1] - o1[0] > o2[1] - o2[0])
                return 1;
            else return -1;
        });
        
        answer = A.get(0);
        return answer;
    }
}