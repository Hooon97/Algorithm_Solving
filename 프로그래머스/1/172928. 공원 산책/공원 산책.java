import java.util.*;
class Solution {
    public int[] solution(String[] parks, String[] routes) {
        int[] answer = new int[2];
        char[][] park = new char[parks.length][parks[0].length()];
        for(int i = 0; i<park.length; i++){
            park[i] = parks[i].toCharArray();
        }
        
        for(int i = 0; i<park.length; i++){
            for(int j = 0; j<park[0].length; j++){
                if(park[i][j] == 'S'){
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for(String route : routes){
            String[] order = route.split(" ");
            Move(order[0], order[1], park, answer);
        }
        
        return answer;
    }
    
    public void Move(String op, String lengStr, char[][] map, int[] answer){
        int leng = Integer.valueOf(lengStr);
        switch(op){
            case "E": 
                if(answer[1] + leng >= map[0].length) return;
                for(int i = 1; i<=leng; i++){
                    if(map[answer[0]][answer[1]+i] == 'X') return;
                }
                answer[1] += leng;
                break;
            case "S":
                if(answer[0] + leng >= map.length) return;
                for(int i = 1; i<=leng; i++){
                    if(map[answer[0]+i][answer[1]] == 'X') return;
                }
                answer[0] += leng;
                break;
            case "W":
                if(answer[1] - leng < 0) return;
                for(int i = 1; i<=leng; i++){
                    if(map[answer[0]][answer[1]-i] == 'X') return;
                }
                answer[1] -= leng;
                break;
            case "N":
                if(answer[0] - leng < 0) return;
                for(int i = 1; i<=leng; i++){
                    if(map[answer[0]-i][answer[1]] == 'X') return;
                }
                answer[0] -= leng;
                break;
        }

    }
}