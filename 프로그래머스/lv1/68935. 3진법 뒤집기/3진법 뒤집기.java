class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        String triple = Integer.toString(n,3);
        for(int i = triple.length()-1; i>=0; i--)
            sb.append(triple.charAt(i));
        
        int answer = Integer.valueOf(sb.toString(), 3);
        return answer;
    }
}