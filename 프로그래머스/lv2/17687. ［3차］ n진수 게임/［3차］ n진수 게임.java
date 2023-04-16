class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        for(int i = 0; i<100001; i++){
            sb.append(Integer.toString(i, n));
        }
        
        answer = sb.toString();
        int charIdx = p-1;
        sb.setLength(0);
        while(sb.length() < t){
            sb.append(answer.charAt(charIdx));
            charIdx += m;
        }
        answer = sb.toString().toUpperCase();
        return answer;
    }
}