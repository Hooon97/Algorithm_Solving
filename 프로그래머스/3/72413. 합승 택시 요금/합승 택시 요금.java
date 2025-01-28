import java.util.*;

class Solution {
    /*
        S->B 최단 루트 + S -> A 최단 루트
        두 루트에서 겹치는 지점이 있을 수 있음
        따라서 임의의 한 노드 N이 있다고 할 때,
        S->N + B->N + A->N의 최솟값을 구하면 됨.
        
        중복 루트가 존재할 수 있느냐?
        다익스트라로 구할거라 없음..
    */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        int[] S = new int[n+1];
        
        Arrays.fill(A, 10000000);
        Arrays.fill(B, 10000000);
        Arrays.fill(S, 10000000);
        
        List<Edge>[] graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i<fares.length; i++){
            int[] fare = fares[i];
            graph[fare[0]].add(new Edge(fare[1], fare[2]));
            graph[fare[1]].add(new Edge(fare[0], fare[2]));
        }
        
        getMinimumPath(A, a, graph);
        getMinimumPath(B, b, graph);
        getMinimumPath(S, s, graph);
        
        answer = Integer.MAX_VALUE;
        for(int i = 1; i<=n; i++){
            answer = Math.min(answer, A[i]+B[i]+S[i]);
        }
        
        return answer;
    }
    
    public void getMinimumPath(int[] distance, int start, List<Edge>[] graph){
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->o1.w-o2.w);
        pq.add(new Edge(start, 0));
        
        boolean[] visit = new boolean[distance.length];
        distance[start] = 0;
        
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(visit[cur.e]) continue;
            visit[cur.e] = true;
            
            // 관련된 노드 탐색
            for(Edge next : graph[cur.e]){
                if(distance[next.e] > distance[cur.e] + next.w){
                    distance[next.e] = distance[cur.e] + next.w;
                    pq.add(new Edge(next.e, distance[next.e]));
                }
            }
        }
        
    }
    
    
    class Edge{
        int e;
        int w;
        Edge(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
}