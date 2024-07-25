class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if(arr.length == 1) return new int[]{-1};
        int min = Integer.MAX_VALUE;
        for(int num : arr) min = Math.min(min, num);
        int idx = 0;
        for(int num : arr){
            if(num == min) continue;
                answer[idx++] = num;
        }
        
        return answer;
    }
}