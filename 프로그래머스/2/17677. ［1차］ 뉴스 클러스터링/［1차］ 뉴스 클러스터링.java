import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        /*
        1. 문자열 다중 집합은 Map을 사용하여 만든다.
        2. 생성된 두 Map의 Key를 순회하며, 자카드 유사도를 계산한다.
        */
        int answer = 0;
        Map<String, Integer> grp1 = buildGroup(str1);
        Map<String, Integer> grp2 = buildGroup(str2);
        
        answer = calUnion(grp1, grp2);
        return answer;
    }
    public Map<String, Integer> buildGroup(String str){
        Map<String, Integer> grp = new HashMap<>();
        char[] charArr = str.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<charArr.length-1; i++){
            sb = new StringBuilder();
            for(int j = 0; j<2; j++){
                char cur = charArr[i+j];
                if(cur - 'a' < 0 || cur - 'a' >= 26) {
                    sb.setLength(0);
                    break;
                }
                sb.append(cur);
            }
            if(sb.length() == 2){
                String ele = sb.toString();
                int count = grp.getOrDefault(ele, 0)+1;
                grp.put(ele, count);
            }
        }
        
        return grp;
    }
    
    public int calUnion(Map<String, Integer> grp1, Map<String, Integer> grp2){
        int union = 0;
        
        Double maxSum = 0.0;
        Double minSum = 0.0;
        for(String key1 : grp1.keySet()){
            if(grp2.containsKey(key1)){
                maxSum += Math.max(grp1.get(key1), grp2.get(key1));
                minSum += Math.min(grp1.get(key1), grp2.get(key1));
            }
            else{
                maxSum += grp1.get(key1);
            }
        }
        
        for(String key2 : grp2.keySet()){
            if(!grp1.containsKey(key2))
                maxSum += grp2.get(key2);
        }
        
        if(minSum == 0 && maxSum == 0) return 65536;
        int sim = (int)(minSum*65536/maxSum);
        
        
        return sim;
    }
}