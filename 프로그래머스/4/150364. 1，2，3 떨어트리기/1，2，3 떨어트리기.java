import java.util.*;

class Solution {
    Map<Integer, Node> nodeMapper;
    Map<Integer, Integer> countMapper;
    Map<String, List<Integer>> lexMemo;
    List<Integer> nodeSequence;
    int[] target;
    int[] usableNums;
    boolean unableFlag;
    boolean ableFlag;
    public int[] solution(int[][] edges, int[] targ) {
        int[] answer = {};
        usableNums = new int[]{1,2,3};
        nodeMapper = new HashMap<>();
        countMapper = new HashMap<>();
        lexMemo = new HashMap<>();
        nodeSequence = new ArrayList<>();
        target = targ;
        unableFlag = false;
        ableFlag = false;
        
        Arrays.sort(edges, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return Integer.compare(a[1], b[1]);
                } else{
                    return Integer.compare(a[0], b[0]);
                }
            }
        });
        
        initNodeMapper();
        
        for(int[] edge : edges){
            int parent = edge[0];
            int son = edge[1];
            Node parentNode = nodeMapper.get(parent);
            Node sonNode = nodeMapper.get(son);
            parentNode.sonQueue.add(sonNode);
        }
        
        while(!ableFlag && !unableFlag){
            dfs(1);    
        }
        
        if(ableFlag){
            return createAnswer();
        }

        return new int[]{ -1 };
    }
    
    public int[] createAnswer(){
        int[] answer = new int[nodeSequence.size()];
        
        Map<Integer, List<Integer> > leafLexMapper = findLeafLexMapper();
        for(int i = 0; i<nodeSequence.size(); i++){
            int node = nodeSequence.get(i);
            List<Integer> nodeList = leafLexMapper.get(node);
            answer[i] = nodeList.get(0);
            nodeList.remove(0);
        }
        
        return answer;
    }
    
    public Map<Integer, List<Integer>> findLeafLexMapper(){
        Map<Integer, List<Integer>> result = new HashMap<>();
        for(int i = 0; i<target.length; i++){
            if(target[i] != 0){
                result.put(i+1, findLexFirst( countMapper.get(i+1), target[i] ) );
            }
        }
        
        return result;
    }
    
    public List<Integer> findLexFirst(int N, int S){
        List<Integer> ans = new ArrayList<>(N);
        for (int i = 1; i <= N; i++) {
            int R = N - i; // 자릿수
            int ai = Math.max(1, S - 3 * R);
            ai = Math.min(ai, 3);
            ans.add(ai);
            S -= ai;
        }
        return ans;
    }
    
    public void checkEndCondition(){
        // 불가능 조건
        for(int i = 0; i<target.length; i++){
            int node = i+1;
            if(target[i] != 0){
                int cnt = countMapper.get(node);
                if(cnt > target[i]){
                    unableFlag = true;
                    return;
                }
            }
        }
        
        // 가능 조건
        boolean tmpFlag = true;
        for(int i = 0; i<target.length; i++){
            int node = i+1;
            if(target[i] != 0){
                int cnt = countMapper.get(node);
                if(cnt * 3 < target[i]){
                    tmpFlag = false;
                }
            }
        }
        if(tmpFlag) ableFlag = true;
    }
    
    public void dfs(int node){
        Node curNode = nodeMapper.get(node);
        if(curNode.sonQueue.isEmpty()){
            nodeSequence.add(node);
            countMapper.put(node, countMapper.get(node)+1);
            checkEndCondition();
            return;
        }
        
        Node nextNode = curNode.sonQueue.poll();
        dfs(nextNode.num);
        curNode.sonQueue.add(nextNode);
    }
    
    public void initNodeMapper(){
        for(int i = 1; i<=100; i++){
            nodeMapper.put(i, new Node(i));
            countMapper.put(i, 0);
        }
    }
}

class Node{
    int num;
    Queue<Node> sonQueue;
    
    Node(int num){
        this.num = num;
        sonQueue = new LinkedList<>();
    }
}