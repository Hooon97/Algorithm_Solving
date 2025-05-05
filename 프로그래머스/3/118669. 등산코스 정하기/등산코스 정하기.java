import java.util.*;

class Solution {
    static final int MAX = 1000000000;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.w, n2.w);
            }
        });
        List<Node>[] graph = new ArrayList[n+1];
        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];
        int[] answer = new int[2];
        int[] dist = new int[n+1];
        Arrays.fill(answer, MAX);
        Arrays.fill(dist, MAX);
        Arrays.sort(summits);
        for(int i = 1; i<=n; i++) graph[i] = new ArrayList<>();
        for(int[] path : paths){
            int st = path[0];
            int ed = path[1];
            int intense = path[2];
            graph[st].add(new Node(ed, intense));
            graph[ed].add(new Node(st, intense));
        }
        
        // Gate에서 출발
        for(int i = 0; i<gates.length; i++){
            dist[gates[i]] = 0;
            pq.add(new Node(gates[i], 0));
            isGate[gates[i]] = true;
        }
        
        // Summit은 최종 방문 대상임
        for(int i = 0; i<summits.length; i++){
            isSummit[summits[i]] = true;
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.n] < cur.w) continue;
            if(isSummit[cur.n]) continue;
            for(Node next : graph[cur.n]){
                if(isGate[next.n]) continue;
                int newIntense = Math.max(dist[cur.n], next.w);
                if(newIntense < dist[next.n]){
                    dist[next.n] = newIntense;
                    pq.add(new Node(next.n, newIntense));
                }
            }
        }
        
        for(int summit : summits){
            if(dist[summit] < answer[1]){
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }
                
        return answer;
    }
    
    class Node{
        int n;
        int w;
        Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }
}