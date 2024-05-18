import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        
        boolean[] visit = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for(int[] cost : costs){
            int s = cost[0];
            int e = cost[1];
            int v = cost[2];
            graph[s].add(new Edge(e,v));
            graph[e].add(new Edge(s,v));
        }
        
        pq.add(new Edge(0,0));
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visit[cur.e]) continue;
            
            answer += cur.v;
            visit[cur.e] = true;
            for(Edge e : graph[cur.e]){
                if(visit[e.e]) continue;
                pq.add(e);
            }
                
        }

        return answer;
    }
    
    class Edge implements Comparable<Edge>{
        int e;
        int v;
        Edge(int e, int v){
            this.e = e;
            this.v = v;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.v < e.v ? -1 : 1;
        }
    }
}