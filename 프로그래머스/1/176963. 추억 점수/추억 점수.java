import java.util.*;
class Solution {
    public int[] solution(String[] names, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> score = new HashMap<>();
        for(int i = 0; i<names.length; i++) score.put(names[i], yearning[i]);
        
        int sum = 0;
        for(int i = 0; i<photo.length; i++){
            String[] col = photo[i];
            sum = 0;
            for(String row : col) sum += score.getOrDefault(row, 0);
            answer[i] = sum;
        }
        
        return answer;
    }
}