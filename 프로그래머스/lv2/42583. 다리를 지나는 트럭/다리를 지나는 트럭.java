import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> q = new LinkedList<>();
        int idx = 0;
        int answer = 0;
        int sumWeight = 0;
        
        while(idx < truck_weights.length){
            answer++;
            if(!q.isEmpty() && answer - q.peek().length == bridge_length){
                sumWeight -= q.poll().weight;
            }
            
            if(q.size() >= bridge_length) continue;
            if(sumWeight + truck_weights[idx] > weight) continue;
            
            sumWeight += truck_weights[idx];
            q.add(new Truck(truck_weights[idx], answer));
            idx++;
        }
        
        return answer+bridge_length;
    }
}
class Truck{
    int weight;
    int length;
    public Truck(int weight, int length){
        this.weight = weight;
        this.length = length;
    }
}