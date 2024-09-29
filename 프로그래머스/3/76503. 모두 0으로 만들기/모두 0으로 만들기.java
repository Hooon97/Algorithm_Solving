import java.util.*;

class Solution {
    long answer;
    long[] valueArr;
    boolean[] visit;
    List<Integer>[] graph;
    public long solution(int[] a, int[][] edges) {
        answer = 0;
        for(int num : a) answer += num;
        if(answer != 0) return -1;
        
        visit = new boolean[a.length];
        valueArr = new long[a.length];
        graph = new ArrayList[a.length];
        for(int i = 0; i<a.length; i++){
            graph[i] = new ArrayList<>();
            valueArr[i] = a[i];
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        dfs(0);
        
        return answer;
    }
    
    public void dfs(int node){ 
        visit[node] = true;
        
        for(int i = 0; i<graph[node].size(); i++){
            if(visit[graph[node].get(i)]) continue;
            dfs(graph[node].get(i));
            valueArr[node] += valueArr[graph[node].get(i)];
        }
        
        answer += Math.abs(valueArr[node]);
    }
}