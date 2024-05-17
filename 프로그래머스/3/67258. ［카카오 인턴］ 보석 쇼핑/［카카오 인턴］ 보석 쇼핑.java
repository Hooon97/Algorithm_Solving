import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        /*
            1. 보석의 이름을 key, 개수를 value로 갖는 Map을 선언한다.
            2. 범위를 구하므로, 투 포인터를 활용한다.
            3. last Index부터 줄이되, 0이 되는 gem이 있다면 멈춘다.
            4. last Index가 멈추면, start index부터 검사한다.
        */
        Map<String, Integer> gemCount = new HashMap<>();
        Set<String> gemSet = new HashSet<>();
        for(String gem : gems)
            gemSet.add(gem);
        
        int st = 0;
        int ed = 0;
        int distance = 1000001;
        int count = gemSet.size();
        
        int left = 0;
        int right = 0;
        while(st <= ed){
            if(gemCount.size() == count){
                gemCount.put(gems[st], gemCount.get(gems[st])-1);
                if(gemCount.get(gems[st]) == 0) 
                    gemCount.remove(gems[st]);
                st++;
            }
            else if(ed == gems.length){
                break;
            }
            else{
                gemCount.put(gems[ed], gemCount.getOrDefault(gems[ed],0)+1);
                ed++;
            }
            
            
            if(gemCount.size() == count){
                if(ed-st < distance){
                    left = st+1;
                    right = ed;
                    distance = ed-st;
                }
            }
            
        }
        
        answer[0] = left;
        answer[1] = right;
        return answer;
    }
}