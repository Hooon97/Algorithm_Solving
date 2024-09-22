import java.util.*;

class Solution {
    String[][] excel;
    int[][] merge;
    LinkedList<int[]>[] indexList;
    String EMPTY;
    public String[] solution(String[] commands) {
        String[] answer = {};
        excel = new String[50][50];
        merge = new int[50][50];
        indexList = new LinkedList[2500];
        EMPTY = "EMPTY";
        
        int idx = 0;
        for(int i = 0; i<50; i++){
            for(int j = 0; j<50; j++){
                excel[i][j] = EMPTY;
                merge[i][j] = idx;
                indexList[idx] = new LinkedList<>();
                indexList[idx++].add(new int[]{i, j});
            }
        }
        
        List<String> ansList = new ArrayList<>();
        for(String command : commands){
            String[] comArr = command.split(" ");
            if(comArr[0].equals("PRINT")) ansList.add(printCommand(comArr));
            else doCommand(comArr);
        }
        
        answer = new String[ansList.size()];
        for(int i = 0; i<ansList.size(); i++) answer[i] = ansList.get(i);
        
        return answer;
    }
    
    private String printCommand(String[] comArr){
        int r = Integer.valueOf(comArr[1])-1;
        int c = Integer.valueOf(comArr[2])-1;
        return excel[r][c];
    }
    
    private void doCommand(String[] comArr){
        if(comArr[0].equals("UPDATE")){
            if(comArr.length == 4){
                //지정 업데이트
                int r = Integer.valueOf(comArr[1])-1;
                int c = Integer.valueOf(comArr[2])-1;
                int mergeIdx = merge[r][c];
                
                for(int[] spot : indexList[mergeIdx]){
                    excel[spot[0]][spot[1]] = comArr[3];
                }
            } else{
                //전체 업데이트
                if(comArr[1].equals(comArr[2])) return;
                for(int i = 0; i<50; i++){
                    for(int j = 0; j<50; j++){
                        if(excel[i][j].equals(comArr[1])) excel[i][j] = comArr[2];
                    }
                }   
            }
        } else if(comArr[0].equals("MERGE")){
            int r1 = Integer.valueOf(comArr[1])-1;
            int c1 = Integer.valueOf(comArr[2])-1;
            int r2 = Integer.valueOf(comArr[3])-1;
            int c2 = Integer.valueOf(comArr[4])-1;
            
            if(r1 == r2 && c1 == c2) return;
            if(merge[r1][c1] == merge[r2][c2]) return;
            
            int mergeIdx = merge[r1][c1];
            int targetIdx = merge[r2][c2];
            
            if(!excel[r1][c1].equals(EMPTY)){
                String mergeValue = excel[r1][c1];
                List<int[]> tmpList = new ArrayList<>();
                for(int[] spot : indexList[targetIdx]){
                    excel[spot[0]][spot[1]] = mergeValue;
                    merge[spot[0]][spot[1]] = mergeIdx;
                    tmpList.add(spot);
                }
                indexList[mergeIdx].addAll(tmpList);
                indexList[targetIdx].clear();
            } else{
                String mergeValue = excel[r2][c2];
                for(int[] spot : indexList[mergeIdx]){
                    excel[spot[0]][spot[1]] = mergeValue;
                }
                
                List<int[]> tmpList = new ArrayList<>();
                for(int[] spot : indexList[targetIdx]){
                    merge[spot[0]][spot[1]] = mergeIdx;
                    tmpList.add(spot);
                }
                indexList[mergeIdx].addAll(tmpList);
                indexList[targetIdx].clear();
            }
        } else if(comArr[0].equals("UNMERGE")){
            int r = Integer.valueOf(comArr[1])-1;
            int c = Integer.valueOf(comArr[2])-1;
            
            String unmergeValue = excel[r][c];
            int unmergeIdx = merge[r][c];
            
            List<int[]> tmpList = new ArrayList<>();
            for(int[] spot : indexList[unmergeIdx]){
                excel[spot[0]][spot[1]] = EMPTY;
                merge[spot[0]][spot[1]] = spot[0]*50+spot[1];
                tmpList.add(spot);
            }
            excel[r][c] = unmergeValue;
            indexList[unmergeIdx].clear();
            for(int[] spot : tmpList){
                int mergeIdx = merge[spot[0]][spot[1]];
                indexList[mergeIdx].add(spot);
            }
        }
    }
    
}