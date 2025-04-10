import java.util.*;

class Solution {
    /*
        구현 문제
        1. R x C 2차원 배열을 두 개 만든다. String[R][C][2];
        2. ..0은 cell의 값을 의미한다.
        3. ..1은 병합된 cell을 의미한다.
        4. 배열의 초기 값은 EMPTY 이다.
        
        UPDATE, UMERGE는 배열을 전체 탐색하여 찾는다.
        -> Map으로 위치를 관리하는 방식으로 최적화가 가능하다.
    */
    String[][][] EXCEL;
    static final String EMPTY = "EMPTY";
    public String[] solution(String[] commands) {
        List<String> answerList = new ArrayList<>();
        EXCEL = new String[50][50][2];
        // init
        for(int i = 0; i<50; i++){
            for(int j = 0; j<50; j++){
                EXCEL[i][j][0] = EMPTY;
                EXCEL[i][j][1] = i+"/"+j;
            }
        }
        
        for(String command : commands){
            String[] coms = command.split(" ");
            switch(coms[0]){
                case "UPDATE" : updateExcel(coms);
                    break;
                case "MERGE" : mergeExcel(coms[1], coms[2], coms[3], coms[4]);
                    break;
                case "UNMERGE" : unmergeExcel(coms[1], coms[2]);
                    break;
                case "PRINT" : printExcel(answerList, coms[1], coms[2]);
                    break;
            }
        }
        
        return answerList.toArray( new String[answerList.size()] );
    }
    
    public void printExcel(List<String> answer, String row, String col){
        int r = Integer.valueOf(row) - 1 ;
        int c = Integer.valueOf(col) - 1 ;
        answer.add(EXCEL[r][c][0]);
    }
    
    public void unmergeExcel(String row, String col){
        int r = Integer.valueOf(row) - 1;
        int c = Integer.valueOf(col) - 1;
        String value = EXCEL[r][c][0];
        String idx = EXCEL[r][c][1];

        for(int i = 0; i<50; i++){
            for(int j = 0; j<50; j++){
                if(EXCEL[i][j][1].equals(idx)){
                    EXCEL[i][j][1] = i+"/"+j;
                    EXCEL[i][j][0] = EMPTY;
                }
            }
        }
        
        EXCEL[r][c][1] = r+"/"+c;
        EXCEL[r][c][0] = value;
    }
    
    public void mergeExcel(String row1, String col1, String row2, String col2){
        int r1 = Integer.valueOf(row1) - 1;
        int c1 = Integer.valueOf(col1) - 1;
        int r2 = Integer.valueOf(row2) - 1;
        int c2 = Integer.valueOf(col2) - 1;
        if(r1 == r2 && c1 == c2) return;
        String idx1 = EXCEL[r1][c1][1];
        String idx2 = EXCEL[r2][c2][1];
        if(idx1.equals(idx2)) return;
        
        String value = "";
        if(EXCEL[r1][c1][0].equals(EMPTY)){
            value = EXCEL[r2][c2][0];
        } else{
            value = EXCEL[r1][c1][0];
        }
        
        
        for(int i = 0; i<50; i++){
            for(int j = 0; j<50; j++){
                if(EXCEL[i][j][1].equals(idx2) || EXCEL[i][j][1].equals(idx1)){
                    EXCEL[i][j][1] = idx1;
                    EXCEL[i][j][0] = value;
                }
            }
        }
    }
    
    public void updateExcel(String[] command){
        if(command.length == 4){
            String row = command[1];
            String col = command[2];
            String value = command[3];
            int r = Integer.valueOf(row) - 1;
            int c = Integer.valueOf(col) - 1;
            String idx = EXCEL[r][c][1];

            for(int i = 0; i<50; i++){
                for(int j = 0; j<50; j++){
                    if(EXCEL[i][j][1].equals(idx)){
                        EXCEL[i][j][0] = value;
                    }
                }
            }
        } else{
            String target = command[1];
            String value = command[2];
            for(int i = 0; i<50; i++){
                for(int j = 0; j<50; j++){
                    if(EXCEL[i][j][0].equals(target)){
                        EXCEL[i][j][0] = value;
                    }
                }
            }
            
        }
        
        
    }
}