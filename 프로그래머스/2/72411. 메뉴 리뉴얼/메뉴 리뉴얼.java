import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        /*
            1. course의 크기 별로 계산한 값을 ansList에 저장한다.
            2. 생성 가능한 길이별 메뉴의 조합은 Map에 저장한다.
            3. Map의 key를 순회하며, 최대값 value를 찾는다.
        */
        
        List<String> ansList = new ArrayList<>();
        
        for(int len : course){
            Map<String, Integer> combCnt = new HashMap<>();
            getCombination(len, orders, combCnt);
            getMaxOrder(combCnt, ansList);
        }
        
        Collections.sort(ansList);
        answer = new String[ansList.size()];
        for(int i = 0; i<ansList.size(); i++){
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
    
    public void getCombination(int l, String[] orders, Map<String, Integer> cnt){
        for(String order : orders){
            if(order.length() < l) continue;
            char[] sepOrder = order.toCharArray();
            comb(l, 0, sepOrder, cnt, new StringBuilder());
        }
        
        return;
    }
    public void comb(int depth, int idx, char[] data, 
                    Map<String, Integer> map, StringBuilder sb){
        if(sb.length() == depth){
            String str = sb.toString();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            str = new String(arr);
            map.put(str, map.getOrDefault(str,0)+1);
            return;
        }
        if(idx >= data.length) return;
        
        sb.append(data[idx]);
        comb(depth, idx+1, data, map, sb);
        sb.deleteCharAt(sb.length()-1);
        comb(depth, idx+1, data, map, sb);
        
        return;
    }
    
    public void getMaxOrder(Map<String, Integer> cnt, List<String> ansList){
        int maxCnt = 0;
        for(String key : cnt.keySet())
            maxCnt = Math.max(maxCnt, cnt.get(key));
        if(maxCnt == 1) return;
        for(String key : cnt.keySet()){
            if(cnt.get(key) == maxCnt)
                ansList.add(key);
        }
        
        return;
    }
}