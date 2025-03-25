import java.util.*;
import java.text.SimpleDateFormat;

class Solution {
    /*
        1. today => date 기준으로 변환
        2. terms => Map or Array에 저장 후 find
        3. privacies를 돌며 최종 유효 기간 계산
            => date로 변환 후 today와 비교.
            => today보다 최종 유효 기간이 긴 경우 지나가고, 아니면 저장.
    */
    public int[] solution(String today, String[] terms, String[] privacies) throws Exception{
        int[] answer = {};
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms){
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.valueOf(termArr[1]));
        }
        
        List<Integer> ansList = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date toDate = sdf.parse(today);

        Calendar cal = Calendar.getInstance();
        int idx = 1;
        for(String privacy : privacies){
            String[] data = privacy.split(" ");
            Date dataDate = sdf.parse(data[0]);
            cal.setTime(dataDate);
            cal.add(Calendar.MONTH, termMap.get(data[1]));
            dataDate = cal.getTime();

            if(!toDate.before(dataDate)){
                ansList.add(idx);
            }
            idx++;
        }
        
        answer = new int[ansList.size()];
        for(int i = 0; i<answer.length; i++) answer[i] = ansList.get(i);
        
        return answer;
    }
}