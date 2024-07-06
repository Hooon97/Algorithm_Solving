import java.util.*;

/*
    1. Y값 기준 내림차순, X값 기준 오름차순 시
        (8,7,1), (3,5,4), (11, 5, 2), (1, 3, 6), (5, 3, 1), (13, 3, 3) 순으로 정렬됨
    2. Root 노드를 기준으로 정한 뒤, 탐색하며 새로운 노드를 연결해준다.
*/


class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int nodeSize = nodeinfo.length;
        
        int[][] answer = new int[2][nodeSize];
        Node[] nodeArr = new Node[nodeSize];
        int val = 1;
        for(int[] node : nodeinfo){
            Node newNode = new Node(node[0], node[1], val);
            nodeArr[val-1] = newNode;
            val++;
        }
        
        // Y값 기준 내림차순, X값 기준 오름차순
        Arrays.sort(nodeArr, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                if(a.y == b.y){
                    return a.x - b.x;
                } else return b.y - a.y;
            }
        });
        
        Node root = nodeArr[0];
        for(int i = 1; i<nodeSize; i++){
            makeTree(root, nodeArr[i]);
        }
        
        List<Integer> ansList = new ArrayList<>();
        doPreOrder(root, ansList);
        for(int i = 0; i<nodeSize; i++)
            answer[0][i] = ansList.get(i);
        ansList = new ArrayList<>();
        
        doPost(root, ansList);
        for(int i = 0; i<nodeSize; i++)
            answer[1][i] = ansList.get(i);
        
        return answer;
    }
    
    public void doPreOrder(Node root, List<Integer> ansList){
        if(root == null) return;
        
        ansList.add(root.val);
        doPreOrder(root.left, ansList);
        doPreOrder(root.right, ansList);
    }
    
    public void doPost(Node root, List<Integer> ansList){
        if(root == null) return;
        
        doPost(root.left, ansList);
        doPost(root.right, ansList);
        ansList.add(root.val);
    }
    
    public void makeTree(Node root, Node child){
        if(root.x < child.x){
            // 새로운 노드가 오른쪽에 위치해있다면
            if(root.right != null) makeTree(root.right, child);
            else root.right = child;
        } else{
            if(root.left != null) makeTree(root.left, child);
            else root.left = child;
        }
    }
    
    class Node{
        int x;
        int y;
        int val;
        Node left;
        Node right;
        Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}