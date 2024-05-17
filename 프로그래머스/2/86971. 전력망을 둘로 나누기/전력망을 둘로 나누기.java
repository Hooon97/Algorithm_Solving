import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        
        /*
            1. 존재하는 노드의 개수를 파악한다.
            2. 그래프를 만든다.
            3. BFS로 돌며 하나의 트리의 노드 개수를 파악한다.
            4. 노드의 개수 차를 저장하고, 최소 값을 갱신한다.
        */
        int nodeCount = getNodeCount(wires);
        for(int i = 0; i<wires.length; i++){
            List<List<Integer>> grp = buildTree(nodeCount, i, wires);
            int count = getOneTreeNodeCount(grp, 1);
            int diff = Math.abs(nodeCount - count*2);
            answer = Math.min(answer, diff);
        }
        
        return answer;
    }
    public int getNodeCount(int[][] wires){
        Set<Integer> set = new HashSet<>();
        for(int[] wire : wires){
            set.add(wire[0]);
            set.add(wire[1]);
        }
        
        return set.size();
    }
    
    public List<List<Integer>> buildTree(int size, int idx, int[][] wires){
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i<size+1; i++){
            tree.add(new ArrayList<>());
        }
        
        for(int i = 0; i<wires.length; i++){
            if(i == idx) continue;
            int[] wire = wires[i];
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        return tree;
    }
    
    public int getOneTreeNodeCount(List<List<Integer>> tree, int stNode){
        Queue<Integer> q = new LinkedList<>();
        int nodeSize = tree.size();
        boolean[] visit = new boolean[nodeSize+1];
        int count = 0;
        q.add(stNode);
        
        while(!q.isEmpty()){
            int node = q.poll();
            visit[node] = true;
            count++;
            for(int nextNode : tree.get(node)){
                if(visit[nextNode]) continue;
                q.add(nextNode);
            }
        }

        return count;
    }
    
}