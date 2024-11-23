class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int left = 0;
        int right = 0;
        String card1 = cards1[left];
        String card2 = cards2[right];
        for(int i = 0; i<goal.length; i++){
            String cur = goal[i];
            if(left < cards1.length && cur.equals(card1)){
                left++;
            } else if(right < cards2.length && cur.equals(card2)){
                right++;
            } else if(!cur.equals(card1) && !cur.equals(card2)){
                return "No";
            }
            
            if(left < cards1.length) card1 = cards1[left];
            if(right < cards2.length) card2 = cards2[right];
        }
        
        return "Yes";
    }
}