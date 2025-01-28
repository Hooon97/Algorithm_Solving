import java.util.*;

class Solution {
    /*
        Kruskal Algorithm
    */
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[101];
        for(int i = 0; i<101; i++) parent[i] = i;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        
        for(int i = 0; i<costs.length; i++){
            int[] cost = costs[i];
            Edge edge = new Edge(cost[0], cost[1], cost[2]);
            pq.add(edge);
        }
        
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.s) != find(edge.e)){
                answer += edge.w;
                union(edge.s, edge.e);
            }
        }
        
        return answer;
    }
    
    public int find(int idx){
        if(parent[idx] == idx) return idx;
        
        return parent[idx] = find(parent[idx]);
    }
    
    public void union(int s, int e){
        int a = find(s);
        int b = find(e);
        if(a != b)
            parent[a] = b;
    }
    
    class Edge{
        int s;
        int e;
        int w;
        
        Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}