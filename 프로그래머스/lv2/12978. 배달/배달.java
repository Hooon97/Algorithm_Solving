import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        dijkstra(dist, visit, road);
        
        for(int i = 1; i<N+1; i++) 
            if(dist[i] <= K) answer++;
        return answer;
    }
    public void dijkstra(int[] dist, boolean[] visit, int[][] road){
        ArrayList<Node>[] map = new ArrayList[dist.length];
        for(int i = 1; i<dist.length; i++) map[i] = new ArrayList<>();
        for(int[] r : road){
            int st = r[0];
            int ed = r[1];
            int leng = r[2];
            map[st].add(new Node(ed, leng));
            map[ed].add(new Node(st, leng));
        }
        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(visit[cur.index]) continue;
            visit[cur.index] = true;
            
            for(Node n : map[cur.index]){
                if(dist[n.index] > dist[cur.index] + n.cost){
                    dist[n.index] = dist[cur.index] + n.cost;
                    q.add(new Node(n.index, dist[n.index]));
                }
            }
        }
        
    }
}
class Node implements Comparable<Node>{
    int index;
    int cost;
    Node(int index, int cost){
        this.index = index;
        this.cost = cost;
    }
    public int compareTo(Node n){
        return cost-n.cost;
    }
}