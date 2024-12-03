class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        
        int answer = 0;
        int firstCnt = 1;
        int etcCnt = 0;
        int lastIndex = 0;
        char[] arr = s.toCharArray();
        char firstChar = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(firstChar == arr[i]){
                firstCnt++;
            } else{
                etcCnt++;
            }
            
            if(firstCnt == etcCnt){
                answer++;
                lastIndex = i;
                if(i<arr.length-1) {
                    firstChar = arr[++i];
                }
                firstCnt = 1;
                etcCnt = 0;
            }
        }

        if(lastIndex != arr.length-1) answer++;
        
        return answer;
    }
}