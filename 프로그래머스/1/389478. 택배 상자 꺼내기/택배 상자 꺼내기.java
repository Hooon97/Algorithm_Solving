class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        int box_h = (num + w - 1) / w; // 박스 위치 높이
        int box_l = 0; // 박스 위치, 왼쪽 기준
        if(box_h % 2 == 0){
            box_l = -1 * num%w;
            if(box_l == 0) box_l = -w;
        } else{
            box_l = num%w;
            if(box_l == 0) box_l = w;
        }
        
        int total_h = (n+w-1)/w; // 전체 박스 높이
        int total_l = 0;
        if(total_h % 2 == 0){
            total_l = -1 * n%w;
            if(total_l == 0) total_l = -w;
        } else{
            total_l = n%w;
            if(total_l == 0) total_l = w; 
        }
        
        answer = total_h - box_h+1;
        
        if(box_h % 2 == total_h % 2){
            if(Math.abs(box_l) > Math.abs(total_l)) answer--;
        } else{
            if(Math.abs(box_l) + Math.abs(total_l) < w) answer--;
        }
        
        return answer;
    }
}