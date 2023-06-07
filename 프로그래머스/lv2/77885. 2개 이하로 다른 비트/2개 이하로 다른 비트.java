class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]%2 == 0) answer[i] = numbers[i]+1;
            else{
                 //2진수로 변환하여 전달
                String nextNum = Long.toString(numbers[i], 2);
                //함수에서 검사 및 변환
                nextNum = getMinValue(nextNum);
                //전달받은 문자열 2진수를 Long 타입으로 변환 후 입력
                answer[i] = Long.valueOf(nextNum, 2);   
            }
        }
        return answer;
    }
    public String getMinValue(String binaryString){
        if(!binaryString.contains("0")){
            return "10"+binaryString.substring(1);
        }
        else{
            StringBuilder sb = new StringBuilder();
            int lastIndex = binaryString.lastIndexOf("0");
            int firstIndex = binaryString.indexOf("1", lastIndex);
            sb.append(binaryString, 0, lastIndex).append("1");
            sb.append("0");
            sb.append(binaryString.substring(firstIndex+1));
            return sb.toString();
        }
    }
}