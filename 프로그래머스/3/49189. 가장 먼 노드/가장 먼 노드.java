import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dis = new int[n+1];
        Arrays.fill(dis, -1);
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] e : edge){
            int st = e[0];
            int ed = e[1];
            graph[st].add(ed);
            graph[ed].add(st);
        }
        
        Queue<Edge> q = new LinkedList<>();
        q.add(new Edge(1,0));
        dis[1] = 0;
        int maxCnt = 0;
        
        while(!q.isEmpty()){
            Edge cur = q.poll();
            
            for(int nextNode : graph[cur.node]){
                if(dis[nextNode] != -1) continue;
                dis[nextNode] = cur.cnt+1;
                q.add(new Edge(nextNode, dis[nextNode]));
                
                maxCnt = Math.max(maxCnt, cur.cnt+1);
            }
        }
        
        for(int nodeCnt : dis)
            if(nodeCnt == maxCnt) answer++;
        return answer;
    }
    
    class Edge{
        int node;
        int cnt;
        Edge(int node, int cnt){
            this.node = node;
            this.cnt = cnt;
        }
    }
}