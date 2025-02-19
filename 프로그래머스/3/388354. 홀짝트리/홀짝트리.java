import java.util.*;

class Solution {
    
    /*
        1. edges로 graph를 만든다.
        2. nodes의 원소를 순회하며 root 노드로 만들어 생성 가능한 트리를 검증한다.
        3. 이 때 최대 복잡도는 O(NM), 40만 * 100만 .. 
    */
    Map<Integer, Node> nodes;
    boolean flag;
    public int[] solution(int[] nodes_list, int[][] edges) {
        int[] answer = new int[2];
        nodes = new HashMap<>();
        flag = true;
        
        for(int i = 0; i<edges.length; i++){
            int N1 = edges[i][0];
            int N2 = edges[i][1];
            Node node1 = nodes.getOrDefault(N1, new Node(N1));
            Node node2 = nodes.getOrDefault(N2, new Node(N2));
            
            node1.next.add(N2);
            node2.next.add(N1);
            
            nodes.put(N1, node1);
            nodes.put(N2, node2);
        }
        
        for(int i = 0; i<nodes_list.length; i++){
            int num = nodes_list[i];
            if(!nodes.containsKey(num)) nodes.put(num, new Node(num));
            int size = nodes.get(num).next.size();
            
            if(num % 2 == size % 2){
                // 홀수_짝수
                flag = true;
                isGeneralTree(num, num);
                if(flag) {
                    answer[0] += 1;
                }
            } else{
                // 역홀수_짝수
                flag = true;
                isReverseTree(num, num);
                if(flag) answer[1] += 1;
            }
        }
        
        return answer;
    }
    
    public void isReverseTree(int root, int before){
        if(!flag) return;
        
        Node curNode = nodes.get(root);
        int size = curNode.next.size();
        if(size == 0){
            if(root % 2 == 0){
                flag = false;
            }
            return;
        }
        
        if(curNode.next.contains(before)) size -= 1;
        
        // 짝수라면 자식 노드의 개수가 홀수일때만 탐색
        if(curNode.num % 2 == 0){
            if(size % 2 == 1){
                for(int nextNum : curNode.next){
                    if(!flag) return;
                    if(nextNum == before) continue;
                    isReverseTree(nextNum, root);
                }
            } else{
                flag = false;
                return;
            }
        }
        // 홀수라면 자식 노드의 개수가 짝수일때만 탐색
        else{
            if(size % 2 == 0){
                for(int nextNum : curNode.next){
                    if(!flag) return;
                    if(nextNum == before) continue;
                    isReverseTree(nextNum, root);
                }
            } else{
                flag = false;
                return;
            }
        }
        
        return;
    }
    
    public void isGeneralTree(int root, int before){
        if(!flag) return;
        
        Node curNode = nodes.get(root);
        int size = curNode.next.size();
        if(size == 0){
            if(root % 2 != 0){
                flag = false;
            }
            return;
        }
        
        if(curNode.next.contains(before)) size -= 1;
        
        // 짝수라면 자식 노드의 개수가 짝수일때만 탐색
        if(curNode.num % 2 == 0){
            if(size % 2 == 0){
                for(int nextNum : curNode.next){
                    if(!flag) return;
                    if(nextNum == before) continue;
                    isGeneralTree(nextNum, root);
                }
            } else{
                flag = false;
                return;
            }
        }
        // 홀수라면 자식 노드의 개수가 홀수일때만 탐색
        else{
            if(size % 2 == 1){
                for(int nextNum : curNode.next){
                    if(!flag) return;
                    if(nextNum == before) continue;
                    isGeneralTree(nextNum, root);
                }
            } else{
                flag = false;
                return;
            }
        }
        
        return;
    }
    
    public class Node{
        int num;
        Set<Integer> next = new HashSet<>();
        
        Node(int num){
            this.num = num;
        }
        
        private void addNext(int next){
            this.next.add(next);
        }
    }
}