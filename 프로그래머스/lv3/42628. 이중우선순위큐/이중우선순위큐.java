import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations){
            String[] oper = s.split(" ");
            if(oper[0].equals("I")){
                minQ.add(Integer.valueOf(oper[1]));
                maxQ.add(Integer.valueOf(oper[1]));
            }
            else{
                if(minQ.isEmpty() || maxQ.isEmpty()) continue;
                if(oper[1].equals("1")) {
                    int cur = maxQ.poll();
                    minQ.remove(cur);
                }
                else {
                    int cur = minQ.poll();   
                    maxQ.remove(cur);
                }
            }
        }
        
        int[] answer = new int[2];
        if(maxQ.isEmpty() || minQ.isEmpty()){
            answer[0] = answer[1] = 0;
        }
        else if(maxQ.size() == 1){
            answer[0] = maxQ.poll();
            answer[1] = 0;
        }
        else if(minQ.size() == 1){
            answer[0] = minQ.poll();
            answer[1] = 0;
        }
        else{
            answer[0] = maxQ.poll();
            answer[1] = minQ.poll();
        }
        
        return answer;
    }
}