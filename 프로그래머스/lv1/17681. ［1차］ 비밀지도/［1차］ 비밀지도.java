class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for(int i = 0; i<answer.length; i++){
            answer[i] = decodeMap(arr1[i] | arr2[i], arr1.length);
        }
        
        return answer;
    }
    String decodeMap(int num, int leng){
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            if(num%2 == 0){
                sb.insert(0,"0");
            }
            else{
                sb.insert(0,"1");
            }
            num /= 2;
        }
        
        while(sb.length() < leng){
            sb.insert(0,"0");
        }
        
        return sb.toString().replace("1","#").replace("0"," ");
    }
}