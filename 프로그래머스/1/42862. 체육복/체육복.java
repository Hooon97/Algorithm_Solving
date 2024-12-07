import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        Set<Integer> lostDupChk = new HashSet<>();
        Set<Integer> reserveDupChk = new HashSet<>();

        for(int l : lost) lostDupChk.add(l);
        for(int r : reserve) reserveDupChk.add(r);
        for(int i = 0; i<lost.length; i++){
            if(reserveDupChk.contains(lost[i])) continue;
            lostList.add(lost[i]);
        }
        for(int i = 0; i<reserve.length; i++){
            if(lostDupChk.contains(reserve[i])) continue;
            reserveList.add(reserve[i]);
        }
        
        Collections.sort(lostList);
        Collections.sort(reserveList);
        answer = n - lostList.size();
        int lostIdx = 0;
        int reserveIdx = 0;
        while(lostIdx < lostList.size() && reserveIdx < reserveList.size()){
            int diff = lostList.get(lostIdx) - reserveList.get(reserveIdx);
            if(Math.abs(diff) == 1){
                answer++;
                lostIdx++;
                reserveIdx++;
            } else if(lostList.get(lostIdx) < reserveList.get(reserveIdx)){
                lostIdx++;
            } else{
                reserveIdx++;
            }
        }
        
        return answer;
    }
}