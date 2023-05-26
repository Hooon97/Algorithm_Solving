import java.util.*;

class Solution {
    static final int MAX_VALUE = 20000001;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX_VALUE;
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        int[] S = new int[n+1];
        Arrays.fill(A, MAX_VALUE);
        Arrays.fill(B, MAX_VALUE);
        Arrays.fill(S, MAX_VALUE);
        
        ArrayList<Edge>[] map = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++) map[i] = new ArrayList<>();
        for(int[] fare : fares){
            int st = fare[0];
            int ed = fare[1];
            int val = fare[2];
            map[st].add(new Edge(ed, val));
            map[ed].add(new Edge(st, val));
        }
        getDijkstra(A, a, map);
        getDijkstra(B, b, map);
        getDijkstra(S, s, map);
        
        for(int i = 1; i<n+1; i++){
            answer = Math.min(answer, A[i]+B[i]+S[i]);
        }
        
        return answer;
    }
    void getDijkstra(int[] T, int t, ArrayList<Edge>[] map){
        boolean[] visit = new boolean[T.length];
        T[t] = 0;
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(t, 0));
        while(!q.isEmpty()){
            Edge cur = q.poll();
            if(visit[cur.vertex]) continue;
            visit[cur.vertex] = true;
            
            for(Edge n : map[cur.vertex]){
                if(T[n.vertex] > T[cur.vertex] + n.value){
                    T[n.vertex] = T[cur.vertex] + n.value;
                    q.add(new Edge(n.vertex, T[n.vertex]));
                }
                
            }
        }
        
    }
}

class Edge implements Comparable<Edge>{
    int vertex;
    int value;
    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }
    
    public int compareTo(Edge e){
        return value-e.value;
    }
}