import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> rooms = new HashMap<>();
        for(int i = 0; i<room_number.length; i++){
            answer[i] = getEmptyRoom(room_number[i], rooms);
        }
        
        return answer;
    }
    public Long getEmptyRoom(Long target, Map<Long, Long> map){
        if(!map.containsKey(target)){
            map.put(target, target+1);
            return target;
        }
        Long nextRoom = map.get(target);
        Long emptyRoom = getEmptyRoom(nextRoom, map);
        
        map.put(target, emptyRoom);
        
        return emptyRoom;
    }
}