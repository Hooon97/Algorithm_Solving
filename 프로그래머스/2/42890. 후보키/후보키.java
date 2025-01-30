import java.util.*;

class Solution {
    int R, C;
    List<Integer> cKeyList;
    public int solution(String[][] relation) {
        int answer = 0;
        R = relation.length;
        C = relation[0].length;
        cKeyList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< (1<<C); i++){
            Set<String> unique = new HashSet<>();
            
            for(int j = 0; j<R; j++){
                sb.setLength(0);
                for(int p = 0; p<C; p++){
                    if((i & (1 << p)) > 0){
                        sb.append(relation[j][p]);
                    }
                }
                unique.add(sb.toString());
            }
            if(unique.size() != R) continue;
            checkUnique(i);
        }
        
        return cKeyList.size();
    }
    
    public void checkUnique(int p){
        for(int i = 0; i<cKeyList.size(); i++){
            if((cKeyList.get(i) & p) == cKeyList.get(i)) return;
        }
        
        cKeyList.add(p);
    }
}