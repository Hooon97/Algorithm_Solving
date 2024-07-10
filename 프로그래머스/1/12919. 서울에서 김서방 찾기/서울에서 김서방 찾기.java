class Solution {
    public String solution(String[] seoul) {
        int ans = 0;
        for(int i = 0; i<seoul.length; i++)
            if(seoul[i].equals("Kim")){
                ans = i;
                break;
            }
        String answer = String.format("김서방은 %d에 있다", ans);
        return answer;
    }
}