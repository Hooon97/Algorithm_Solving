import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] str = s.substring(2,s.length()-2).replaceAll(",\\{", "").split("\\}");
        String num = "";
        for(int i = 0; i<str.length; i++) num = num.length() > str[i].length() ? num : str[i];
        
        Arrays.sort(str, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        
        HashSet<String> dupCheck = new HashSet<>();
        int[] answer = new int[str.length];
        for(int i = 0; i<answer.length; i++){
            String[] tmp = str[i].split(",");
            String val = tmp[0];
            for(int j = 0; j<tmp.length; j++){
                if(dupCheck.contains(tmp[j])) continue;
                val = tmp[j];
                dupCheck.add(val);
            }
            answer[i] = Integer.valueOf(val);
        }
        
        return answer;
    }
}