import java.util.*;

class Solution {
   public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i<numbers.length; i++) {
            String binaryTree = getBinaryTree(numbers[i]);
            if (verifyBinaryTree(binaryTree)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    private String getBinaryTree(long number) {
        String binary = Long.toBinaryString(number);
        int height = (int) Math.ceil(Math.log10(binary.length() + 1) / Math.log10(2));
        int size = (int) Math.pow(2, height) - 1;
        
        int dummy = size - binary.length();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dummy; i++) {
            sb.append("0");
        }
        
        sb.append(binary);
        return sb.toString();
    }

    public boolean verifyBinaryTree(String tree){
        if(tree.length() <= 1) return true;
        
        String left = tree.substring(0, tree.length()/2);
        String right = tree.substring(tree.length()/2+1);
        
        char root = tree.charAt(tree.length()/2);
        char leftNode = left.charAt(left.length()/2);
        char rightNode = right.charAt(right.length()/2);
        
        if(root == '0' && (leftNode == '1' || rightNode == '1')) return false;
        else return verifyBinaryTree(left) && verifyBinaryTree(right);
    }
}