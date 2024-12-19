import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        Map<String, Integer> term = getTermsMapper(terms);
        int[] todayInt = convertDateToInt(today);
        
        for(int i = 0; i<privacies.length; i++){
            String[] info = privacies[i].split(" ");
            int[] curDate = convertDateToInt(info[0]);
            calculateDate(curDate, term.get(info[1]));
            if(deletable(todayInt, curDate)){
                list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
    
    public boolean deletable(int[] today, int[] data){
        int curDate = today[0]*12*28 + today[1]*28 + today[2];
        int dataDate = data[0]*12*28 + data[1]*28 + data[2];
        
        return curDate > dataDate;
    }
    
    public void calculateDate(int[] date, int month){
        date[1] += month;
        date[2] -= 1;
        
        if(date[2] == 0){
            date[1]--;
            date[2] = 28;
        }
        
        if(date[1] <= 0){
            date[0]--;
            date[1] = 12+date[1];
        } else if(date[1] > 12){
            date[0]++;
            date[1] -= 12;
        }
        
        return;
    }
    
    public int[] convertDateToInt(String date){
        String[] tmp = date.split("\\.");
        int[] result = new int[3];
        for(int i = 0; i<3; i++){
            result[i] = Integer.valueOf(tmp[i]);
        }
        return result;
    }
    
    public Map<String, Integer> getTermsMapper(String[] terms){
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<terms.length; i++){
            String[] e = terms[i].split(" ");
            map.put(e[0], Integer.valueOf(e[1]));
        }
        
        return map;
    }
}