import java.util.*;

class Solution {
    int maxSheep;
    List<Integer>[] graph;
    int[] info;
    public int solution(int[] wolf_info, int[][] edges) {
        maxSheep = 0;
        info = wolf_info;
        graph = new ArrayList[info.length];
        for(int i = 0; i<info.length; i++) graph[i] = new ArrayList<>();
        for(int[] edge : edges){
            int st = edge[0];
            int ed = edge[1];
            graph[st].add(ed);
        }
        
        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(next, 0, 0, 0);
        
        return maxSheep;
    }
    public void dfs(List<Integer> nextArr, int index, int sheepCnt, int wolfCnt){
        if(info[index] == 0){
            sheepCnt++;
            maxSheep = Math.max(maxSheep, sheepCnt);
        } else wolfCnt++;
        
        if(sheepCnt <= wolfCnt) return;
        
        List<Integer> list = new ArrayList<>();
        list.addAll(nextArr);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i) == index){
                list.remove(i);
                break;
            }
        }
        for(int n : graph[index]) list.add(n);
        
        for(int n : list){
            dfs(list, n, sheepCnt, wolfCnt);
        }
        
    }
}