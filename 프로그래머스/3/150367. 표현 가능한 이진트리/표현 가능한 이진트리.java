class Solution {
    StringBuilder sb;
    public int[] solution(long[] numbers) {
        /*
            생성이 불가능한 경우
            = 자식 노드는 있는데 부모 노드가 없는 경우
        */
        sb = new StringBuilder();
        int[] answer = new int[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            String binary = getPaddedBinary(numbers[i]);
            if(DFS(binary)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
    /*
        서브 트리를 기준으로 보았을 때 1개(최상위 루트), 3개의 노드로 분할 된다.
        이 때 0,2번 노드가 자식, 1번 노드가 부모이다.
        0,2는 존재하는데 1번 노드가 0이면 불가능한 케이스다.
    */
    public boolean DFS(String binary){
        if(binary.length() <= 1) return true;
        
        int size = binary.length();
        String leftSubTree = binary.substring(0, size/2);
        String rightSubTree = binary.substring(size/2+1, size);
        
        char root = binary.charAt(size/2);
        char leftNode = leftSubTree.charAt(leftSubTree.length()/2);
        char rightNode = rightSubTree.charAt(rightSubTree.length()/2);
        if(root == '0' && (leftNode == '1' || rightNode == '1')) return false;
        return DFS(leftSubTree) && DFS(rightSubTree);
        
    }
    /*
                    노드 개수   높이
        1           1           1
        1+2         3           2
        1+2+4       7           3
        1+2+4+8     15          4
        => 주어진 숫자를 10진수에서 2진수로 변경했을 때, 자릿수의 개수를 기준으로 높이 계산이 가능함
    */
    public String getPaddedBinary(long number){
        sb.setLength(0);
        String tmp = Long.toBinaryString(number);
        int height = (int) Math.ceil(Math.log10(tmp.length()+1) / Math.log10(2)); // 높이
        int cnt = (int) Math.pow(2, height) -1; // 총 노드의 개수
        
        int paddingCnt = cnt - tmp.length();
        
        for(int i = 0; i<paddingCnt; i++) sb.append(0); // 패딩
        sb.append(tmp);
        return sb.toString();
    }
    
    public long getNodeCount(long number){
        for(long i = 1; i<number; i++){
            if(Math.pow(2,i) >= number ){
                return i;
            }
        }
        return number;
    }
}