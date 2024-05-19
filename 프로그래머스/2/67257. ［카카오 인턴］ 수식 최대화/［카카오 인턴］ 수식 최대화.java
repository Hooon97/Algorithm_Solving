import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        /*
            1. operand와 operator를 분리시켜 저장하는 list를 만든다.(최초 1회)
            2. *,+,-간의 우선순위 경우의 수를 만든다.
            3. 앞에서 검사하며, operator의 index, index+1의 숫자끼리 연산한다.
        */
        // 연산자 우선순위 permutation
        Character[][] operPrior = {
            {'*','+','-'},
            {'*','-','+'},
            {'+','*','-'},
            {'+','-','*'},
            {'-','*','+'},
            {'-','+','*'},
        };
        
        List<Long> operand = new ArrayList<>();
        List<Character> operator = new ArrayList<>();
        getOperList(operand, operator, expression);
        
        for(int i = 0; i<operPrior.length; i++){
            answer = Math.max(answer, calAbsNum(operand, operator, operPrior[i]));
        }
        
        
        return answer;
    }
    public long calAbsNum(List<Long> operand, List<Character> operator, Character[] prior){
        long result = 0;
        Deque<Long> nums = new LinkedList<>(operand);
        Queue<Character> synt = new LinkedList<>(operator);
        
        for(Character p : prior){
            Deque<Long> tmpNums = new LinkedList<>();
            Queue<Character> tmpSynt = new LinkedList<>();
            while(!synt.isEmpty()){
                Character curSynt = synt.poll();
                if(curSynt == p){
                    nums.addFirst(calNum(nums.poll(), nums.poll(), p));
                }
                else{
                    tmpNums.add(nums.poll());
                    tmpSynt.add(curSynt);
                }
            }
            if(!nums.isEmpty()) tmpNums.add(nums.poll());
            nums = tmpNums;
            synt = tmpSynt;
        }
        return Math.abs(nums.poll());
    }
    public long calNum(long num1, long num2, Character p){
        long result = 0;
        switch(p){
            case '+' : result = num1+num2;
                break;
            case '-' : result = num1-num2;
                break;
            default : result = num1*num2;   
        }
        return result;
    }
    
    public void getOperList(List<Long> operand, List<Character> operator, String exp){
        String[] sep = exp.split("\\*|\\-|\\+");
        char[] expArr = exp.toCharArray();
        for(String num : sep)
            operand.add(Long.valueOf(num));
        for(char c : expArr){
            if(c == '*' || c == '+' || c == '-')
                operator.add(c);
        }
        return;
    }
}