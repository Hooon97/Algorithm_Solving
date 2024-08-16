class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long pNum = Long.valueOf(p);
        for(int i = 0; i<=t.length()-len; i++){
            long curNum = Long.valueOf(t.substring(i, len+i));
            if(pNum >= curNum) answer++;
        }
        
        return answer;
    }
}