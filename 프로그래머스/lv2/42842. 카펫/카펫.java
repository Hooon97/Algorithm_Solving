class Solution {
    static int[] answer;
    public int[] solution(int brown, int yellow) {
        // 열과 행은 3 이상이다.
        // 노란색의 숫자는 행-2 * 열-2
        // 갈색의 숫자는 열*행-노란색 숫자
        // 열과 행은 각각 1씩 증가할 수 있다.
        // 열은 행의 크기보다 같거나, 크다. -> 열부터 증가시킨다.
        int area = brown+yellow;
        int[] answer = new int[]{0,0};
        for(int b = 3; b<5001; b++){
            int y = area/b;
            if(y > b || area%b != 0) continue;
            if((b-2)*(y-2) == yellow){
                answer[0] = b;
                answer[1] = y;
                break;
            }
        }
        
        return answer;
    }
}