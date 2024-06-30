import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmds) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> storage = new Stack<>();
        int curRow = k;
        int curSize = n;
        
        for(String cmd : cmds){
            if(cmd.equals("C")){
                storage.add(curRow);
                curSize--;
                if(curSize-1 < curRow) curRow--;
            }
            else if(cmd.equals("Z")){
                int mry = storage.pop();
                if(mry <= curRow) curRow++;
                curSize++;
            }
            else{
                String[] move = cmd.split(" ");
                if(move[0].equals("U")) curRow -= Integer.parseInt(move[1]);
                else curRow += Integer.parseInt(move[1]);
            }
        }
        
        for(int i = 0; i<curSize; i++)
            sb.append("O");
        while(!storage.isEmpty())
            sb.insert(storage.pop(), "X");
        return sb.toString();
    }
}