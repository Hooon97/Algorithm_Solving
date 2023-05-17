import java.util.*;

class Solution {
    static int[][] location;
    public String solution(int[] numbers, String hand) {
        location = new int[][]{{4,2}, 
                    {1,1}, {1,2}, {1,3}, 
                    {2,1}, {2,2}, {2,3}, 
                    {3,1}, {3,2}, {3,3},
                    {4,1}, {4,3}};
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 11;
        for(int i : numbers){
            switch(i){
                case 1 : case 4 : case 7 :
                    sb.append("L");
                    left = i;
                    break;
                case 3 : case 6 : case 9 :
                    sb.append("R");
                    right = i;
                    break;
                default :
                    int tmp = getLocation(hand, i, left, right);
                    if(tmp == -1){
                        sb.append("L");
                        left = i;
                    }
                    else{
                        sb.append("R");
                        right = i;
                    }
                break;
            }
        }
        
        return sb.toString();
    }
    public int getLocation(String hand, int target, int left, int right){
        int leftLeng = Math.abs(location[target][0] - location[left][0]) + 
            Math.abs(location[target][1] - location[left][1]);
        int rightLeng = Math.abs(location[target][0] - location[right][0]) + 
            Math.abs(location[target][1] - location[right][1]);

        if(leftLeng < rightLeng) return -1;
        else if(leftLeng > rightLeng) return 1;
        else{
            if(hand.equals("right")){
                return 1;
            }
            else return -1;
        }
    }
}