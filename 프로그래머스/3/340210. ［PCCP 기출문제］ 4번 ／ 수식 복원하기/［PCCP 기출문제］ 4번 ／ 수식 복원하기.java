import java.util.*;

class Solution {
    List<String> infoList;
    List<String> answerList;
    Set<Integer> possibleNums;
    int minNum;
    public String[] solution(String[] expressions) {
        String[] answer = {};
        infoList = new ArrayList<>();
        answerList = new ArrayList<>();
        possibleNums = new HashSet<>();
        for(String exp : expressions){
            String[] expArr = exp.split(" ");
            if(expArr[4].equals("X")) answerList.add(exp);
            else infoList.add(exp);
            
            for(int i = 0; i<5; i++){
                if(expArr[i].equals("X") || expArr[i].equals("-") || 
                   expArr[i].equals("+") || expArr[i].equals("=")) continue;
                for(char c : expArr[i].toCharArray()){
                    minNum = Math.max(minNum, c-'0');
                }
            }
        }
        
        for(int i = minNum+1; i<10; i++) possibleNums.add(i);
        
        answer = new String[answerList.size()];
        checkInfoList();
        for(int i = 0; i<answer.length; i++){
            answer[i] = checkAnswerList(i);
        }
        
        return answer;
    }
    
    public String checkAnswerList(int idx){
        String expression = answerList.get(idx);
        String[] exp = expression.split(" ");
        if(isAmbigious(exp)){
            exp[4] = "?";
        }
        String result = "";
        for(int i = 0; i<4; i++){
            result += exp[i]+" ";
        }
        result += exp[4];
        return result;
    }
    
    public boolean isAmbigious(String[] exp){
        Set<String> chk = new HashSet<>();
        for(int posNum : possibleNums){
            int num1 = calculate(posNum, exp[0]);
            int num2 = calculate(posNum, exp[2]);
            int num3 = 0;
            if(exp[1].equals("+")) num3 = num1 + num2;
            else num3 = num1 - num2;
            String expResult = convertToAns(posNum, num3);
            exp[4] = expResult;
            chk.add(expResult);
        }
        
        return chk.size() != 1;
    }
    
    public String convertToAns(int num, int target){
        if(target == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while(target > 0){
            sb.append(target%num);
            target /= num;
        }
        return sb.reverse().toString();
    }
    
    public void checkInfoList(){
        for(String info : infoList){
            List<Integer> tmpRemoveNums = new LinkedList<>();
            for(int i : possibleNums){
                if(isCalculable(i, info)) continue;
                else{
                    tmpRemoveNums.add(i);
                }
            }
            for(int i : tmpRemoveNums) possibleNums.remove(i);
        }
    }
    
    public boolean isCalculable(int num, String expression){
        String[] exp = expression.split(" ");
        int num1 = calculate(num, exp[0]);
        int num2 = calculate(num, exp[2]);
        int num3 = calculate(num, exp[4]);
        if(exp[1].equals("+")){
            return num1+num2 == num3;   
        } else{
            return num1-num2 == num3;
        }
    }
    
    public int calculate(int num, String target){
        int result = 0;
        char[] tArr  = target.toCharArray();
        for(int i = 0; i<tArr.length; i++){
            result +=  (tArr[i] - '0') * Math.pow(num, tArr.length-1-i);
        }
        return result;
    }
}
