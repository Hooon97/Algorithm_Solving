import java.util.*;

class Solution {
    /*
        1. 각 형태의 도넛은 정점과 에지의 개수가 정해져있다.
        2. parent 배열에 최초 시작한 정점의 값을 넣고, 이미 탐색이 끝났음을 명시한다.
        3. 만약 탐색이 종료되었는데 탐색한 정점과 에지의 개수가 명시된 규칙을 따르지 않으면
            시작 정점이 생성된 정점이다.
        4. 탐색 노드를 2개 이상 지니고 있는 노드는 생성된 정점이다.
        
        ---
        
        1. 한 노드에서 나가는 간선과 들어오는 간선이 2개인 경우 = 8자 모양
        (혹은 생성된 정점)
        2. 한 노드에서 나가는 간선이 2개 이상이고 들어오는 간선이 없는 경우 = 생성된 정점
        3. 들어오는 노드는 없고 나가는 노드만 있는 경우 = 막대 모양
        4. 생성된 정점은 "모든 그래프"의 임의의 정점에 연결되므로, 정점의 out 간선 개수는 그래프의 수와 같다.
        
    */
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        
        for(int[] edge : edges){
            out.put(edge[0], out.getOrDefault(edge[0], 0)+1);
            in.put(edge[1], in.getOrDefault(edge[1], 0)+1);
        }
        
        for(Integer node : out.keySet()){
            if(out.get(node) > 1){
                if(!in.containsKey(node)) answer[0] = node; // 생성된 정점
                else answer[3]++; // 8자 모양
            }
        }
        
        for(Integer node : in.keySet()){
            if(!out.containsKey(node)) answer[2]++; // 막대 모양
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}