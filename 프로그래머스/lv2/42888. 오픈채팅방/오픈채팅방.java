import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int leng = 0;
        
        HashMap<String, String> name = new HashMap<>();
        for(int i = record.length-1; i>=0; i--){
            String[] tmp = record[i].split(" ");
            if(!tmp[0].equals("Leave") && !name.containsKey(tmp[1])){
                name.put(tmp[1], tmp[2]);
            }
            if(!tmp[0].equals("Change")) leng++;
        }
        
        String[] answer = new String[leng];
        int idx = 0;
        for(int i = 0; i<record.length; i++){
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Change")) continue;
            answer[idx++] = getMessage(tmp, name);
        }
        
        return answer;
    }
    public String getMessage(String[] tmp, HashMap<String, String> Id){
        StringBuilder sb = new StringBuilder();
        switch(tmp[0]){
            case "Enter" :
                sb.append(Id.get(tmp[1])).append("님이 들어왔습니다.");
                break;
            case "Leave" :
                sb.append(Id.get(tmp[1])).append("님이 나갔습니다.");
                break;
        }
        return sb.toString();
    }
}