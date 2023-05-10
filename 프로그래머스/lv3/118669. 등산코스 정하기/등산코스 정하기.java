import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        boolean[] visit = new boolean[n+1];
        ArrayList<Node>[] A = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++)
            A[i] = new ArrayList<Node>();
        
        for(int[] path : paths){
            A[path[0]].add(new Node(path[1], path[2]));
            A[path[1]].add(new Node(path[0], path[2]));
        }
        
        int curIntensity = Integer.MAX_VALUE;
        int curSummit = 0;
        Arrays.sort(summits);
        
        for(int p = 0; p<gates.length; p++){
            dist[gates[p]] = 0;
            pq.add(new Node(gates[p], 0));
        }
            
        for(int p = 0; p<summits.length; p++)
            visit[summits[p]] = true;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visit[cur.node]) continue;
            if(dist[cur.node] < cur.length) continue;
            
            for(Node o : A[cur.node]){
                int tmpIntensity = (o.length == Integer.MAX_VALUE) ? cur.length : Math.max(o.length, cur.length);
                if(dist[o.node] > tmpIntensity){
                    dist[o.node] = tmpIntensity;
                    pq.offer(new Node(o.node, tmpIntensity));
                }
            }
        }
        
        for(int p = 0; p<summits.length; p++){
            if(dist[summits[p]] < curIntensity){
                curIntensity = dist[summits[p]];
                curSummit = summits[p];
            }
        }
        
        int[] answer = {curSummit, curIntensity};
        return answer;
    }
}

class Node implements Comparable<Node>{
    int node;
    int length;
    Node(int node, int length){
        this.node = node;
        this.length = length;
    }
    public int compareTo(Node o){
        return length-o.length;
    }
}