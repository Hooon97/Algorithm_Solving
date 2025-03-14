import java.util.*;

class Solution {
    int[] combSet;
    int[] answer;
    int SIZE;
    int[][] dice;
    HashMap<String, Long> winMemory;
    StringBuilder sb;
    public int[] solution(int[][] dices) {
        SIZE = dices.length/2;
        answer = new int[SIZE];
        combSet = new int[SIZE];
        winMemory = new HashMap<>();
        sb = new StringBuilder();
        dice = dices;
        
        createCombSet(combSet, 0, 0);
        
        long maxCnt = 0;
        String answerStr = "";
        for(String key : winMemory.keySet()){
            if(maxCnt <= winMemory.get(key)){
                maxCnt = winMemory.get(key);
                answerStr = key;
            }
        }
        
        String[] answerArr = answerStr.split("");
        for(int i = 0; i<SIZE; i++) answer[i] = Integer.valueOf(answerArr[i])+1;
        return answer;
    }
    
    public void createCombSet(int[] combSet, int start, int depth){
        if(depth == SIZE){
            
            String aStr = convertArrayToString(combSet);
            int[] pairComb = createPairCombSet(combSet);
            String bStr = convertArrayToString(pairComb);
            if(winMemory.containsKey(aStr) && winMemory.containsKey(bStr)) return;
            
            List<Integer> aList = createSumComb(combSet);
            List<Integer> bList = createSumComb(pairComb);
            getWinCnt(aList, aStr, bList, bStr);
            return;
        }
        
        for(int i = start; i<SIZE*2; i++){
            combSet[depth] = i;
            createCombSet(combSet, i+1, depth+1);
        }
    }
    
    public List<Integer> createSumComb(int[] comb){
        List<Integer> list = new ArrayList<>();
        createListSumComb(0, 0, comb, list);
        return list;
    }
    
    public void createListSumComb(int arrD, int sum, int[] comb, List<Integer> list){
        if(arrD == SIZE){
            list.add(sum);
            return;
        }
        
        int[] curArr = dice[comb[arrD]];
        for(int i = 0; i<6; i++){
            createListSumComb(arrD+1, sum+curArr[i], comb, list);
        }
    }
    
    public void getWinCnt(List<Integer> aList, String aStr, List<Integer> bList, String bStr){
        Collections.sort(aList);
        Collections.sort(bList);
        long aWin = 0;
        long bWin = 0;

        for(int i = 0; i<aList.size(); i++){
            int cnt = findMaxIndex(bList, aList.get(i));
            if(cnt < 0) cnt = bList.size();
            aWin += cnt;
        }
        
        for(int i = 0; i<bList.size(); i++){
            int cnt = findMaxIndex(aList, bList.get(i));
            if(cnt < 0) cnt = aList.size();
            bWin += cnt;
        }
        
        winMemory.put(aStr, aWin);
        winMemory.put(bStr, bWin);
    }
    
    public int findMaxIndex(List<Integer> list, int target){
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {  // list.get(mid) >= target
                right = mid - 1;
            }
        }
        return left;
    }
    
    public String convertArrayToString(int[] set){
        sb.setLength(0);
        for(int s : set) sb.append(s);
        return sb.toString();
    }
    
    public int[] createPairCombSet(int[] set){
        Set<Integer> chk = new HashSet<>();
        for(int n : set) chk.add(n);
        
        int[] result = new int[SIZE];
        int idx = 0;
        for(int i = 0; i<2*SIZE; i++){
            if(!chk.contains(i)) result[idx++] = i;
        }
        return result;
    }
}