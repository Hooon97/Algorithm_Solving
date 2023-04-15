import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] pCheck = new int[10];
        Queue<Work> q = new LinkedList<>();
        for(int i = 0; i<priorities.length; i++){
            pCheck[priorities[i]]++;
            q.add(new Work(i, priorities[i]));
        }
        
        int maxP = 0;
        for(int i = 9; i>0; i--){
            if(pCheck[i] != 0) {
                maxP = i;
                break;
            }
        }
        
        while(!q.isEmpty()){
            Work cur = q.poll();
            if(maxP > cur.prio){ //후순위로 밀림
                q.add(cur);
            }
            else{
                if(--pCheck[maxP] == 0){
                    for(int i = 9; i>0; i--){
                        if(pCheck[i] != 0) {
                            maxP = i;
                            break;
                        }
                    }
                }
                answer++;
                if(cur.loc == location) break;
            }
            
        }
        
        return answer;
    }
}

class Work{
    int loc;
    int prio;
    Work(int loc, int prio){
        this.loc = loc;
        this.prio = prio;
    }
}