class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = 100;
        int maxX = 0;
        int minY = 100;
        int maxY = 0;
        
        for(int i = 0; i<wallpaper.length; i++){
            char[] line = wallpaper[i].toCharArray();
            for(int j = 0; j<line.length; j++){
                if(line[j] == '#'){
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX+1;
        answer[3] = maxY+1;
        return answer;
    }
    
    /*  0 1
     0  . .
     1  # .
     
            0 1 2 3
        0   . . . .
        1   . . . .
        2   # . . .
        3   . . . . 
    */  
}