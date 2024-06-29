/*
    1. 하나의 사이클을 형성하는 숫자의 집합이 존재한다.
    2. 사이클을 기록하는 배열을 생성하여, 아직 할당되지 않은 사이클들을 조사한다.
    3. 사이클(집합)의 크기 중 가장 큰 두 숫자를 곱하여 반환한다.
*/

import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int[] union = new int[cards.length];
        PriorityQueue<Integer> size = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<cards.length; i++){
            if(union[i] == 0){
                size.add(getSizeOfCycle(union, cards, i));
            }
        }
        if(size.size() == 1) return 0;
        return size.poll() * size.poll();
    }
    
    public int getSizeOfCycle(int[] union, int[] cards, int idx){
        int cnt = 0;
        int box = idx;
        while(union[box] == 0){
            cnt++;
            union[box] = 1;
            box = cards[box]-1;
        }
        
        return cnt;
    }
}