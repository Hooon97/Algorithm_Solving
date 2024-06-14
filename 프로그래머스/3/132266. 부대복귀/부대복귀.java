import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        /*
            1. 무향 그래프를 만든다.
            2. 다익스트라..?조지면 O(N^2)로 시간초과가 날 것.
            3. 아닌가? 해보자. 단, 향상된 다익스트라 ㄱㄱㅆ
        */
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++)
            graph[i] = new ArrayList<>();
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, 10000000);
        boolean[] visit = new boolean[n+1];
        dist[destination] = 0;
        visit[destination] = true;
        
        for(int[] road : roads){
            int st = road[0];
            int ed = road[1];
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        dijkstra(graph, dist, visit, destination);
        
        for(int i = 0; i<sources.length; i++){
            int target = sources[i];
            if(dist[target] == 10000000)
                answer[i] = -1;
            else
                answer[i] = dist[target];
        }
        
        
        return answer;
    }
    
    public void dijkstra(List<Integer>[] graph, int[] dist, boolean[] visit, int st){
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(st, 0));
        
        while(!q.isEmpty()){
            Edge cur = q.poll();
            
            for(int node : graph[cur.node]){
                if(visit[node]) continue;
                if(dist[node] > dist[cur.node]+1){
                    dist[node] = dist[cur.node]+1;
                    q.add(new Edge(node, dist[node]));
                    visit[node] = true;
                }
            }   
        }
    }
    
    class Edge implements Comparable<Edge>{
        int node;
        int value;
        Edge(int node, int value){
            this.node = node;
            this.value = value;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.value > e.value ? 1 : -1;
        }
    }
}